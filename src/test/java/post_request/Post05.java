package post_request;

import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05 extends JsonPlaceHolderBaseUrl {

    @Test
    public void test01() throws JsonProcessingException {

        //get the url
        spec.pathParams("first", "todos");

        //set the expected data

       Map<String, Object> expectedData= new JsonPlaceHolderTestData().expectedDataMapMethod(55, "Tidy your room", false );
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response

        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //do assertion

        //bu sefer object mapper ile islem yapacagiz
        //bunun  icin once object mapper objesi olusturmaliyiz
        //sceurity ve hiz acisindan daha iyi object mapper
        //Object mapper iki turlu ceviri yapiyor
        // object mapper ile DESERIALIZATION YAP
        //

        Map<String, Object> actualData = new ObjectMapper().readValue(response.asString(), HashMap.class);









    }
}
