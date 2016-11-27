
package parserexpression;

import java.util.LinkedList;
import jdk.nashorn.internal.runtime.ParserException;

/**
 *
 * @author Josue Inaldo Alcantara Moreno
 */
public class Main {

    public static void main(String[] args) throws Exception{
        //try{
        Frase frase = new Frase();
        frase.addPalabra("p1");
        frase.addPalabra("p2");
        frase.addPalabra("p3");
        frase.addPalabra("hola");
        frase.addPalabra("adios");
//        frase.addPalabra("juan");
        Analizador analizador = new Analizador();
        analizador.analizarExpresion("({p1 p2 p3} & (\"hola adios\" | pepe)) & !juan ");
        ParserExpression parserExpression = new ParserExpression();
        LinkedList <Token> l = analizador.getTokens();
        ExpressionNode exp = parserExpression.parse(l);
                System.out.println();
        System.out.println("Boolean = " + exp.getValue(frase));
        
        
        
        
        /*AndNode and2 = new AndNode();
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
        System.out.println("Booelan = " + and.getValue(frase));*/
    }
}
