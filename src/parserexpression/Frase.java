
package parserexpression;
/**
 *
 * @author Josue Inaldo Alcantara Moreno
 */
import java.util.ArrayList;

public class Frase {
    private ArrayList<String> frase;
    
    public Frase() {
        this.frase = new ArrayList<>();
    }
        
    public void addPalabra (String palabra){
        frase.add(palabra);
    }
    
    public ArrayList<String> getFrase(){
        return frase;
    }

    boolean contains(String frase) {
        boolean b = string().contains(frase);
        return b;
    }
    
    boolean contains(ArrayList<String> words) {
        boolean b = true;
        for (int i = 0; i < words.size() && b;++i){
            b = string().contains(words.get(i));
        }
        //System.out.println("");
        return b;
    }
    
    private String string(){
        boolean first = true;
        String s = "";
        for(int i = 0; i < frase.size(); ++i){
            if (first){
                first = false;
                s += frase.get(i);
            }else s += " " + frase.get(i);
        }
        return s;
    }

}