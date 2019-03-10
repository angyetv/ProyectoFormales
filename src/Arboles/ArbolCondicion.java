/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import models.MessageSyntax;
import static models.MessageSyntax.buildOutputErrorMessage;
import wordReserved.CategoryIdentifier;

/**
 *
 * @author Yuliana Boyaca
 */
public class ArbolCondicion {
      /* Atributos */
    private Nodo raiz;
    private final String OPERADOR_DE_EQUIVALENCIA = "OperadorDeEquivalencia";
    private final String SIMBOLOS_OPERADOR_DE_EQUIVALENCIA = "<,>,>=,<=,==";
    /* Contructories */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public ArbolCondicion() {
        
        this.addNodo(new Nodo(CategoryIdentifier.CONDICION.getEquivalence()));
        this.addNodo(new Nodo(CategoryIdentifier.CONDICION.getSymbol()));
        this.addNodo(new Nodo(CategoryIdentifier.NOMBRE_VARIABLE.getEquivalence()));
        this.addNodo(new Nodo(CategoryIdentifier.NOMBRE_VARIABLE.getSymbol()));
        this.addNodo(new Nodo(OPERADOR_DE_EQUIVALENCIA));
        this.addNodo(new Nodo(SIMBOLOS_OPERADOR_DE_EQUIVALENCIA));
        this.addNodo(new Nodo(CategoryIdentifier.NOMBRE_VARIABLE.getEquivalence()));
        this.addNodo(new Nodo(CategoryIdentifier.NOMBRE_VARIABLE.getSymbol()));
    }

    /**
     * Agrega al arbol el nodo indicado, llamando al metodo recursivo
     * @param nodo 
     */
    public void addNodo(Nodo nodo) {
        this.composeTree(nodo, this.raiz);
    }
    
    /**
     * Metodo recursivo que compone el arbol
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
     * Metodo recursivo que se encarga de mostrar el arbol utilizando la tecnica pre-order
     * root-left-rigth
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
     * Valida la linea con el arbol de estructura de definicion de un ciclo
     * @param auxLine
     * @param numLine
     * @throws java.lang.Exception
     */
    public void validateLineWithArbolOfCondition(String[] auxLine, int numLine) throws Exception {
        if (!raiz.getValor().equals(auxLine[0])) {
             throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_ERROR_SYNTAX));
        } else if (!raiz.getHojaDerecha().getValor().equals(auxLine[1])) {
             throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_INVALID_VARIABLE_NAME));
        } else if (!raiz.getHojaDerecha().getHojaDerecha().getValor().equals(validateOperatorsEquivalency(auxLine[2]))) {
             throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_INVALID_OPERATION_EQUIVALENCY));
        } else if (!raiz.getHojaDerecha().getHojaDerecha().getHojaDerecha().getValor().equals(auxLine[3])) {
             throw new Exception(buildOutputErrorMessage(numLine, MessageSyntax.MSG_INVALID_VARIABLE_NAME));
        } else {
            throw new Exception(MessageSyntax.buildOutputSuccesfullMessage(numLine, MessageSyntax.MSG_SUCESSFULL_SYNTAX));
        }
    }
    
    /**
     * Verifica si el string ingresado realmente corresponde a un tipo de operador
     * @param typeOperator
     * @return 
     */
    private String validateOperatorsEquivalency(String typeOperator) {
        if (typeOperator.equals(CategoryIdentifier.MAYOR_IGUAL.getEquivalence())
                ||typeOperator.equals(CategoryIdentifier.MENOR_IGUAL.getEquivalence())
                 ||typeOperator.equals(CategoryIdentifier.MENOR_QUE.getEquivalence())
                 ||typeOperator.equals(CategoryIdentifier.MAYOR_QUE.getEquivalence())) {
             return OPERADOR_DE_EQUIVALENCIA;
        }
        return typeOperator;
    }

    /* ----------Setters y Getters---------- */
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
}
