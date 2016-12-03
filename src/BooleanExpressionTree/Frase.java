
package BooleanExpressionTree;
/**
 *
 * @author Josue Inaldo Alcantara Moreno
 */
import java.util.ArrayList;

public class Frase {
    private ArrayList<String> frase;
    public String strFrase;
    
    public Frase() {
        this.frase = new ArrayList<>();
    }
    
    public Frase(String frase) {
        this.strFrase = frase;
        this.frase = new ArrayList<>();
        String palabra = "";
        for (int i = 0; i < frase.length(); ++i){
            if (frase.charAt(i) != ' ') palabra += frase.charAt(i);
            else{
                this.frase.add(palabra);
                palabra = "";
            }
        }
        this.frase.add(palabra);
    }
       
    public ArrayList<String> getFrase(){
        return frase;
    }

    boolean contains(String frase) {
        boolean b = this.strFrase.contains(frase);
        return b;
    }
    
    boolean contains(ArrayList<String> words) {
        boolean b = true;
        for (int i = 0; i < words.size() && b;++i){
            b = frase.contains(words.get(i));
        }
        return b;
    }
}