package Arboles;

import models.MessageSyntax;
import static models.MessageSyntax.buildOutputErrorMessage;
import wordReserved.CategoryIdentifier;

/**
 *
 * @author Yuliana Boyaca
 */
public class ArbolDefinicionClase {

    /* Atributos */
    private Nodo raiz;

    /* Contructories */
    public ArbolDefinicionClase() {
        this.raiz = new Nodo(CategoryIdentifier.CABECERA.getEquivalence());//Cabecera
        addNodo(new Nodo(CategoryIdentifier.CABECERA.getSymbol()));//suma
        addNodo(new Nodo(CategoryIdentifier.FINAL.getEquivalence()));//Cabecera
        addNodo(new Nodo(CategoryIdentifier.FINAL.getSymbol()));//suma
    }

    /**
     * Agrega al arbol el nodo indicado, llamando al metodo recursivo
     *
     * @param nodo
     */
    public void addNodo(Nodo nodo) {
        this.composeTree(nodo, this.raiz);
    }

    /**
     * Metodo recursivo que compone el arbol
     *
     * @param nodo
     * @param raiz
     */
    private void composeTree(Nodo nodo, Nodo raiz) {
        if (raiz == null) {
            this.setRaiz(nodo);
        } else {
            if (raiz.getHojaIzquierda() == null) {
                raiz.setHojaIzquierda(nodo);
            } else {
                if (raiz.getHojaDerecha() == null) {
                    raiz.setHojaDerecha(nodo);
                } else {
                    composeTree(nodo, raiz.getHojaDerecha());
                }
            }
        }
    }

    /**
     * Valida la linea con el arbol de asignacion
     *
     * @param auxLine
     * @param numLine
     * @throws java.lang.Exception
     */
    public void validateLineWithArbolOfDefinitionClass(String[] auxLine, int numLine) throws Exception {
        if (!raiz.getValor().equals(auxLine[0])) {
            throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_INIT_CLASE_INCORRECT));
        } else {
            throw new Exception(MessageSyntax.buildOutputSuccesfullMessage(numLine, MessageSyntax.MSG_SUCESSFULL_SYNTAX));
        }
    }

    public ArbolDefinicionClase(Nodo raiz) {
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
