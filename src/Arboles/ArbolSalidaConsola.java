package Arboles;

import models.MessageSyntax;
import wordReserved.CategoryIdentifier;

/**
 *
 * @author Yuliana Boyaca
 */
public class ArbolSalidaConsola {

    /* Atributos */
    private Nodo raiz;

    /* Contructories */
    public ArbolSalidaConsola() {
        this.raiz = new Nodo(CategoryIdentifier.SALIDA_CONSOLA.getEquivalence());
        addNodo(new Nodo(CategoryIdentifier.SALIDA_CONSOLA.getSymbol()));
        addNodo(new Nodo(CategoryIdentifier.NOMBRE_VARIABLE.getEquivalence()));
        addNodo(new Nodo(CategoryIdentifier.NOMBRE_VARIABLE.getSymbol()));
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
     */
    public void validateLineWithArbolOfOutputInConsole(String[] auxLine, int numLine) throws Exception {
        if (!raiz.getHojaDerecha().getValor().equals(auxLine[1])) {
            throw new Exception(MessageSyntax.buildOutputErrorMessage(numLine, MessageSyntax.MSG_INVALID_OUTPUT));
        } else {
            throw new Exception(MessageSyntax.buildOutputSuccesfullMessage(numLine, MessageSyntax.MSG_SUCESSFULL_SYNTAX));
        }
    }

    /**
     * Muestra el contenido del arbol pre-order
     */
    public void mostrarPreOrden() {
        mostrarPreOrden(raiz);
    }

    /**
     * Metodo recursivo que se encarga de mostrar el arbol utilizando la tecnica
     * pre-order root-left-rigth
     *
     * @param tmp
     */
    public void mostrarPreOrden(Nodo tmp) {
        tmp.mostrar();
        if (tmp.getHojaIzquierda() != null) {
            mostrarPreOrden(tmp.getHojaIzquierda());
        }
        if (tmp.getHojaDerecha() != null) {
            mostrarPreOrden(tmp.getHojaDerecha());
        }
    }

    public ArbolSalidaConsola(Nodo raiz) {
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
