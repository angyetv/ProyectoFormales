package models;

import Arboles.ArbolAsignacion;
import Arboles.ArbolCiclo;
import Arboles.ArbolCondicion;
import Arboles.ArbolDefinicionClase;
import Arboles.ArbolDefinitionLibreria;
import Arboles.ArbolSalidaConsola;
import java.util.ArrayList;
import static models.MessageSyntax.buildOutputErrorMessage;
import static models.MessageSyntax.buildOutputSuccesfullMessage;
import wordReserved.CategoryIdentifier;

/**
 *
 * @author Yuliana Boyaca
 */
public class SyntacticAnalyzer {

    private boolean isCondition;
    private boolean isCiclo;
    private ArrayList<String> myProgram;
    private int countLine;

    public SyntacticAnalyzer() {
        countLine = 1;
    }

    public String validateProgram(ArrayList<String> program) {
        this.myProgram = program;
        String outputAnalyzer = "\n--------------Resultado Analizador Sintactico--------------\n";

        for (String line : program) {
            try {
                validateLine(line);
            } catch (Exception ex) {
                System.out.println(ex.getMessage()); //IMPRIME MENSAJE
                outputAnalyzer += ex.getMessage() + "\n";
            }
        }
        return outputAnalyzer;
    }

    /**
     * Metodo principal que Valida la linea que llega por parametro
     *
     * @param line linea a validar
     * @param countLine numero de linea
     * @throws Exception
     */
    private void validateLine(String line) throws Exception {
        int numLine = this.countLine++;
        String[] auxVariablesLine = line.split(",");
        String identifierLine = auxVariablesLine[0];
        if (isValidateTypeLine(identifierLine)) {
            switch (LineTypes.valueOf(identifierLine)) {
                case LibreriaVer:
                    validateLibreria(auxVariablesLine, numLine);
                    break;
                case LibreriaSuma:
                    validateLibreria(auxVariablesLine, numLine);
                    break;
                case LibreriaNatural:
                    validateLibreria(auxVariablesLine, numLine);
                    break;
                case Cabecera:
                    validateDefinitionOfClass(auxVariablesLine, numLine);
                    break;
                case VariableNatural:
                    validateLineAssignamentNumNatural(auxVariablesLine, numLine);
                    break;
                case Ciclo:
                    validateLineCycle(auxVariablesLine, numLine);
                    break;
                case Condicion:
                    validateLineCondition(auxVariablesLine, numLine);
                    break;
                case SalidaConsola:
                    validateLineOutputConsole(auxVariablesLine, numLine);
                    break;
                case CondicionFin:
                    validateEndOfCondition(auxVariablesLine, numLine);
                    break;
                case CicloFin:
                    validateEndOfCycle(auxVariablesLine, numLine);
                    break;
                case FinalClase:
                    validateEndOfClass(auxVariablesLine, numLine);
                    break;
            }
        } else {
            throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_ERROR_SYNTAX));
        }
    }

    /**
     * Valida el tipo de linea
     *
     * @param identifierCategory
     * @return
     */
    private boolean isValidateTypeLine(String identifierCategory) {
        if (identifierCategory.equals(LineTypes.LibreriaVer.toString()) || identifierCategory.equals(LineTypes.LibreriaSuma.toString()) || identifierCategory.equals(LineTypes.LibreriaNatural.toString()) || identifierCategory.equals(LineTypes.SalidaConsola.toString())
                || identifierCategory.equals(LineTypes.Ciclo.toString()) || identifierCategory.equals(LineTypes.Condicion.toString()) || identifierCategory.equals(LineTypes.FinalClase.toString())
                || identifierCategory.equals(LineTypes.VariableNatural.toString())
                || identifierCategory.equals(LineTypes.CicloFin.toString())
                || identifierCategory.equals(LineTypes.CondicionFin.toString())
                || identifierCategory.equals(LineTypes.Cabecera.toString())
                || identifierCategory.equals(LineTypes.FinalClase.toString())) {
            return true;
        }
        return false;
    }

    /**
     * Valida la linea de asignaccion de variables de numeros naturales
     *
     * @param auxVariablesLine
     */
    private void validateLineAssignamentNumNatural(String[] auxVariablesLine, int numLine) throws Exception {
        switch (auxVariablesLine.length) {
            case 2:
                if (auxVariablesLine[0].equals(CategoryIdentifier.VARIABLE_NATURAL.getEquivalence()) && auxVariablesLine[1].equals(CategoryIdentifier.NOMBRE_VARIABLE.getEquivalence())) {
                    throw new Exception(buildOutputSuccesfullMessage(numLine, MessageSyntax.MSG_SUCESSFULL_SYNTAX));
                } else {
                    throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_INVALID_VARIABLE_NAME));
                }
            case 4:
                ArbolAsignacion arbolAsignacion = new ArbolAsignacion();
                arbolAsignacion.validateLineWithArbolOfAssignment(auxVariablesLine, numLine);
                break;
            default:
                throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_ASSIGNAMENT_VARIABLE_INCORRECT));

        }
    }

    /**
     * Valida la linea de un ciclo
     *
     * @param auxVariablesLine
     */
    private void validateLineCycle(String[] auxVariablesLine, int numLine) throws Exception {
        if (auxVariablesLine.length == 4) {
            if (searchEndCycle()) {
                ArbolCiclo arbolCiclo = new ArbolCiclo();
                arbolCiclo.validateLineWithArbolOfCycle(auxVariablesLine, numLine);
            } else {
                throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_NOT_ENDOFCYCLE_FOUND));
            }
        } else {
            throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_INVALID_DEFINITION_CYCLE));
        }
    }

    /**
     * Valida la extructura de la linea para imprimir algo en consola
     *
     * @param auxVariablesLine
     */
    private void validateLineOutputConsole(String[] auxVariablesLine, int numLine) throws Exception {
        if (auxVariablesLine.length == 2) {
            ArbolSalidaConsola arbolSalidaConsola = new ArbolSalidaConsola();
            arbolSalidaConsola.validateLineWithArbolOfOutputInConsole(auxVariablesLine, numLine);
        } else if (auxVariablesLine.length == 1) {
            throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_INVALID_STRUCTURE_OUTPUT));
        } else {
            throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_INVALID_OUTPUT));
        }
    }

    /**
     * Vaida la linea con extructura de una condicion
     *
     * @param auxVariablesLine
     */
    private void validateLineCondition(String[] auxVariablesLine, int numLine) throws Exception {
        if (auxVariablesLine.length == 4) {
            if (searchEndCondition()) {
                ArbolCondicion arbolCondicion = new ArbolCondicion();
                arbolCondicion.validateLineWithArbolOfCondition(auxVariablesLine, numLine);
            } else {
                throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_NOT_FOUND_ENDOFCONDITION));
            }
        } else {
               throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_INVALID_DEFINITION_CONDITION));
        }
    }

    /**
     * Busca dentro de la lineas del programa un fin de la condicion
     *
     * @return
     */
    private boolean searchEndCondition() {
        for (String line : myProgram) {
            String[] variablesLine = line.split(",");
            if (variablesLine[0].equals(CategoryIdentifier.CONDICION_FIN.getEquivalence())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca dentro de la lineas del programa un finde de ciclo
     */
    private boolean searchEndCycle() {
        for (String line : myProgram) {
            String[] variablesLine = line.split(",");
            if (variablesLine[0].equals(CategoryIdentifier.CICLO_FIN.getEquivalence())) {
                return true;
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//        SyntacticAnalyzer s = new SyntacticAnalyzer();
//
//        ArrayList<String> miProgram = new ArrayList<>();
//        //miProgram.add("VariableNatural,NombreVariable");
//        miProgram.add("LibreriaVer, rff");
//        miProgram.add("LibreriaSuma");
//        miProgram.add("LibreriaNatural, hd, hd");
//        miProgram.add("SalidaConsola, hd");
//        miProgram.add("Cabecera, JIS");
//        miProgram.add("VariableNatural,NombreVariable,OperadorDeAsignacion,Numero");
//        miProgram.add("Ciclo,NombreVariable,MenorQue,NombreVariable");
//        miProgram.add("CicloFin");//ya
//        miProgram.add("Condicion,NombreVariable,OperadorDeEquivalencia,NombreVariable");
//        miProgram.add("CondicionFin");
//        miProgram.add("FinalClase");
//        s.validateProgram(miProgram);
//
//    }

    /**
     * valida la estructura de un final de condicion
     * @param auxVariablesLine
     * @param numLine 
     */
    private void validateEndOfCondition(String[] auxVariablesLine, int numLine) throws Exception {
        if (auxVariablesLine.length == 1) {
             throw new Exception(buildOutputSuccesfullMessage(numLine, MessageSyntax.MSG_SUCESSFULL_SYNTAX));
        } else {
             throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_INVALID_DEFINITION_CONDITION));
        }
    }

    private void validateEndOfCycle(String[] auxVariablesLine, int numLine) throws Exception {
        if (auxVariablesLine.length == 1) {
            throw new Exception(buildOutputSuccesfullMessage(numLine, MessageSyntax.MSG_SUCESSFULL_SYNTAX));
        } else {
            throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_INVALID_DEFINITION_ENDCYCLE));
        }
    }

    private void validateEndOfClass(String[] auxVariablesLine, int numLine) throws Exception {
        if (auxVariablesLine.length == 1) {
            throw new Exception(buildOutputSuccesfullMessage(numLine, MessageSyntax.MSG_SUCESSFULL_SYNTAX));
        } else {
            throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_INVALID_END_CLASS));
        }
    }

    /**
     * Valida que la definicion de clase este correcta
     *
     * @param auxVariablesLine
     */
    private void validateDefinitionOfClass(String[] auxVariablesLine, int numLine) throws Exception {
        if (searchEndOfClass()) {
            if (auxVariablesLine.length == 1) {
                ArbolDefinicionClase arbolDefinicionClase = new ArbolDefinicionClase();
                arbolDefinicionClase.validateLineWithArbolOfDefinitionClass(auxVariablesLine, numLine);
            } else {
                throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_INIT_CLASE_INCORRECT));
            }
        } else {
            throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_NOT_FOUND_END_OF_CLASS));
        }
    }

    /**
     * Busca dentro del programa el final de clase
     *
     * @return true si existe final de clase
     */
    private boolean searchEndOfClass() {
        for (String line : myProgram) {
            String[] variablesLine = line.split(",");
            if ((variablesLine[0].equals(CategoryIdentifier.FINAL.getEquivalence()) && (variablesLine.length == 1))) {
                return true;
            }
        }
        return false;
    }

    private void validateLibreria(String[] auxVariablesLine, int numLine) throws Exception {
        if (auxVariablesLine.length == 1) {
            ArbolDefinitionLibreria arbolDefinitionLibreria = new ArbolDefinitionLibreria();
            arbolDefinitionLibreria.validateLineWithArbolOfDefinitionLibreria(auxVariablesLine, numLine);
//             throw new Exception(MessageSyntax.buildOutputSuccesfullMessage(numLine, MessageSyntax.MSG_SUCESSFULL_SYNTAX));
        } else {
            throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_INVALID_LIBRERIA));
        }
    }

    public void setCountLine(int countLine) {
        this.countLine = countLine;
    }
}
