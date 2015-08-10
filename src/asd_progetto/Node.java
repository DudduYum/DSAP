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
public class Node {
    private List In = null;
    private List Out = null;
    private Node repp = null;
    private final String label;
    private int key;
    
    public Node(String name){
        label = name;
        //generate the key;
        
    }
    public void setIn(List in){
        this.In = in;
    }
    public void setOut(List Out){
        this.Out = Out;
    }
    public void setRepp(Node node){
        this.repp = node;
    }
    public Node getRepp(){
        return repp;
    }
    public String getLabel(){
        return label;
    }
}
