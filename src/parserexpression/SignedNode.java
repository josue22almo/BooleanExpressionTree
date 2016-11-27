
package parserexpression;

import java.util.LinkedList;

/**
 *
 * @author Josue Inaldo Alcantara Moreno
 */
public class SignedNode extends OperationExpressionNode {

    LinkedList<ExpressionNode> operands;

    public SignedNode() {
        this.operands = new LinkedList<>();
    }

    SignedNode(ExpressionNode exp, boolean signed) {
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
