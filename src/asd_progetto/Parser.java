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
            String res = "";
     
            for(int i = 0; i< st.length();i++){
                if( ! (st.charAt(i) == ' ' && space))     //aggiungo il carattere alla stringa solo se non lo spazio oppure è lo spazio 
                    res+= st.charAt(i);                     // incontrato per prima volta
                space = (st.charAt(i) == ' ')?   true : false;// decido nuovo valore di space
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
        
	public static void main(String[] argv)throws IOException {
		String inputLine="";
		InputStreamReader cin = new InputStreamReader(System.in);
		boolean endInput = true; // la variabile che mi permette di capire che
                //ho finito di leggere input
                boolean endLine = true;// per leggere le righe
                boolean GrafType = true; // fa si che viene stabilito se grafo
                boolean inComment = false; // aiuta a ignorare i comenti
                //e' orientato o meno solo una volta
		
                while(endInput){
                    char input;
                    while(endLine){
			input = (char)cin.read();
                        /*
                        gestione commenti 
                        */
                        if(inputLine.length() > 0){
                            if(input == '/' && inputLine.charAt(inputLine.length()-1) == '/')
                                while( '\n' != (char)cin.read() ){}
                            
                            if(input == '#')
                                while( '\n' != (char)cin.read() ){}
                            
                            if(input == '*' && inputLine.charAt(inputLine.length()-1) == '/'){
                                char theLastOne = 'a',cur='a';//serve per far funzionare il ciclo sotto, se no esce con stringa /*/ ... */
                                while( (cur = (char)cin.read()) != '/' && theLastOne != '*')
                                        theLastOne = cur;
                            }
                        }
                        if(input == ';' || input == '}')
                            endLine = false;
                        if(input != '\n' && input != '\t') //'tlgo 'i 'da capo' dalla stringa di input
                            inputLine+= input;
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
	}
}
