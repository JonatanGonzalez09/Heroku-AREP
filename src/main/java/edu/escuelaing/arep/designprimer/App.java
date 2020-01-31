package edu.escuelaing.arep.designprimer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
    }

    /**
     * Calcula la media de una lista de numeros
     * 
     * @param lista La LinkedList con los datos.
     * @return La media del conjunto de datos.
     * @throws Exception
     * @throws NumberFormatException
     */
    public static double calcularMedia(LinkedList lista) throws NumberFormatException, Exception {
        Nodo node = lista.getHead();
        double mean = Double.parseDouble(node.getDatos());
        int size = 1;
        while (node.nextNodo() != null) {
            mean += Double.parseDouble(lista.nextNodo(node.getId()).getDatos());
            node = node.nextNodo();
            size++;
        }
        return mean / size;
    }

    /**
     * Calcula la desviacion estandar de un coonjunto de datos.
     * 
     * @param lista La linkedList con los datos.
     * @param media La media sacada anteriormente para solucionar la desviacion
     *             estandar.
     * @return La desviacion estandar
     * @throws Exception
     */
    public static double calcularDesviacion(LinkedList lista, double media) throws Exception {
        Nodo node = lista.getHead();
        double sDeviation = Math.pow(Double.parseDouble(node.getDatos()) - media, 2);
        int size = 0;
        while (node.nextNodo() != null) {
            sDeviation += Math.pow(Double.parseDouble(lista.nextNodo(node.getId()).getDatos()) - media, 2);
            node = node.nextNodo();
            size++;
        }
        return Math.pow(sDeviation/size, 0.5);
    }

}