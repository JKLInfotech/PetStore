package PetStore;

import RestAssured_Utility.RA_Utiles;
import Utility.JsonUtiles;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Priority;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Stores extends  StoreAPIs{

    //@Test
    public  void createPetOrder1(){
          String endPoint =  "https://petstore.swagger.io/v2/store/order";
          String payload = Payload.getCreatePetOrderPayloadFromString("10","20","5","2023-11-21T09:51:58.683Z","placed",true);

          Response response = RA_Utiles.performPost(endPoint,payload, new HashMap<String,String>());
          Assert.assertEquals(response.statusCode(),200);
    }

  //@Test
    public  void createPetOrder2(){

        Map<String,Object> data = JsonUtiles.getJsonDataAsMap("Qa/StoreApiData.json");
        String endPoint = (String)data.get("post_createPetOrderEndPoint");
        Map<String, Object> payload = Payload.getCreatePetOrderPayloadFromMap("10","20","5","2023-11-21T09:51:58.683Z","placed",true);

        Response response = RA_Utiles.performPost(endPoint, payload, new HashMap<String,String>());
        Assert.assertEquals(response.statusCode(),200);
    }

    //@Test
    public  void createPetOrder3(){

        //IF YOU WILL NOT PASS ENVIRONMENT VALUE FROM THE COMMAND LINE ARGUMENT THEN IT TAKES DEFAULT AS QA
        String environment = System.getProperty("environment")==null ? "Qa": System.getProperty("environment");
        Map<String,Object> data = JsonUtiles.getJsonDataAsMap("/"+environment+"/StoreApiData.json");
        String endPoint = (String)data.get("post_createPetOrderEndPoint");

        Map<String, Object> payload = Payload.getCreatePetOrderPayloadFromMap("10","20","5","2023-11-21T09:51:58.683Z","placed",true);
        Response response = RA_Utiles.performPost(endPoint, payload, new HashMap<String,String>());
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public  void createPetOrder4(){

        Map<String, Object> payload = Payload.getCreatePetOrderPayloadFromMap("10","20","5","2023-11-21T09:51:58.683Z","placed",true);

        Response response = createPetOrder(payload);

        Assert.assertEquals(response.statusCode(),200);
    }

}
