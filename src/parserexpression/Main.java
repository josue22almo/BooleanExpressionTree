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
            Analizador analizador = new Analizador();
            analizador.analizarExpresion("{p1 p2 p3} & (\"hola adiós\" | pepe) & !juan & !{p1 p2 p3} & (\"hola adiós\" | pepe) & !juan | (!juan & !{p1 p2 p3} & (\"hola adiós\" | pepe)) & !({p1 p2 p3} & (\"hola adiós\" | pepe) & !juan & !{p1 p2 p3} & (\"hola adiós\" | pepe) & !juan | (!juan & !{p1 p2 p3} & (\"hola adiós\" | pepe)))");
            ParserExpression parserExpression = new ParserExpression();
            LinkedList <Token> l = analizador.getTokens();
//            System.out.print(analizador.toString());
            parserExpression.parse(l);
    }
    
}
