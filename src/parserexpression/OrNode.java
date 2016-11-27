
package parserexpression;

/**
 *
 * @author Josue Inaldo Alcantara Moreno
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
       boolean b = false;
       for(Term term : terms){
           if (term.negated) 
               b = b || !term.expression.getValue(frase);
           else b = b || term.expression.getValue(frase);
       }
       return b;
    }
}
