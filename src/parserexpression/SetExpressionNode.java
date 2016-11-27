/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserexpression;

import java.util.ArrayList;

/**
 *
 * @author alumne
 */
public class SetExpressionNode extends ValueExpressionNode{
    
    private ArrayList<String> words;

    
    public SetExpressionNode(){
        super();
        words = new ArrayList<>();
    }
    
    @Override
    public void addWord(String word) {
        words.add(word);
    }

    @Override
    public int getType() {
        return Values.SET_NODE;
    }

    @Override
    public boolean getValue(Frase frase) {
        return frase.contains(words);
    }   
}
