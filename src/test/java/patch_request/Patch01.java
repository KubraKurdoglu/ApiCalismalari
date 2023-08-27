package patch_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

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

        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        expectedData.put("userId", 10);
        expectedData.put("completed", true);


        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));


//eger tum datayi assert etmen gerekiyorsa hard koding le yapabilirsin
        //neden tum data dedik, cunku patch request te sadece bir datayai yukarda degistirdin
        //neyi degistiriyorsan onu aaseert etmen yeterli, ama tamamini assert etmek istersen
        // ya diger degerleri asagaidaki gibi hard kodin le assert et
        // yada expectedData.put("userId", 12)==> diyip map e onlari eleman olarak ekleyip assertion yapabilirisin


        //!!!!!burda patch request yaptigimiz icin tum kodlari assert yapmadik


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
