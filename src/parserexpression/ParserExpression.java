
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
            if (top.token != TokenValues.EPSILON)
              throw new Exception("Unexpected symbol found " +  top.sequence);
        }        
  }

    
    private void expression()throws Exception{
        // expression -> signed_term op
//        System.out.println("expression " + top.token + " " + top.sequence);
        signed_term();
        op();
    } 
    
    private void signed_term() throws Exception{
//        System.out.println("signed term " + top.token + " " + top.sequence);
        if (top.token == TokenValues.NOT){
            //signed_term -> NOT term()
            nextToken();
            term();
        }else term();  //signed_term -> term
    }
    
    private void op() throws Exception{
//        System.out.println("op " + top.token + " " + top.sequence);
        if (top.token == TokenValues.AND || top.token == TokenValues.OR){
            //op -> AND term expression || op -> OR term expression
            nextToken();
            expression();
        }
    }
    
    private void term() throws Exception{
//        System.out.println("term " + top.token + " " + top.sequence);
        switch (top.token){
            case TokenValues.COMA:
                //term -> COMA argument COMA
                nextToken();
                argument();
                if (top.token != TokenValues.COMA) 
                    throw new Exception("Se esperaban comillas, pero se ha encontrado " + top.sequence);
                nextToken();                
                break;
            case TokenValues.OC_BRACKET:
                //term -> OC_BRACKET argument CC_BRACKET
                nextToken();
                argument();
                if (top.token != TokenValues.CC_BRACKET) 
                    throw new Exception("Se esperaba un }, pero se ha encontrado " + top.sequence);
                nextToken();
                break;
            case TokenValues.OPEN_BRACKET:
                //term -> OPEN_BRACKET expression CLOSE_BRACKET
                nextToken();
                expression();
                if(top.token != TokenValues.CLOSE_BRACKET)
                    throw new Exception("Se esperaba un ), pero se ha encontrado " + top.sequence);
                nextToken();
                break;
            default:
                //term -> argument
                argument();
        }
    }
    
    private void argument(){
//        System.out.println("argument " + top.token + " " + top.sequence);
        if (top.token == TokenValues.WORD){
            //argument -> WORD argument
            nextToken();
            argument();
        } 
    }
    
    private void nextToken(){
       // if (!tokens.isEmpty())
            tokens.pop();
        // at the end of input we return an epsilon token
        if (tokens.isEmpty())
          top = new Token(TokenValues.EPSILON,"");
        else
          top = tokens.getFirst();
    }
    
}