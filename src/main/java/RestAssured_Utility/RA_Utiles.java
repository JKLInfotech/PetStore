package RestAssured_Utility;

import Reporting.ExtentReportManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import java.util.Map;

public class RA_Utiles {
    private static RequestSpecification getRequestSpecifications(String endPoint, Object payload, Map<String,String> headers){

        return RestAssured.given()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(payload);

    }

    public static void printRequestLogInReport(RequestSpecification requestSpecification){

        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("<div style='color: #000000;'>Request EndPoint: "+queryableRequestSpecification.getBaseUri()+"</div>");
        ExtentReportManager.logInfoDetails("<div style='color: #000000;'>Request Type: "+queryableRequestSpecification.getMethod()+"</div>");
        ExtentReportManager.logInfoDetails("<div style='color: #000000;'>Request Header: </div>");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.logInfoDetails("<div style='color: #000000;'>Request Body: </div>");
        ExtentReportManager.logJson(queryableRequestSpecification.getBody());

    }

    public static void  printResponseLogInReport(Response response){
        ExtentReportManager.logInfoDetails("<div style='color: #000000;'>Response Code: "+response.getStatusCode()+"</div>");
        ExtentReportManager.logInfoDetails("<div style='color: #000000;'>Response Header: </div>");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("<div style='color: #000000;'>Response Body: </div>");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
        ExtentReportManager.logInfoDetails("<div style='color: #000000;'>Response Time: "+response.getTime()+"</div>");


    }


    //String payload
    public  static Response   performPost(String endPoint, String payload, Map<String,String> headers){
        RequestSpecification requestSpecification = getRequestSpecifications(endPoint,payload,headers);
        Response  response = requestSpecification.post();

        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);

        return response;
    }

    //Map payload
    public  static  Response performPost(String endPoint, Map<String, Object> payload, Map<String,String> headers){
        RequestSpecification requestSpecification = getRequestSpecifications(endPoint,payload,headers);
        Response  response = requestSpecification.post();

        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);

        return  response;
    }

}
