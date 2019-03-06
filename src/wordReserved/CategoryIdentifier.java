package wordReserved;

/**
 *
 * @author Daniela Torres
 */
public enum CategoryIdentifier {
    OPERADOR_DE_SUMA("#"), VARIABLE_NATURAL("natural"), OPERADOR_DE_ASIGNACION("="), FINAL_DE_LINEA("*"), CABECERA("Suma"),
    INICIO("["), FINAL("]"), SALIDA_CONSOLA("ver"), DELIMITADOR_SALIDA_CONSOLA("|"), LIBRERIA_VER("LIBRERIAVER"),
    LIBRERIA_SUMA("LIBRERIASUMA"), LIBRERIA_NATURAL("LIBRERIANATURAL"), NOMBRE_VARIABLE("^([a-z][a-zA-Z0-9])$");

    private String symbol;

    private CategoryIdentifier(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
