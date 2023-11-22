package PetStore;

import RestAssured_Utility.RA_Utiles;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class StoreAPIs {
    Response response= null;
    public Response createPetOrder(Map<String,Object> createPetOrderPayload){

        String endPoint = (String)Base.dataFromJsonFile.get("post_createPetOrderEndPoint");

        response = RA_Utiles.performPost(endPoint, createPetOrderPayload, new HashMap<String,String>());

        return  response;
    }


}
