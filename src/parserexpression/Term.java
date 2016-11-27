
package parserexpression;

/**
 *
 * @author Josue Inaldo Alcantara Moreno
 */
public class Term {
    
    public boolean negated;
    public ExpressionNode expression;

    public Term(boolean negated, ExpressionNode expression) {
      super();
      this.negated = negated;
      this.expression = expression;
    }
}
