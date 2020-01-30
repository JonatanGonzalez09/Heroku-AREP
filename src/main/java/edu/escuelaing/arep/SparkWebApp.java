package edu.escuelaing.arep;

import static spark.Spark.*;

import spark.QueryParamsMap;

public class SparkWebApp {
    public static void main(String[] args) {
        port(getPort());
        post("/media", (req, res) ->{
            QueryParamsMap map = req.queryMap();
            String[] nums = map.get("numeros").value().split("\n");
            LinkedList linkedList = new LinkedList();
            for (String num : nums){
                linkedList.add(1, new Nodo(Integer.parseInt(num)));
            }
            return calcularMedia(linkedList);
        });

        post("/desviacion", (req, res) -> {
            QueryParamsMap map = req.queryMap();
            String[] nums = map.get("numeros").value().split("\n");
            LinkedList linkedList = new LinkedList();
            for (String num : nums){
                linkedList.add(1, new Nodo(Integer.parseInt(num)));
            }
            double media = calcularMedia(linkedList);
            return calcularDesviacion(linkedList, media);
        });
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

    static int getPort(){
        if (System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}