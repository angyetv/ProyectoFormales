package models;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import wordReserved.CategoryIdentifier;

/**
 *
 * Clase principal para Analisis Lexico.
 *
 * @author Daniela Torres
 */
public class LexiconAnalyzerAdministrator {

    private ArrayList<String> linesList;
    private static int TOKEN = 0;

    public LexiconAnalyzerAdministrator() {
        linesList = new ArrayList<>();
    }

    /**
     * Metrodo que obtiene una lista linea a linea del resultado del Analisis
     * lexico.
     *
     * @return Una lista de token e Identificador de categoria.
     */
    public ArrayList<String> getLexicon() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < linesList.size(); i++) {
            String line = "";
            if (linesList.get(i).contains(" ")) {
                String[] words = linesList.get(i).split(" ");
                for (int j = 0; j < words.length; j++) {
                    String name = categoryIdentifier(words[j].replace(" ", ""));
                    if (name != null) {
                        if (name.equals(CategoryIdentifier.NOMBRE_VARIABLE.getEquivalence())) {
                            name = isExistInTheList(words[j], arrayList) + " " + name + ",";
                            line += name;
                        } else {
                            name = String.valueOf(TOKEN++) + " " + name + ",";
                            line += name;
                        }
                    } else {
                        arrayList.clear();
                        arrayList.add("Error Lexico en la linea " + (i + 1) + ", caracteres invalidos.");
                        return arrayList;
                    }
                }
            } else {
                String name = categoryIdentifier(linesList.get(i));
                if (name != null) {
                    if (name.equals(CategoryIdentifier.NOMBRE_VARIABLE.getEquivalence())) {
                        name = isExistInTheList(linesList.get(i), arrayList) + " " + name + ",";
                        line += name;
                    } else {
                        name = String.valueOf(TOKEN++) + " " + name + ",";
                        line += name;
                    }
                } else {
                    arrayList.clear();
                    arrayList.add("Error Lexico en la linea " + (i + 1) + ", caracteres invalidos.");
                    return arrayList;
                }
            }
            arrayList.add(line);
        }
        return arrayList;
    }

    /**
     * Obtine una lista resumida del analisis lexico.
     *
     * @return Omite el token.
     */
    public ArrayList<String> getToSyntactic() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < linesList.size(); i++) {
            String line = "";
            if (linesList.get(i).contains(" ")) {
                String[] words = linesList.get(i).split(" ");
                for (int j = 0; j < words.length; j++) {
                    String name = categoryIdentifier(words[j].replace(" ", ""));
                    if (name != null) {
                        name = name + ",";
                        line += name;
                    }
                }
            } else {
                String name = categoryIdentifier(linesList.get(i));
                if (name != null) {
                    name = name + ",";
                    line += name;
                }
            }
            arrayList.add(line);
        }
        return arrayList;
    }

    /**
     * Valida las palabras reservadas, con uso de expresiones reguales.
     *
     * @param word
     * @return El identificador de categoria de cada palabra.
     */
    public String categoryIdentifier(String word) {
        Pattern pat = Pattern.compile(CategoryIdentifier.NOMBRE_VARIABLE.getSymbol());
        Matcher mat = pat.matcher(word);
        if (CategoryIdentifier.OPERADOR_DE_SUMA.getSymbol().equals(word)) {
            return CategoryIdentifier.OPERADOR_DE_SUMA.getEquivalence();
        } else if (CategoryIdentifier.VARIABLE_NATURAL.getSymbol().equals(word)) {
            return CategoryIdentifier.VARIABLE_NATURAL.getEquivalence();
        } else if (CategoryIdentifier.OPERADOR_DE_ASIGNACION.getSymbol().equals(word)) {
            return CategoryIdentifier.OPERADOR_DE_ASIGNACION.getEquivalence();
        } else if (CategoryIdentifier.MAYOR_QUE.getSymbol().equals(word)) {
            return CategoryIdentifier.MAYOR_QUE.getEquivalence();
        } else if (CategoryIdentifier.MENOR_QUE.getSymbol().equals(word)) {
            return CategoryIdentifier.MENOR_QUE.getEquivalence();
        } else if (CategoryIdentifier.MAYOR_IGUAL.getSymbol().equals(word)) {
            return CategoryIdentifier.MAYOR_IGUAL.getEquivalence();
        } else if (CategoryIdentifier.MENOR_IGUAL.getSymbol().equals(word)) {
            return CategoryIdentifier.MENOR_IGUAL.getEquivalence();
        } else if (CategoryIdentifier.CICLO_FIN.getSymbol().equals(word)) {
            return CategoryIdentifier.CICLO_FIN.getEquivalence();
        } else if (CategoryIdentifier.CONDICION_FIN.getSymbol().equals(word)) {
            return CategoryIdentifier.CONDICION_FIN.getEquivalence();
        } else if (CategoryIdentifier.IGUAL.getSymbol().equals(word)) {
            return CategoryIdentifier.IGUAL.getEquivalence();
        } else if (CategoryIdentifier.CABECERA.getSymbol().equals(word)) {
            return CategoryIdentifier.CABECERA.getEquivalence();
        } else if (CategoryIdentifier.FINAL.getSymbol().equals(word)) {
            return CategoryIdentifier.FINAL.getEquivalence();
        } else if (CategoryIdentifier.SALIDA_CONSOLA.getSymbol().equals(word)) {
            return CategoryIdentifier.SALIDA_CONSOLA.getEquivalence();
        } else if (CategoryIdentifier.LIBRERIA_VER.getSymbol().equals(word)) {
            return CategoryIdentifier.LIBRERIA_VER.getEquivalence();
        } else if (CategoryIdentifier.LIBRERIA_SUMA.getSymbol().equals(word)) {
            return CategoryIdentifier.LIBRERIA_SUMA.getEquivalence();
        } else if (CategoryIdentifier.CONDICION.getSymbol().equals(word)) {
            return CategoryIdentifier.CONDICION.getEquivalence();
        } else if (CategoryIdentifier.CICLO.getSymbol().equals(word)) {
            return CategoryIdentifier.CICLO.getEquivalence();
        } else if (CategoryIdentifier.LIBRERIA_NATURAL.getSymbol().equals(word)) {
            return CategoryIdentifier.LIBRERIA_NATURAL.getEquivalence();
        } else if (isAllNumber(word)) {
            return CategoryIdentifier.NUMERICO.getEquivalence();
        } else if (mat.matches()) {
            return CategoryIdentifier.NOMBRE_VARIABLE.getEquivalence();
        } else {
            return null;
        }
    }

    /**
     * Expresion regular para validar si una palabra ingresada es numerica.
     *
     * @param word
     * @return true si es numerica.
     */
    public boolean isAllNumber(String word) {
        Pattern pat = Pattern.compile(CategoryIdentifier.NUMERICO.getSymbol());
        return pat.matcher(word).matches();
    }

    /**
     * Obtiene las lineas ingresadas por el usuario y hace la validacion de
     * espaciado sin caracteres.
     *
     * @param code
     */
    public void setLines(ArrayList<String> code) {
        for (String string : code) {
            if (string.length() != 0) {
                linesList.add(string);
            }
        }
    }

    /**
     * Une el resultado del analisis lexico.
     *
     * @return String que sera mostrado en la consola grafica.
     */
    public String printLexicon() {
        String salida = "\n-----------------Resultado Analizador Lexico---------------\n";
        ArrayList<String> listAux = getLexicon();
        for (int i = 0; i < listAux.size(); i++) {
            salida += "Linea " + (i + 1) + ": " + listAux.get(i) + "\n";
        }
        System.out.println(salida);
        return salida;
    }

    /**
     * Metodo usado para test.
     */
    public void printSyntactic() {
        System.out.println("tamanio: " + getToSyntactic().size());
        String salida = "";
        for (String string : getToSyntactic()) {
            salida += string + "\n";
        }
        System.out.println(salida);
    }

    /**
     * Valida que un NombreVariable ya este ingresado.
     *
     * @param word
     * @param list
     * @return El token a asignar en cada palabra analizada.
     */
    public int isExistInTheList(String word, ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (linesList.get(i).contains(word)) {
                String[] vec = list.get(i).split(",");
                for (int j = 0; j < vec.length; j++) {
                    String[] sepa = vec[j].split(" ");
                    if (sepa[1].contains(CategoryIdentifier.NOMBRE_VARIABLE.getEquivalence())) {
                        return Integer.parseInt(vec[j].split(" ")[0]);
                    }
                }
            }
        }
        return TOKEN++;
    }

    /**
     * @return la lista de lineas a analizar.
     */
    public ArrayList<String> getLinesList() {
        return linesList;
    }

    /**
     * @param value
     * @return nuevo valor del Token.
     */
    public static int setTOKEN(int value) {
        return TOKEN = value;
    }
}
