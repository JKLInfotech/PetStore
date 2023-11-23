package PetStore;

import PetStore.Pojo.PojoStores;
import RestAssured_Utility.RA_Utiles;
import Utility.JsonUtiles;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class StoresTest extends  StoreAPIs{

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

   // @Test
    public  void createPetOrder4(){

        Map<String, Object> payload = Payload.getCreatePetOrderPayloadFromMap("10","20","5","2023-11-21T09:51:58.683Z","placed",true);

        Response response = createPetOrder(payload);

        Assert.assertEquals(response.statusCode(),200);
    }

  //@Test
    public  void createPetOrder5(){

        Map<String, Object> payload = Payload.getCreatePetOrderPayloadFromMap();

        Response response = createPetOrder(payload);

        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public  void createPetOrder6(){

        Map<String, Object> payload = Payload.getCreatePetOrderPayloadFromMapAndEnum();

        Response response = createPetOrder(payload);

        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public  void createPetOrder7(){

        PojoStores payload = Payload.getCreatePetOrderPayloadFromPojo();

        Response response = createPetOrder(payload);

        Assert.assertEquals(response.statusCode(),200);
    }

//    @Test
//    public  void createPetOrder8() throws JsonProcessingException {
//
//        PojoStores payload = new PojoStores();
//
//        Response response = createPetOrder((Map<String, Object>) payload);
//
//        Assert.assertEquals(response.statusCode(),200);
//
//       ObjectMapper objectMapper  = new ObjectMapper();
//        Response createStoreReponse =  objectMapper.readValue(response.getBody().asString(), PojoStores.class);
//
//        Assert.assertEquals(createStoreReponse,payload);
//
//    }


}
