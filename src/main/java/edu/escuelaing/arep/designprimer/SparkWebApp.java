package edu.escuelaing.arep.designprimer;

import static spark.Spark.*;

import spark.QueryParamsMap;


public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");

        post("/mean",(req, res) -> {
            QueryParamsMap map = req.queryMap();
            String[] nums = map.get("numbers").value().split("\n");
            LinkedList linkedList =  new LinkedList();
            for(String num : nums){
                linkedList.add(1, new Nodo(Double.parseDouble(num)));
            }
            return App.calcularMedia(linkedList);
        });

        post("/deviation",(req, res) -> {
            QueryParamsMap map = req.queryMap();
            String[] nums = map.get("numbers").value().split("\n"); 
            LinkedList linkedList =  new LinkedList();
            for(String num : nums){
                linkedList.add(1, new Nodo(Double.parseDouble(num)));
            }
            Double media = App.calcularMedia(linkedList);
            return App.calcularDesviacion(linkedList, media);
        });
    }

    /**
     * Metodo que asigna el puerto por el cual correr dependiendo si la variable PORT esta configurada
     * @return puerto por el cual correra el servicio
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
 }
}