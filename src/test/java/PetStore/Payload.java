package PetStore;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class Payload {
    public  static String getCreatePetOrderPayloadFromString(String id,String petId,String quantity,String shipdate,String status,boolean complete ){
        String payload = "{\n" +
                "  \"id\": "+id+",\n" +
                "  \"petId\": "+petId+",\n" +
                "  \"quantity\": "+quantity+",\n" +
                "  \"shipDate\": \""+shipdate+"\",\n" +
                "  \"status\": \""+status+"\",\n" +
                "  \"complete\": "+complete+"\n" +
                "}";

        return  payload;
    }

    public  static Map<String, Object> getCreatePetOrderPayloadFromMap(String id, String petId, String quantity, String shipDate, String status, boolean complete ){
       Map<String,Object> payload = new HashMap<String, Object>();

        payload.put("id",id);
        payload.put("petId",petId);
        payload.put("quantity",quantity);
        payload.put("shipDate",shipDate);
        payload.put("status",status);
        payload.put("complete",complete);

        return  payload;
    }

    public  static Map<String, Object> getCreatePetOrderPayloadFromMap(){
        Map<String,Object> payload = new HashMap<String, Object>();
        Faker faker = new Faker();
        payload.put("id",faker.number().digits(5));
        payload.put("petId",faker.number().digits(5));
        payload.put("quantity",faker.number().digits(3));
        payload.put("shipDate","2023-11-21T09:51:58.683Z");
        payload.put("status","placed");
        payload.put("complete","true");

        return  payload;
    }


}
