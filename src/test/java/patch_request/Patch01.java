package patch_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Patch01 extends JsonPlaceHolderBaseUrl {


    @Test
    public void test01(){
        //set the URL

        spec.pathParams("pp1", "todos", "pp2", 198);


        //set the expected data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();

        Map<String, Object> expectedData= obj.expectedDataMapMethod(null, "Wash the dishes" ,null);

        //send the request and get the response

       Response response =  given(spec).body(expectedData).patch("{pp1}/{pp2}");
        response.prettyPrint();

        //Do assertion




    }

    @Test
    public void test02(){
        //set the URL

        spec.pathParams("pp1", "todos", "pp2", 198);


        //set the expected data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();

        Map<String, Object> expectedData= obj.expectedDataMapMethod(80, null,null);

        //send the request and get the response

        Response response =  given(spec).body(expectedData).patch("{pp1}/{pp2}");
        response.prettyPrint();


    }
}
