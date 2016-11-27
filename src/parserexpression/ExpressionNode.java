/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserexpression;

/**
 *
 * @author Josue Inaldo Alcantara Moreno
 */
public interface ExpressionNode {
    
    public int getType();
    public boolean getValue(Frase frase);

   // public void add(ExpressionNode expression, boolean b);
}
