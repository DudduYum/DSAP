/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd_progetto;

/**
 *
 * @author rostyslavkostyuk
 * @param <T>
 */

public class ListCell<T> {
    private final T node;
    private ListCell<T> next = null;
    
    
    public ListCell(T node){
        this.node = node;
    }
    
    public void setNext(ListCell next){
        this.next = next;
    }
    
    public T getNode(){
        return node;
    }
    
    public ListCell getNext(){
        return next;
    }
}
