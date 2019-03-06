package models;

import java.util.ArrayList;

/**
 *
 * @author angyedanielatorresveloza
 */
public class LexiconAnalyzerAdministrator {

    private ArrayList<String> linesList;

    public LexiconAnalyzerAdministrator() {
        linesList = new ArrayList<>();
    }

    public ArrayList<String> getLexicon(String lines) {
        ArrayList<String> arrayList = new ArrayList<>();
        
        return arrayList;
    }

    public void setLines(ArrayList<String> code) {
        for (String string : code) {
            linesList.add(string);
        }
    }

    public String print() {
        String salida = "";
        for (String string : linesList) {
            salida += string + "\t";
        }
        return salida;
    }
}
