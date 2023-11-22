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
        ExtentReportManager.logInfoDetails("Request EndPoint: "+queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Request Type: "+queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Request Header:");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Request Body:");
        ExtentReportManager.logJson(queryableRequestSpecification.getBody());

    }

    public static void  printResponseLogInReport(Response response){
        ExtentReportManager.logInfoDetails("Response Code: "+response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Header:");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Response Body:");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
        ExtentReportManager.logInfoDetails("Response Time: "+response.getTime());


    }


    public  static Response   performPost(String endPoint, String payload, Map<String,String> headers){
        RequestSpecification requestSpecification = getRequestSpecifications(endPoint,payload,headers);
        Response  response = requestSpecification.post();

        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);

        return response;
    }

    public  static  Response performPost(String endPoint, Map<String, Object> payload, Map<String,String> headers){
        RequestSpecification requestSpecification = getRequestSpecifications(endPoint,payload,headers);
        Response  response = requestSpecification.post();

        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);

        return  response;
    }
}
