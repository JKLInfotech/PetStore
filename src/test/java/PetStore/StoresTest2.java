package PetStore;

import PetStore.Pojo.PojoStores;
import RestAssured_Utility.AssertionUtiles;
import Utility.ExcelUtiles;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

public class StoresTest2 {

    StoreAPIs storeApis;


    //@Test
    public  void createPetOrder6(){
        storeApis =  new StoreAPIs();

        PojoStores  payload = Payload.getCreatePetOrderPayloadFromPojo();

        Response response = storeApis.createPetOrder(payload);

        Map<String,Object> expectedValueMap = new HashMap<>();
        expectedValueMap.put("id",payload.getId());
        expectedValueMap.put("petId",payload.getPetId());
        expectedValueMap.put("quantity",payload.getQuantity());
        expectedValueMap.put("complete",payload.getComplete());
        expectedValueMap.put("status",payload.getStatus());
        expectedValueMap.put("shipDate",payload.getShipDate());

        Assert.assertEquals(response.statusCode(),200);
        AssertionUtiles.assertExceptedValuseWithJsonPath(response,expectedValueMap);


    }


    @Test(dataProvider = "createPetOrderData")
    public  void createPetOrderByDataDriven(PojoStores pojoStores){

        Response response = storeApis.createPetOrder(pojoStores);

        Map<String,Object> expectedValueMap = new HashMap<>();
        expectedValueMap.put("id",pojoStores.getId());
        expectedValueMap.put("petId",pojoStores.getPetId());
        expectedValueMap.put("quantity",pojoStores.getQuantity());
        expectedValueMap.put("complete",pojoStores.getComplete());
        expectedValueMap.put("status",pojoStores.getStatus());
        expectedValueMap.put("shipDate",pojoStores.getShipDate());

        Assert.assertEquals(response.statusCode(),200);
        AssertionUtiles.assertExceptedValuseWithJsonPath(response,expectedValueMap);


    }

    @DataProvider(name = "createPetOrderData")
    public Iterator<PojoStores> getCreateStoreData() throws IOException {
        List<LinkedHashMap<String,String>> excelDataAsListOfMap = ExcelUtiles.getExcelDataAsListOfMap("StoreData","Sheet1");

        List<PojoStores> pojoStoresData = new ArrayList<>();

        for (LinkedHashMap<String,String> data :excelDataAsListOfMap){
            PojoStores pojoStores = PojoStores.builder()
                    .id(data.get("id"))
                    .petId(data.get("petId"))
                    .quantity(data.get("quantity"))
                    .shipDate(data.get("shipDate"))
                    .complete(data.get("complete"))
                    .status(data.get("status"))
                    .build();

            pojoStoresData.add(pojoStores);
        }

        return pojoStoresData.iterator();

    }

}
