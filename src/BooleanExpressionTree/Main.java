
package BooleanExpressionTree;

import java.util.LinkedList;

/**
 *
 * @author Josue Inaldo Alcantara Moreno
 */
public class Main {

    public static void main(String[] args) throws Exception{
        try{
            Frase frase = new Frase("p1 p3 hola adios p2 p3");
            Analizador analizador = new Analizador();
            analizador.analizarExpresion("({p1 p2 p3} & (\"hola adios\" | pepe)) & !juan ");
            BooleanTree parserExpression = new BooleanTree();
            LinkedList <Token> l = analizador.getTokens();
            ExpressionNode exp = parserExpression.satisfy(l);
            System.out.println("Boolean = " + exp.getValue(frase));
        } catch(Exception e){
           System.out.println(e.getMessage());
        }
    }
}
