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
public class Term {
    
    public boolean negated;
    public ExpressionNode expression;

    public Term(boolean negated, ExpressionNode expression) {
      super();
      this.negated = negated;
      this.expression = expression;
    }
}
