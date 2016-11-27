
package parserexpression;

/**
 *
 * @author Josue Inaldo Alcantara Moreno
 */
public class SentencesExpressionNode extends ValueExpressionNode{

    private String frase;
    private boolean first = true;
    
    public SentencesExpressionNode(){
        super();
        frase = "";
    }
    
    @Override
    public void addWord(String word) {
        if(first){
            frase += word;
            first = false;
        }else frase += " " + word;
    }

    @Override
    public int getType() {
        return Values.SENTENCES_NODE;
    }

    @Override
    public boolean getValue(Frase f) {
        System.out.println("Set expression node bool "+ frase.contains(frase));
        return f.contains(frase);
    }
    
}
