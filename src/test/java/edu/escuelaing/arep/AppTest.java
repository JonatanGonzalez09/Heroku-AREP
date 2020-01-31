package edu.escuelaing.arep;

import edu.escuelaing.arep.designprimer.App;
import edu.escuelaing.arep.designprimer.LinkedList;
import edu.escuelaing.arep.designprimer.Nodo;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest{
    /**
     * 
     * @ Lista de elementos del primer caso
     */
    private LinkedList primerCaso() {
        LinkedList list = new LinkedList();
        list.add(1, new Nodo(160));
        list.add(1, new Nodo(591));
        list.add(1, new Nodo(114));
        list.add(1, new Nodo(229));
        list.add(1, new Nodo(230));
        list.add(1, new Nodo(270));
        list.add(1, new Nodo(128));
        list.add(1, new Nodo(1657));
        list.add(1, new Nodo(624));
        list.add(1, new Nodo(1503));
        return list;
    }

    /**
     * 
     * @return Lista de elementos del segundo caso
     */
    private LinkedList segundoCaso() {
        LinkedList list = new LinkedList();
        list.add(1, new Nodo(15.0));
        list.add(1, new Nodo(69.9));
        list.add(1, new Nodo(6.5));
        list.add(1, new Nodo(22.4));
        list.add(1, new Nodo(28.4));
        list.add(1, new Nodo(65.9));
        list.add(1, new Nodo(19.4));
        list.add(1, new Nodo(198.7));
        list.add(1, new Nodo(38.8));
        list.add(1, new Nodo(138.2));
        return list;
    }

    @Test
    public void calculateMediaTest() {
        try {
            double mean1 = App.calcularMedia(primerCaso());
            double mean2 = App.calcularMedia(segundoCaso());
            Assert.assertEquals(550.6, mean1, 2);
            Assert.assertEquals(60.32, mean2, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void calcularDesviacionTest() {
        try {
            double mean1 = App.calcularMedia(primerCaso());
            double mean2 = App.calcularMedia(segundoCaso());
            double sDeviation1 = App.calcularDesviacion(primerCaso(), mean1);
            String desvDef1 = String.format(Locale.US, "%.2f", sDeviation1);
            double sDeviation2 = App.calcularDesviacion(segundoCaso(), mean2);
            String desvDef2 = String.format(Locale.US, "%.2f", sDeviation2);
            Assert.assertEquals("572.03", desvDef1);
            Assert.assertEquals("63.26", desvDef2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}