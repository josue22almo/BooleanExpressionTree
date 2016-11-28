
package parserexpression;

/**
 *
 * @author Josue Inaldo Alcántara Moreno
 */

import java.util.LinkedList;

public class ParserExpression {
    private LinkedList<Token> tokens;
    private Token top;

    public ParserExpression() {
        this.tokens = new LinkedList<>();
    }
    
    
    
    public ExpressionNode parse(LinkedList<Token> tokens) throws Exception{
        this.tokens = (LinkedList)tokens.clone();
        top = this.tokens.get(0);
        ExpressionNode result = expression();
        if (top.token != Values.EPSILON)
          throw new Exception("Símbolo inesperado" +  top.sequence);
        return result;
  }

    
    private ExpressionNode expression()throws Exception{
        // expression -> signed_term op
        ExpressionNode exp = signed_term();
        ExpressionNode result = op(exp);
        return result;
    } 
    
    private ExpressionNode signed_term() throws Exception{
        ExpressionNode result;
        if (top.token == Values.NOT){
            //signed_term -> NOT term()
            nextToken();
            ExpressionNode term = term();
            result = new NegatedNode(term,true);
        }else result = term();  //signed_term -> term
        return result;
    }
    
    private ExpressionNode op(ExpressionNode exp) throws Exception{
        if (top.token == Values.AND || top.token == Values.OR){
            //op -> AND term expression
            OperationExpressionNode result;
            if (top.token == Values.AND){
                result = new AndNode(exp,false);
            }else{
                result = new OrNode(exp,false);
            }
            boolean signed = top.sequence.equals("!");
            nextToken();
            ExpressionNode e = expression();
            result.add(e, signed);
            return result;
        }
        return exp;
    }
    
    private ExpressionNode term() throws Exception{
        ExpressionNode exp;
        switch (top.token){
            case Values.COMA:
                //term -> COMA argument COMA
                nextToken();
                exp = argument_comas();
                if (top.token != Values.COMA) 
                    throw new Exception("No se han encontrado las comillas de cierre");
                nextToken();                
                break;
            case Values.OC_BRACKET:
                //term -> OC_BRACKET argument CC_BRACKET
                nextToken();
                exp = argument_curly_brackets();
                //argument_curly_brackets();
                if (top.token != Values.CC_BRACKET) 
                    throw new Exception("No se han cerrado alguno de los curly brackets {}");
                nextToken();
                break;
            case Values.OPEN_BRACKET:
                //term -> OPEN_BRACKET expression CLOSE_BRACKET
                nextToken();
                exp = expression();
                if(top.token != Values.CLOSE_BRACKET)
                    throw new Exception("No se han cerrado alguno de los parentesis");
                nextToken();
                break;
            default:
                //term -> argument
                exp = argument_curly_brackets();
                break;
        }
        return exp;
    }
    
    private ExpressionNode argument_curly_brackets(){
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