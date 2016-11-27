
package parserexpression;

import java.util.LinkedList;

/**
 *
 * @author josue.inaldo.alcantara
 */
public class ParserExpression {
    private LinkedList<Token> tokens;
    private Token top;

    public ParserExpression() {
        this.tokens = new LinkedList<>();
    }
    
    
    
    public void parse(LinkedList<Token> tokens) throws Exception{
        if (!tokens.isEmpty()){
            this.tokens = (LinkedList)tokens.clone();
            top = this.tokens.get(0);
            expression();
            if (top.token != Values.EPSILON)
              throw new Exception("Unexpected symbol found " +  top.sequence);
        }        
  }

    
    private ExpressionNode expression()throws Exception{
        // expression -> signed_term op
//        System.out.println("expression " + top.token + " " + top.sequence);
        signed_term();
        op();
    } 
    
    private ExpressionNode signed_term() throws Exception{
//        System.out.println("signed term " + top.token + " " + top.sequence);
        if (top.token == Values.NOT){
            //signed_term -> NOT term()
            nextToken();
            term();
            return new OperationNode(term(),true);
        }else return term();  //signed_term -> term
    }
    
    private void op() throws Exception{
//        System.out.println("op " + top.token + " " + top.sequence);
        if (top.token == Values.AND || top.token == Values.OR){
            //op -> AND term expression || op -> OR term expression
            nextToken();
            expression();
        }
    }
    
    private ExpressionNode term() throws Exception{
//        System.out.println("term " + top.token + " " + top.sequence);
        ExpressionNode exp;
        switch (top.token){
            case Values.COMA:
                //term -> COMA argument COMA
                nextToken();
                exp = argument_comas();
                if (top.token != Values.COMA) 
                    throw new Exception("Se esperaban comillas, pero se ha encontrado " + top.sequence);
                nextToken();                
                return exp;
            case Values.OC_BRACKET:
                //term -> OC_BRACKET argument CC_BRACKET
                nextToken();
                exp = argument_curly_brackets();
                argument_curly_brackets();
                if (top.token != Values.CC_BRACKET) 
                    throw new Exception("Se esperaba un }, pero se ha encontrado " + top.sequence);
                nextToken();
                return exp;
            case Values.OPEN_BRACKET:
                //term -> OPEN_BRACKET expression CLOSE_BRACKET
                nextToken();
                exp = expression();
                if(top.token != Values.CLOSE_BRACKET)
                    throw new Exception("Se esperaba un ), pero se ha encontrado " + top.sequence);
                nextToken();
                return exp;
            default:
                //term -> argument
                return argument_curly_brackets();
        }
    }
    
    private ExpressionNode argument_curly_brackets(){
//        System.out.println("argument " + top.token + " " + top.sequence);
        SetExpressionNode result = new SetExpressionNode();
        while (top.token == Values.WORD){
            //argument -> WORD argument
            result.addWord(top.sequence);
            nextToken();
        } 
        return result;
    }
    
    private ExpressionNode argument_comas(){
        SentencesExpressionNode result = new SentencesExpressionNode();
        while (top.token == Values.WORD){
            //argument -> WORD argument
            result.addWord(top.sequence);
            nextToken();
        } 
        return result;
    }
    
    private void nextToken(){
        tokens.pop();
        // at the end of input we return an epsilon token
        if (tokens.isEmpty())
          top = new Token(Values.EPSILON,"");
        else
          top = tokens.getFirst();
    }
    
}