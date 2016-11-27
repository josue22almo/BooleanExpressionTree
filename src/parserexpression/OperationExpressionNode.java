
package parserexpression;

import java.util.LinkedList;
/**
 *
 * @author Josue Inaldo Alcantara Moreno
 */
public abstract class OperationExpressionNode implements ExpressionNode{
    protected LinkedList<Term> terms;

    public OperationExpressionNode() {
      this.terms = new LinkedList<>();
    }

    public OperationExpressionNode(ExpressionNode a, boolean signed) {
      this.terms = new LinkedList<>();
      this.terms.add(new Term(signed, a));
    }

    public void add(ExpressionNode a, boolean signed) {
      this.terms.add(new Term(signed, a));
    }
}
