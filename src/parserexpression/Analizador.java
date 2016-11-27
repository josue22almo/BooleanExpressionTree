
package parserexpression;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jdk.nashorn.internal.runtime.ParserException;

/**
 *
 * @author Josue Inaldo Alcántara Moreno
 */
public class Analizador {
    
    private ArrayList<TokenInfo> tokenInfos;
    private static LinkedList<Token> tokens;
    
    private String preparedString(String str){
        String especialChars = "áàäéèëíìïóòöúùñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
        String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
        String s = str;        
        for (int j = 0; j < especialChars.length();++j){
            String t = "" + especialChars.charAt(j);
            while(s.contains(t)){
                String y = "" + s.charAt(s.indexOf(t));
                String replace = "" + ascii.charAt(j);
                s = s.replace(y, replace);
            }
        }        
        return s;
    }
    
    private class TokenInfo {
        public final Pattern regex;
        public final int token;

        public TokenInfo(Pattern regex, int token) {
          super();
          this.regex = regex;
          this.token = token;
        }
    }
      
    public Analizador() {
        tokenInfos = new ArrayList<>();
        tokens = new LinkedList<>();
        add("\\(", 1); // open bracket
        add("\\)", 2); // close bracket
        add("\\}", 3); // close curly bracket
        add("\\{", 4); // open curly bracket
        add("\\&", 5); // and
        add("\\|", 6); // or
        add("\\!", 7); // not
        add("\"", 8); // comillas dobles 	
        add("[a-zA-Z][a-zA-Z0-9_]*", 9); // letters and numbers
        add("\\x20", 10); //space
    }      
    
    public void analizarExpresion(String str) throws ParserException{
        String s = preparedString(str);
        tokens.clear();
        String tok = "";    
        char t = ' ';
        while(!s.equals("")){
            boolean finded = false;
            for (TokenInfo tokenInfo : tokenInfos){
                Matcher m = tokenInfo.regex.matcher(s);                
                t = s.charAt(0);
                if (m.find()){
                    finded = true;
                    tok = m.group().trim();
                    if(tokenInfo.token != Values.ESPACIO)
                        tokens.add(new Token(tokenInfo.token,tok));
                    s = m.replaceFirst("");
                    break;
                }
            }
            String j = "" + t;
            if (!finded) throw new ParserException("Caràcter inesperat en l'entrada: " + j);
        }
    }
    
    private void add(String regex, int token) {
        tokenInfos.add(
        new TokenInfo(
        Pattern.compile("^("+regex+")"), token));
    }   
    
    public LinkedList<Token> getTokens(){
        return tokens;
    }
    
    @Override
    public String toString(){
        String s ="";
        for (int i = 0; i < tokens.size();++i){
            s += Integer.toString(tokens.get(i).token) + " " + tokens.get(i).sequence + "\n";
        }
        return s;
    }
}
