/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserexpression;

import java.util.LinkedList;
import jdk.nashorn.internal.runtime.ParserException;

/**
 *
 * @author alumne
 */
public class Main {

    public static void main(String[] args) throws Exception{
        //try{
     /*       Analizador analizador = new Analizador();
            analizador.analizarExpresion("{p1 p2 p3} & (\"hola adiós\" | pepe) & !juan & !{p1 p2 p3} & (\"hola adiós\" | pepe) & !juan | (!juan & !{p1 p2 p3} & (\"hola adiós\" | pepe)) & !({p1 p2 p3} & (\"hola adiós\" | pepe) & !juan & !{p1 p2 p3} & (\"hola adiós\" | pepe) & !juan | (!juan & !{p1 p2 p3} & (\"hola adiós\" | pepe)))");
            ParserExpression parserExpression = new ParserExpression();
            LinkedList <Token> l = analizador.getTokens();
//            System.out.print(analizador.toString());
            parserExpression.parse(l);*/
        
        Frase frase = new Frase();
        frase.addPalabra("p1");
        frase.addPalabra("p2");
        frase.addPalabra("p3");
        frase.addPalabra("hola");
        frase.addPalabra("adios");
        //frase.addPalabra("juan");
        
        
        AndNode and2 = new AndNode();
        SetExpressionNode juan = new SetExpressionNode();
        juan.addWord("juan");        
        and2.add(juan, true);
        OrNode or = new OrNode();
        SentencesExpressionNode holaAdios = new SentencesExpressionNode();
        holaAdios.addWord("hola adios");
        or.add(holaAdios, false);
        SetExpressionNode pepe = new SetExpressionNode();
        pepe.addWord("pepe");
        or.add(pepe,false);        
        and2.add(or,false);  
        AndNode and = new AndNode();
        and.add(and2,false);
        SetExpressionNode p = new SetExpressionNode();
        p.addWord("p1");
        p.addWord("p2");
        p.addWord("p3");
        and.add(p, false);    
        System.out.println("Booelan = " + and.getValue(frase));
    }
}
