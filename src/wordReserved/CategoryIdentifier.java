package wordReserved;

/**
 *
 * @author Daniela Torres
 */
public enum CategoryIdentifier {
    OPERADOR_DE_SUMA("#", "OperadorDeSuma"), VARIABLE_NATURAL("NATURAL", "VariableNatural"), 
    OPERADOR_DE_ASIGNACION("=", "OperadorDeAsignacion"), CABECERA("INICIO", "Cabecera"),
    FINAL("FIN", "FinalClase"), SALIDA_CONSOLA("VER", "SalidaConsola"), 
    LIBRERIA_VER("LIBRERIAVER", "LibreriaVer"), LIBRERIA_SUMA("LIBRERIASUMA", "LibreriaSuma"), 
    LIBRERIA_NATURAL("LIBRERIANATURAL", "LibreriaNatural"), NOMBRE_VARIABLE("[A-Za-z0-9]+", "NombreVariable"), 
    NUMERICO("[0-9]+", "Numero"), CONDICION("CONDICION", "Condicion"), CICLO("CICLO", "Ciclo"),
    MAYOR_QUE(">", "MayorQue"), MENOR_QUE("<", "MenorQue"), MAYOR_IGUAL(">=", "MayorIgual"), 
    MENOR_IGUAL("<=", "MenorIgual"), IGUAL("==", "Igual"), CICLO_FIN("CICLOFIN","CicloFin"), 
    CONDICION_FIN("CONDICIONFIN", "CondicionFin");

    private String symbol;
    private String equivalence;

    private CategoryIdentifier(String symbol, String equivalence) {
        this.symbol = symbol;
        this.equivalence = equivalence;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getEquivalence() {
        return equivalence;
    }
}
