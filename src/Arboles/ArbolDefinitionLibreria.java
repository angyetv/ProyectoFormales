package Arboles;

import models.MessageSyntax;


/**
 *
 * @author Yuliana Boyaca
 */
public class ArbolDefinitionLibreria {

    /* Atributos */
    private Nodo raiz;
    private final String LIBRERIA = "LIBRERIA";
    private final String SIMBOLO_LIBRERIA = "LibreriaVer, LibreriaSuma, LibreriaNatural";

    /* Contructories */
    public ArbolDefinitionLibreria() {
        this.raiz = new Nodo(LIBRERIA);//LIBRERIA
        composeTree(new Nodo(SIMBOLO_LIBRERIA), this.raiz);//Puede ser alguna de las tres
       
    }

    /**
     * Agrega al arbol el nodo que se le indica en cualquiera de los brazos de la raiz
     * @param nodo
     * @param raiz 
     */
    private void composeTree(Nodo nodo, Nodo raiz) {
        if (raiz.getHojaIzquierda() == null) {
            raiz.setHojaIzquierda(nodo);
        } else if (raiz.getHojaDerecha() == null) {
            raiz.setHojaDerecha(nodo);
        }
    }
    
    /**
     * Valida la linea con el arbol de asignacion
     * @param auxLine
     * @param numLine
     * @throws java.lang.Exception
     */
    public void validateLineWithArbolOfDefinitionLibreria(String[] auxLine, int numLine) throws Exception {
        if (!raiz.getHojaIzquierda().getValor().contains(auxLine[0])) {
           throw new Exception(MessageSyntax.buildOutputErrorMessage(numLine, MessageSyntax.MSG_INVALID_LIBRERIA));
        }else{
            throw new Exception(MessageSyntax.buildOutputSuccesfullMessage(numLine, MessageSyntax.MSG_SUCESSFULL_SYNTAX));

        }
    }

    public ArbolDefinitionLibreria(Nodo raiz) {
        this.raiz = raiz;
    }

    /* Setters y Getters */
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
}
