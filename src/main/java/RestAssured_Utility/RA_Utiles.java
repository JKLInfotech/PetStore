package RestAssured_Utility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured;

import java.util.Map;

public class RA_Utiles {

    public  static  Response performPost(String endPoint, String payload, Map<String,String> headers){
        Response response =  RestAssured.given().log().all()
                    .baseUri(endPoint)
                    .headers(headers)
                    .contentType(ContentType.JSON)
                    .body(payload)
                .when()
                   .post()
                .then()
                    .log().all().extract().response();

        return  response;
    }

    public  static  Response performPost(String endPoint, Map<String, Object> payload, Map<String,String> headers){
        Response response =  RestAssured.given().log().all()
                    .baseUri(endPoint)
                    .headers(headers)
                    .contentType(ContentType.JSON)
                    .body(payload)
                .when()
                    .post()
                .then()
                     .log().all().extract().response();

        return  response;
    }
}
