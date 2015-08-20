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
public class Graph extends ComponentSet{
    List<List> roots;
    
    public Graph(){
        roots = new List<>();
    }
    public void addNodes(String[] nodes){
       

        
    }
    public static void main(String[] argv){
        Node n1 = new Node("n1");
        Node n2 = new Node("n2");
        Node n3 = new Node("n3");
        
        Struttura st1 = n1.getRepp();
        Struttura st2 = n2.getRepp();
        Struttura st12 = st1.union(st2);
        Struttura st3 = n3.getRepp();
        System.out.print("Test");
        
        if(st1.find() == st2.find())
            System.out.print("Dai cazzo");
        if(st1.find() == st3.find())
            System.out.print("Ci siamo");
        
    }
}
