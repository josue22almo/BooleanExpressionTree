
package parserexpression;

import java.util.LinkedList;

/**
 *
 * @author Josue Inaldo Alcantara Moreno
 */
public class Main {

    public static void main(String[] args) throws Exception{
        try{
            Frase frase = new Frase();
            frase.addPalabra("p1");
            frase.addPalabra("p2");
            frase.addPalabra("p3");
            frase.addPalabra("hola");
            frase.addPalabra("adios");
            frase.addPalabra("juan");
            Analizador analizador = new Analizador();
            analizador.analizarExpresion("({p1 p2 p3} & (\"hola adios\" | pepe)) & !juan ");
            ParserExpression parserExpression = new ParserExpression();
            LinkedList <Token> l = analizador.getTokens();
            ExpressionNode exp = parserExpression.parse(l);
            System.out.println("Boolean = " + exp.getValue(frase));
        } catch(Exception e){
           System.out.println(e.getMessage());
        }
    }
}
