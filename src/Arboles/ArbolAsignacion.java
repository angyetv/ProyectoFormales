/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import models.MessageSyntax;
import wordReserved.CategoryIdentifier;

/**
 *
 * @author Yuliana Boyaca
 */
public class ArbolAsignacion {

    /* Atributos */
    private Nodo raiz;

    /* Contructories */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public ArbolAsignacion() {
        this.addNodo(new Nodo(CategoryIdentifier.VARIABLE_NATURAL.getEquivalence()));
        this.addNodo(new Nodo(CategoryIdentifier.VARIABLE_NATURAL.getSymbol()));
        this.addNodo(new Nodo(CategoryIdentifier.NOMBRE_VARIABLE.getEquivalence()));
        this.addNodo(new Nodo(CategoryIdentifier.NOMBRE_VARIABLE.getSymbol()));
        this.addNodo(new Nodo(CategoryIdentifier.OPERADOR_DE_ASIGNACION.getEquivalence()));
        this.addNodo(new Nodo(CategoryIdentifier.OPERADOR_DE_ASIGNACION.getSymbol()));
        this.addNodo(new Nodo(CategoryIdentifier.NUMERICO.getEquivalence()));
        this.addNodo(new Nodo(CategoryIdentifier.NUMERICO.getSymbol()));
    }

    /**
     * Agrega al arbol el nodo indicado
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
     * Muestra el contenido del arbol
     */
    public void mostrar() {
        mostrar(raiz);
    }

    /**
     * Metodo recursivo de mostrar
     *
     * @param tmp
     */
    public void mostrar(Nodo tmp) {
        tmp.mostrar();
        if (tmp.getHojaIzquierda() != null) {
            mostrar(tmp.getHojaIzquierda());
        }
        if (tmp.getHojaDerecha() != null) {
            mostrar(tmp.getHojaDerecha());
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

    /**
     * Valida la linea con el arbol de asignacion
     *
     * @param auxLine
     */
    public void validateLineWithArbolOfAssignment(String[] auxLine, int numLine) throws Exception {
        if (!raiz.getValor().equals(auxLine[0])) {
            throw new Exception(MessageSyntax.buildOutputErrorMessage(numLine, MessageSyntax.MSG_INVALID_TYPE_VARIABLE));
        } else if (!raiz.getHojaDerecha().getValor().equals(auxLine[1])) {
            // System.out.println("Syntax Error: Nombre de variable incorrecto");
            throw new Exception(MessageSyntax.buildOutputErrorMessage(numLine, MessageSyntax.MSG_INVALID_VARIABLE_NAME));
        } else if (!raiz.getHojaDerecha().getHojaDerecha().getValor().equals(auxLine[2])) {
            //   System.out.println("Syntax Error: Simbolo de asignacion de variable incorrecto");
            throw new Exception(MessageSyntax.buildOutputErrorMessage(numLine, MessageSyntax.MSG_INVALID_SYMBOL_ASSIGNAMENT));
        } else if (!raiz.getHojaDerecha().getHojaDerecha().getHojaDerecha().getValor().equals(auxLine[3])) {
            //  System.out.println("Syntax Error: Asignacion de variable incorrecta");
            throw new Exception(MessageSyntax.buildOutputErrorMessage(numLine, MessageSyntax.MSG_ASSIGNAMENT_VARIABLE_INCORRECT));
        } else {
           throw new Exception(MessageSyntax.buildOutputSuccesfullMessage(numLine, MessageSyntax.MSG_SUCESSFULL_SYNTAX));
        }
    }

    /* ----------Setters y Getters---------- */
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
}
