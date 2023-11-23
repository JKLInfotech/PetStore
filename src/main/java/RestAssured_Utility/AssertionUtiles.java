package RestAssured_Utility;

import Reporting.ExtentReportManager;
import Reporting.Setup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.response.Response;

import java.util.*;

public class AssertionUtiles {
    public static void assertExceptedValuseWithJsonPath(Response response, Map<String,Object> expectedValuesMap){

        List<AssertionKeys> actualValuesMap = new ArrayList<>();
        actualValuesMap.add(new AssertionKeys("JSON_PATH","EXPECTED_VALUE","ACTUAL_VALUE","RESULT"));
        boolean allMatched = true;

        Set<String> jsonPaths = expectedValuesMap.keySet();

        for (String jsonPath : jsonPaths){
           Optional<Object> actualValue =  Optional.ofNullable(response.jsonPath().get(jsonPath));

           if(actualValue.isPresent()){
               Object value = actualValue.get();
               if(value.equals(expectedValuesMap.get(jsonPath))){
                   actualValuesMap.add(new AssertionKeys(jsonPath,expectedValuesMap.get(jsonPath),value,"Mached"));
               }else{
                   allMatched = false;
                   actualValuesMap.add(new AssertionKeys(jsonPath,expectedValuesMap.get(jsonPath),value,"Not Mached"));

               }
           }else{
               allMatched = false;
               actualValuesMap.add(new AssertionKeys(jsonPath,expectedValuesMap.get(jsonPath),"Value not found","Not Mached"));

           }
        }

        if(allMatched){
            ExtentReportManager.logPassDetails("All Assertions are passed ✔✔✔ ");
        }else{
            ExtentReportManager.logFailDetails("All Assertions are not passed ❌❌❌ ");

            String[][] finalAssertionMap =  actualValuesMap.stream().map(assertions -> new String[]{assertions.getJsonPath(),String.valueOf(assertions.getExpectedValue()),String.valueOf(assertions.getActualValue()),String.valueOf(assertions.getResult())}).toArray(String[][] :: new);

            Setup.extentTest.get().info(MarkupHelper.createTable(finalAssertionMap));
        }


    }

}
