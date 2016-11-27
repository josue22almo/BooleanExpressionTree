
package parserexpression;

/**
 *
 * @author Josue Inaldo Alcantara Moreno
 */
public class Values {
    
    //for tokens type
    public static final int EPSILON = 0;
    public static final int OPEN_BRACKET = 1;
    public static final int CLOSE_BRACKET = 2;
    public static final int CC_BRACKET = 3;
    public static final int OC_BRACKET = 4;
    public static final int AND = 5;
    public static final int OR = 6;
    public static final int NOT = 7;
    public static final int COMA = 8;
    public static final int WORD = 9;
    public static final int ESPACIO = 10;
    //for nodes type
    public static final int AND_NODE = 11;
    public static final int OR_NODE = 12;
    public static final int SET_NODE = 13;
    public static final int SENTENCES_NODE = 14;
    public static final int OPERATION_NODE = 15;
 // es NECESARIO?? CREO QUE NO PORQUE TERM ES TIENE UN ExpressionNode   public final int PARENTESIS_NODE = 5;
}
