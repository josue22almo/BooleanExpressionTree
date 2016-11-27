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
public abstract class ValueExpressionNode implements ExpressionNode{
    
    public ValueExpressionNode(){}
    public abstract void addWord(String word);
}
