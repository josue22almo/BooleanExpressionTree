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
        boolean b = true;
        for(ExpressionNode exp : operands){
            b = b & exp.getValue(frase);
        }
        return b;
    }
    
}
