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
public interface Struttura<T> {
    public T getNodeByLabel(String st);
    public void addNode(T n);
    public Struttura find();
    public Struttura union(Struttura rapp);
}
