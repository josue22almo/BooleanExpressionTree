/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserexpression;

import java.util.LinkedList;

/**
 *
 * @author alumne
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
