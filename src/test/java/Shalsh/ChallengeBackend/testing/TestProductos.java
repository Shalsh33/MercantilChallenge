package Shalsh.ChallengeBackend.testing;

import org.json.*;

import org.junit.Test;

import static io.restassured.RestAssured.given;


public class TestProductos {

    public static final String URL = "http://localhost:8080/productos";
    public static final String PATH = "/89efb206-2aa6-4e21-8a23-5765e3de1f31";

    @Test
    public void crearProducto(){
        JSONObject req = new JSONObject();
        try {
            req.put("id", "89efb206-2aa6-4e21-8a23-5765e3de1f31");
            req.put("nombre", "Especial");
            req.put("descripcion_corta", "Jamón y Morrón");
            req.put("descripcion_larga", "Pizza especial con jamón, morrón y huevo");
            req.put("precio_unitario", 550.0);
        } catch (Exception e){

        }

        given().contentType("Application/JSON").body(req.toString()).when().post(URL).then().statusCode(201);
    }

    @Test
    public void crearSegundoProducto(){
        JSONObject req = new JSONObject();
        try {
            req.put("id", "e29ebd0c-39d2-4054-b0f4-ed2d0ea089a1");
            req.put("nombre", "Margarita");
            req.put("descripcion_corta", "Albahaca, tomate y queso");
            req.put("descripcion_larga", "Pizza Margarita con tomate, queso y aceite de albahaca");
            req.put("precio_unitario", 700.0);
        } catch (Exception e){

        }

        given().contentType("Application/JSON").body(req.toString()).when().post(URL).then().statusCode(201);
    }

    @Test
    public void modificarProducto(){
        JSONObject req = new JSONObject();
        try{
            req.put("nombre", "Especial");
            req.put("descripcion_corta", "Jamón y Morrón");
            req.put("descripcion_larga", "Pizza especial con jamón, morrón y huevo");
            req.put("precio_unitario", 500.0);
        } catch (Exception e){

        }

        given().contentType("Application/JSON").body(req.toString()).when().put(URL+PATH).then().statusCode(204);
    }

    @Test
    public void obtenerProducto(){
        given().get(URL+PATH).then().statusCode(200);
    }

    @Test
    public void obtenerProductoFallido(){
        given().get(URL+"/89efb206-2aa6-4e21-8a23-5765e3de1f30").then().statusCode(404);
    }

    @Test
    public void eliminarProducto(){
        given().delete(URL+PATH).then().statusCode(204);
    }

}
