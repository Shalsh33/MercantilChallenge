package Shalsh.ChallengeBackend.testing;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class TestPedidos {
    public static final String URL = "http://localhost:8080/pedidos";

    @Test
    public void crearPedido(){
        JSONObject req = new JSONObject();
        JSONObject p1 = new JSONObject(), p2 = new JSONObject();
        JSONArray detalle = new JSONArray();
        try {
            req.put("direccion", "Dorton Road 80");
            req.put("email", "tsayb@opera.com");
            req.put("telefono", "(0351) 48158101");
            req.put("horario", "21:00");
            p1.put("producto", "89efb206-2aa6-4e21-8a23-5765e3de1f31");
            p1.put("cantidad",1);
            p2.put("producto", "e29ebd0c-39d2-4054-b0f4-ed2d0ea089a1");
            p2.put("cantidad",1);
            detalle.put(p1);detalle.put(p2);
            req.put("detalle",detalle);
        } catch (Exception e){

        }


        given().contentType("application/JSON").body(req.toString()).when().post(URL).then().statusCode(201).log().body();

    }

    @Test
    public void crearPedidoDescuento(){
        JSONObject req = new JSONObject();
        JSONObject p1 = new JSONObject(), p2 = new JSONObject();
        JSONArray detalle = new JSONArray();
        try {
            req.put("direccion", "Dorton Road 80");
            req.put("email", "tsayb@opera.com");
            req.put("telefono", "(0351) 48158101");
            req.put("horario", "21:00");
            p1.put("producto", "89efb206-2aa6-4e21-8a23-5765e3de1f31");
            p1.put("cantidad",2);
            p2.put("producto", "e29ebd0c-39d2-4054-b0f4-ed2d0ea089a1");
            p2.put("cantidad",2);
            detalle.put(p1);detalle.put(p2);
            req.put("detalle",detalle);
        } catch (Exception e){

        }


        given().contentType("application/JSON").body(req.toString()).when().post(URL).then().statusCode(201).log().body();

    }

    @Test
    public void listarPedidosPorFecha(){
        given().get(URL+"?fecha=2022-04-22").then().statusCode(200).log().body();
    }

}
