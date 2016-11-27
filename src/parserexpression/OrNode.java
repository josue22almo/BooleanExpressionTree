/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserexpression;

/**
 *
 * @author alumne
 */
public class OrNode extends OperationExpressionNode{
    
    public OrNode() {
        super();
      }

      public OrNode(ExpressionNode node,boolean signed) {
        super(node, signed);
      }
    
    @Override
    public int getType() {
        return Values.OR_NODE;
    }

    @Override
    public boolean getValue(Frase frase) {
       boolean b = true;
       for(Term term : terms){
           if (term.negated) b = b || !term.expression.getValue(frase);
           else b = b || term.expression.getValue(frase);
       }
       return b;
    }
}
