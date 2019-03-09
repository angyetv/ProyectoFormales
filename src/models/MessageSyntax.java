package models;

/**
 *
 * @author Yuliana Boyaca
 */
public class MessageSyntax {

    public static final String MSG_ERROR_SYNTAX = "¡Error de sintaxis!";
    public static final String MSG_SUCESSFULL_SYNTAX = "¡Sintaxis valida!";
    public static final String MSG_NOT_ENDOFCYCLE_FOUND = "No se reconoce el fin del ciclo";
    public static final String MSG_INVALID_VARIABLE_NAME = "Nombre de variable inválido";
    public static final String MSG_INVALID_OUTPUT = "Variable o elemento incorrecto para mostrar";
    public static final String MSG_NOT_FOUND_WORD_RESERVED = "No encuentra palabra reservada para inicio de linea";
    public static final String MSG_NOT_FOUND_ENDOFCONDITION = "No se reconoce el fin del ciclo";
    public static final String MSG_INIT_CLASE_INCORRECT = "Definicion de clase incorrecta";
    public static final String  MSG_NOT_FOUND_END_OF_CLASS = "No se reconoce final de clase valido";
    public static String MSG_ASSIGNAMENT_VARIABLE_INCORRECT = "Asignacion de variable invalido";
   public static String MSG_INVALID_LIBRERIA = "Llamado a libreria incorrecto";
   public static String MSG_INVALID_STRUCTURE_OUTPUT = "Linea de salida de consola incompleta";

    public static String buildOutputErrorMessage(int lineIndex, String message) {
        return "Linea " + lineIndex + ":\t Syntax Error: " + message;
    }
    
    public static String buildOutputSuccesfullMessage(int lineIndex, String message) {
        return "Linea " + lineIndex + ": " + message;
    }
}
