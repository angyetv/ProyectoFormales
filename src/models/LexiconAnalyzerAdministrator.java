package models;

import java.util.ArrayList;
import wordReserved.CategoryIdentifier;

/**
 *
 * @author angyedanielatorresveloza
 */
public class LexiconAnalyzerAdministrator {

    private ArrayList<String> linesList;

    public LexiconAnalyzerAdministrator() {
        linesList = new ArrayList<>();
    }

    public ArrayList<String> getLexicon() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < linesList.size(); i++) {
            if (linesList.get(i).contains(" ")) {
                String[] words = linesList.get(i).split(" ");
            } else {
                arrayList.add(linesList.get(i));
            }
        }
        return arrayList;
    }
    
    public String categoryIdentifier() {
        switch(CategoryIdentifier.valueOf(" ")) {
            case CABECERA:
                break;
        }
        return null;
    }

    public void setLines(ArrayList<String> code) {
        for (String string : code) {
            linesList.add(string);
        }
    }
}
