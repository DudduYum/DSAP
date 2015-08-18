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
public class TreeSet<T> implements Struttura<T> {
    private Struttura rapp;
    private T key;
    private Struttura getTheLowestNode(){
        
        Struttura interator = rapp;
        /*
        finche interator e suo rappresentante sono dello stesso tipo, fai
        */
        while(interator.getClass().equals(((TreeSet<T>) rapp).rapp.getClass())){
            interator = ((TreeSet<T>) rapp).rapp;
        }
        return interator;
    }
    public TreeSet(T node){
        key = node;
        List<Node> tmp = new List<>();
        rapp = (Struttura) tmp;
        rapp.addNode(node);
    }
    public void setRapp(Struttura rapp){
        this.rapp = rapp;
    }
    public Struttura getRapp(){
        return rapp;
    }
    
    @Override
    public T getNodeByLabel(String st) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addNode(T n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Struttura find() {//path compration
        rapp =  ((TreeSet<T>) rapp).getTheLowestNode();
        rapp = ((TreeSet<T>) rapp).rapp;
        return rapp;
    }

    @Override
    public Struttura union(Struttura rapp) {
        
        TreeSet<T> rapp1 = (TreeSet<T>) ((TreeSet<T>) this.rapp).getTheLowestNode();
        TreeSet<T> rapp2 = (TreeSet<T>) ((TreeSet<T>) rapp).getTheLowestNode();
        Struttura res = null;
        if(rapp1 != rapp2){
            List<T> list1 = (List<T>) rapp1.rapp;
            List<T> list2 = (List<T>) rapp2.rapp;
            if(list2.length() > list1.length()){
                List<T> tmp = list2;
                list2 = list1;
                list1 = tmp;
                TreeSet<T> tmpS = rapp1;
                rapp1 = rapp2;
                rapp2 = tmpS;
            }
            res = list1.union((Struttura) list2);
            rapp2.rapp = rapp1;
            
        }
        return res;
    }
    
    
}
