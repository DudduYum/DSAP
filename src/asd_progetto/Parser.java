/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd_progetto;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author rostyslavkostyuk
 */
public class Parser{
	public Parser(){

	}
        private String DelateSpaces(String st){
            /*
            il metodo score una stringa ed elimina da essa tutte le occorenze 
            multiple di ' '
            */
            boolean space = false;
            boolean label = true;
            String res = "";
     
            for(int i = 0 ; i < st.length() ; i++){
                label = (st.charAt(i)== '\"')? false : true;
                
                if(label){
                    if( ! (st.charAt(i) == ' ' && space))     //aggiungo il carattere alla stringa solo se non lo spazio oppure è lo spazio 
                        res+= st.charAt(i);                     // incontrato per prima volta
                    space = (st.charAt(i) == ' ')?   true : false;// decido nuovo valore di space
                }
            }
            return res;
        }
        public static String[] split(String st, String splitSt){
            String[] res = null;
            if( st.length() >= splitSt.length() ){
                
            
                int size = 1;
                /*
                conto quanti elementi separati da c ci sono nella lista
                */
                int len = splitSt.length();
                for(int i = 0 ; i < st.length() - len +1 ; i++){// qui ci va piu' uno, perhce se no non considero ultimo pezzo di stringa
                    if(st.substring(i, i + len).equals(splitSt))
                        size++;
                }
                /*
                riempio la stringa di output con le sotto stringhe di st
                per fare cio uso 3 puntatori 
                i - puntatore nel vettore di output
                start - puntatore al inizio della nuova sottostringa da estrare
                end - puntatore alla fine di prossima stringa da estrare
                */
                res = new String[size];
                int start, end, i;
                for( start = end = i = 0  ; i < size - 1  ; end++){
                    
                    if(st.substring(end, end + len).equals(splitSt)){
                        res[i++] = st.substring(start, end);
                        end += len-1;//poi viene incrementato di unao
                        start = end+1;
                    }
                }
                res[i] = st.substring(end);//aggiungo ultimo elemento
            }
            return res;
        }
        private String[] split(String st, char c){
            String[] res;
            int size = 1;
            /*
            conto quanti elementi separati da c ci sono nella lista
            */
            for(int i = 0 ; i < st.length() ; i++){
                if(st.charAt(i) == c)
                    size++;
            }
            /*
            riempio la stringa di output con le sotto stringhe di st
            per fare cio uso 3 puntatori 
            i - puntatore nel vettore di output
            start - puntatore al inizio della nuova sottostringa da estrare
            end - puntatore alla fine di prossima stringa da estrare
            */
            res = new String[size];
            int start, end, i;
            for( start = end = i = 0  ; i < size  ; end++){
                if(st.charAt(end) == c){
                    res[i++] = st.substring(start, end);
                    start = end;
                }
            }
//            start = end = 0;
//            for(int i = 0 ; i < st.length() && size > 0; i++){
//                if(st.charAt(i) == c)
//            }
            return res;
        }
        public Graph genereteGraph() throws IOException {
            Graph res = null;
            String inputLine="";
            InputStreamReader cin = new InputStreamReader(System.in);
            boolean endInput = true; // la variabile che mi permette di capire che
            //ho finito di leggere input
            boolean endLine = true;// per leggere le righe
            boolean GrafType = true; // fa si che viene stabilito se grafo 
                                     //e' orientato o meno 
            boolean inComment = false; // aiuta a ignorare i comenti
            

            while(endInput){
                char input;
                while(endLine){
                    input = (char)cin.read();
                    if(input == '}'){
                        endLine = false;
                        endInput = false;
                    }else{
                        /*
                        gestione commenti 
                        */
                        if(inputLine.length() > 0){
                            if(input == '/' && inputLine.charAt(inputLine.length()-1) == '/'){
                                while( '\n' != (char)cin.read() ){}
                                inputLine = inputLine.substring(0, inputLine.length()-1);//rimuovo dalla line di input la sintasi del comento
                            }
                            if(input == '#')
                                while( '\n' != (char)cin.read() ){}

                            if(input == '*' && inputLine.charAt(inputLine.length()-1) == '/'){
                                char theLastOne = 'a',cur='a';//serve per far funzionare il ciclo sotto, se no esce con stringa /*/ ... */
                                while( (cur = (char)cin.read()) != '/' && theLastOne != '*')
                                        theLastOne = cur;
                            }
                        }
                        if(input != '\n' && input != '\t') //'tlgo 'i 'da capo' dalla stringa di input
                            inputLine+= input;
                        
                        if(input == ';'){
                            endLine = false;
                        }
                    }
                }
                /*
                create the GRaf
                */
                /*
                determino se e' un graffo orientato o no
                (solo una volta)
                */
                if(GrafType){
                    if(inputLine.charAt(0) == 'd'){
                        //set type of the graph
                    }
//                            faccio split in base a ' '
                    int i;
                    for(i = 0 ; i< inputLine.length();i++){
                        if(inputLine.charAt(i) == ' ')
                            break;
                    }
                    int j;
                    for(j = ++i ; j< inputLine.length();j++){
                        if(inputLine.charAt(j) == ' ')
                            break;
                    }
//                            set name of the graph inputLine.subSequence(i, j);
                    GrafType=false;
                }  
            }
            System.out.print(inputLine);
            return res;
        }
	public static void main(String[] argv)throws IOException {

            Node n1 = new Node("n1");
            Node n2 = new Node("n2");
            Node n3 = new Node("n3");

            Struttura st1 = n1.getRepp();
            Struttura st2 = n2.getRepp();
            Struttura st12 = st1.union(st2);
            Struttura st3 = n3.getRepp();
            
            Struttura tmp = st12.find();
            if(tmp.getClass().equals(List.class))
                System.out.print("Sembra che funziona");
            System.out.print(((List<Node>) tmp).length());
            

//            if(st1.find() == st2.find())
//                System.out.print("Dai cazzo");
//            if(st1.find() == st3.find())
//            System.out.print("Ci siamo");
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////           
//            Node tmp = new Node("Tmp");
//            TreeSet<Node> set = new TreeSet<>(tmp);
//            List<Node> list = new List<>();
//            List<Node> listone = new List<>();
//            if(set.getClass().equals(list.getClass()))
//                System.out.print("You can't do it man");
//            if(listone.getClass().equals(list.getClass()))
//                System.out.print("Credo che funzioni");
//            Struttura st1 = (Struttura) set;
//            Struttura st2 = (Struttura) list;
//            if(set.getClass().equals(list.getClass()))
//                System.out.print("You can't do it man");
//            if(listone.getClass().equals(list.getClass()))
//                System.out.print("Credo che funzioni");
            ////////////////////////////////////////////////////////////////////
//            String st = "programmer";
//            System.out.print(st.substring(9, 10));
//            for(int i=0; i < 10 ;i++){
//                
//                System.out.print(i);
//                System.out.print('\n');
//                if(i%3 == 0){
//                    i+=2;
//                }
//            }
//            System.out.print('\n');
////            st = "I am small and incinificant but, even if I am who I am I will do my best! ";
//            st = "";
//            String [] output = splitPro(st," ");
//            System.out.print(output.length);
//            for (String output1 : output) {
//                System.out.print('\n');
//                System.out.print(output1);
//                System.out.print('\n');
//            }
            ////////////////////////////////////////////
//		String inputLine="";
//		InputStreamReader cin = new InputStreamReader(System.in);
//		boolean endInput = true; // la variabile che mi permette di capire che
//                //ho finito di leggere input
//                boolean endLine = true;// per leggere le righe
//                boolean GrafType = true; // fa si che viene stabilito se grafo
//                boolean inComment = false; // aiuta a ignorare i comenti
//                //e' orientato o meno solo una volta
//		
//                while(endInput){
//                    char input;
//                    while(endLine){
//			input = (char)cin.read();
//                        /*
//                        gestione commenti 
//                        */
//                        if(inputLine.length() > 0){
//                            if(input == '/' && inputLine.charAt(inputLine.length()-1) == '/')
//                                while( '\n' != (char)cin.read() ){}
//                            
//                            if(input == '#')
//                                while( '\n' != (char)cin.read() ){}
//                            
//                            if(input == '*' && inputLine.charAt(inputLine.length()-1) == '/'){
//                                char theLastOne = 'a',cur='a';//serve per far funzionare il ciclo sotto, se no esce con stringa /*/ ... */
//                                while( (cur = (char)cin.read()) != '/' && theLastOne != '*')
//                                        theLastOne = cur;
//                            }
//                        }
//                        if(input == ';' || input == '}')
//                            endLine = false;
//                        if(input != '\n' && input != '\t') //'tlgo 'i 'da capo' dalla stringa di input
//                            inputLine+= input;
//                    }
//                    /*
//                    create the GRaf
//                    */
//                    /*
//                    determino se e' un graffo orientato o no
//                    (solo una volta)
//                    */
//                    if(GrafType){
//                        if(inputLine.charAt(0) == 'd'){
//                            //set type of the graph
//                        }
////                            faccio split in base a ' '
//                        int i;
//                        for(i = 0 ; i< inputLine.length();i++){
//                            if(inputLine.charAt(i) == ' ')
//                                break;
//                        }
//                        int j;
//                        for(j = ++i ; j< inputLine.length();j++){
//                            if(inputLine.charAt(j) == ' ')
//                                break;
//                        }
////                            set name of the graph inputLine.subSequence(i, j);
//                        GrafType=false;
//                    }  
//                }
//		System.out.print(inputLine);
	}
}
