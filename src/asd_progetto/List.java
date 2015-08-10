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
public class List {
    private int length = 0;
    private ListCell first = null;
    private ListCell last = null;
//    private ListCell last = null;
 
    public void addNode(Node n){
        ListCell lc = new ListCell(n);
        lc.setNext(first);
        first = lc;
        last = (last == null)? lc : last;
        length++;
    }
    public Node getNodeByLabel(String st){
        ListCell interator = first;
        boolean found = false;
        for(int i = 0 ; i < length && !found ; i++){
            if(interator.getNode().getLabel().equals(st)){
                found = true;
            }else{
                interator = interator.getNext();
            }
        }
        return interator.getNode();
    }
    public void union(List list){
        if(list.length > this.length){
            list.union(this);
        }
        this.last.setNext(list.first);
        ListCell interator = list.first;
        for(int i = 0 ; i < list.length;i++){
            interator.getNode().setRepp(this.first.getNode());
            interator = interator.getNext();
        }
        this.last = list.last;
    }
    public int length(){
        return length;
    }
}
