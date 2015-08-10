/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd_progetto;

/**
 *
 * @author rostyslavkostyuk
 */
public class ListCell {
    private Node node;
    private ListCell next = null;
    
    public ListCell(Node node){
        this.node = node;
    }
    
    public void setNext(ListCell next){
        this.next = next;
    }
    
    public Node getNode(){
        return node;
    }
    
    public ListCell getNext(){
        return next;
    }
}
