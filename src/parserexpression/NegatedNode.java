
package parserexpression;

import java.util.LinkedList;

/**
 *
 * @author Josue Inaldo Alcantara Moreno
 */
public class NegatedNode extends OperationExpressionNode {

    LinkedList<ExpressionNode> operands;

    public NegatedNode() {
        this.operands = new LinkedList<>();
    }

    NegatedNode(ExpressionNode exp, boolean signed) {
        super(exp,signed);
    }
    
    @Override
    public int getType() {
        return Values.OPERATION_NODE;
    }

    @Override
    public boolean getValue(Frase frase) {
        boolean b = false;
        for(Term term : terms){
            if (term.negated)
                b = !term.expression.getValue(frase);
            else b = term.expression.getValue(frase);
        }
        return b;
    }
    
}
