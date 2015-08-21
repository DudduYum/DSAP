/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd_progetto;

import asd_progetto.List.Interator;

/**
 *
 * @author rostyslavkostyuk
 */
public class Graph extends ComponentSet{
    List<List> roots;
    
    public Graph(){
        roots = new List<>();
    }
    public void addList(List<Node> subGraph){
        roots.addNode(subGraph);
    }
    public biReturnValue getNodeAndListByName(String name){
//        Interator it = roots.getInterator();
//            boolean test = true;
//            int cou = 0;
//            while(it.HasNext() && test){
//                
//                List<Node> tmp = (List<Node>) it.get();
//                Interator tmpIt = tmp.getInterator();
//                do{
//                    Node n = (Node) tmpIt.get();
//                    if( n.getLabel().equals("b") ){
//                        test = false;
//                    }
//                }while(tmpIt.HasNext() && test);
//                if(!test){
////                    System.out.print(++cou);
//                    it.remove();
//                }
//                
//            }
        Interator it = roots.getInterator();
        biReturnValue<Node,List> res = null;
//        boolean Notfound = true;
        boolean test = true;//forse non serve...
        do{
            List<Node> nodeList = (List<Node>) it.get();
            Interator nodeListIt = nodeList.getInterator();
            do{
                /*
                Cerco il nodo e la liste che lo contiene, 
                quando li trovo elimino entrambi dalle loro
                liste e gli salvo in res
                */
                Node n = (Node) nodeListIt.get();
                if( n.getLabel().equals("b") ){
                    res = new biReturnValue(n,nodeList);
                    nodeListIt.remove();
                    it.remove();
                }
            }while(nodeListIt.HasNext() && res == null);
            /*
            devo eliminare non e la lista per poter grarantire 
            che non ci sono le liste duplicate o sotto liste
            nel roots
            */
        }while(it.HasNext() && res == null);
        return res;
    }
    // non sono sicuro che serve
//    public void addNodes(String stNodes){
//        String[] n = Parser.split(stNodes, " -- ");
//        Node[] nodes = new Node[n.length];
//        for(int i = 0; i < nodes.length ; i++){
//            
//        }
//        
//    }
    public class biReturnValue<N,L>{
        private N nodo;
        private L lista;
        public biReturnValue(N nodo, L lista){
            this.nodo = nodo;
            this.lista = lista;
        }
        public N getNode(){
            return nodo;
        }
        public L getLista(){
            return lista;
        }
    }
}
