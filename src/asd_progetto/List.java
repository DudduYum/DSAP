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
public class List<T> implements Struttura<T> {
    private int length = 0;
    private ListCell<T> first = null;
    private ListCell<T> last = null;
//    private ListCell last = null;

    public Interator getInterator(){
        return new Interator();
    }
    @Override
    public void addNode(T n){
        ListCell<T> lc = new ListCell(n);
        lc.setNext(first);
        first = lc;
        last = (last == null)? lc : last;
        length++;
    }
    @Override
    public T getNodeByLabel(String st){
//        visit a graph
        T res=null;
        int w = 1, g = 1, b =2;
        int [] colors = new int[length];
        for(int i = 0 ; i < length ; i++){
            colors[i] = w;
        }
        
        return res;
        
        
        
//        ListCell interator = first;
//        boolean found = false;
//        
//        while(interator != null && !found){
//            if(interator.getNode().getLabel().equals(st)){
//                found = true;
//            }else{
//                interator = interator.getNext();
//            }
//        }
//        //soluzione a null pointer
//        return (interator == null)? null : interator.getNode();
    }//forse non serve
     @Override
    public Struttura find() {
        return this;
    }
    public void union(List list){ // da calcelare
//        if(list.length > this.length){
//            list.union(this);
//        }
       this.last.setNext(list.first);
//       list.updateRap(this);
       this.length += list.length;
       this.last = list.last;
       
       
//        this.last.setNext(list.first);
//        ListCell interator = list.first;
//        for(int i = 0 ; i < list.length;i++){
//            interator.getNode().setRepp(this.first.getNode());
//            interator = interator.getNext();
//        }
//        this.last = list.last;
    }
    public int length(){
        return length;
    }

    @Override
    public Struttura union(Struttura rapp) {
        List<T> res;
        List<T> list = (List<T>) rapp;
        this.last.setNext(list.first);
        this.last = list.last;
        res = this;
        res.length = this.length + list.length;
        return res;
    }
    public class Interator{
        private ListCell<T> cur = first;
        private ListCell<T> predcessor = null;
        
        public void Next(){
            if(cur != null){
                predcessor = cur;
                cur = cur.getNext();
            }
        }
        public void remove(){
            if(first == last){//quando non ci sono elementi, oppure c'e' uno solo...
                predcessor = cur = first = last = null; // tutto a null
            }else{//altrimenti
                if(cur == last){
                    predcessor.setNext(null);
                    last = predcessor;
                    cur = predcessor.getNext();
                }else if(cur == first){
                    first = first.getNext();
                    cur.setNext(null);
                    cur = first;
                }else if(cur != null){
                    predcessor.setNext(cur.getNext());
                    cur = predcessor.getNext();
                } 
            }
            if(length > 0)
                length--;
        }
        public T get(){
            return cur.getNode();
        }
        public boolean HasNext(){
            return cur.getNext() != null;
        }
    }
}
