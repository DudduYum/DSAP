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
            boolean space = false;
            String res = "";
            /*
            il metodo score una stringa ed elimina da essa tutte le occorenze 
            multiple di ' '
            */
            for(int i = 0; i< st.length();i++){
                if( ! (st.charAt(i) == ' ' && space))     //aggiungo char alla nuova stringa se quello e' diverso da ' '
                    res+= st.charAt(i);
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
			if(input == ';' || input == '{')
                            endLine = false;
                        if(input != '\n' && input != '\t') //'tlgo 'i 'da capo' dalla stringa di input
                            inputLine+= input;
                    }
                    /*
                    create the GRaf
                    */
                    
                    /*
                    gestione commenti 
                    */
                    if(
                            !(inputLine.substring(0, 2).equals("//") || inputLine.substring(1, 3).equals("//"))){
                        
                    }
                    if(! (inputLine.charAt(0) == '/' && inputLine.charAt(1) == '/')){
                        
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
                }
		System.out.print(inputLine);
	}
}
