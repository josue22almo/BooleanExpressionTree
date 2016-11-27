
package parserexpression;
/**
 *
 * @author Josue Inaldo Alcantara Moreno
 */
public class Token {
    public final int token;
    public final String sequence;

    public Token(int token, String sequence)
    {
      super();
      this.token = token;
      this.sequence = sequence;
    }
}