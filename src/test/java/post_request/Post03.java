package post_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03 extends JsonPlaceHolderBaseUrl {

    @Test
    public void test01(){
        //set the Url
        spec.pathParam("first", "todos");


        // set the expected data

         JsonPlaceHolderPojo expectedData= new JsonPlaceHolderPojo(55, "Tidy your room", false);
        System.out.println("expectedData = " + expectedData);

        //Sen the request and get the response

       Response response =  given(spec).body(expectedData).post("{first}");
        response.prettyPrint();


        //Do assertion
        JsonPlaceHolderPojo actualData= response.as(JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getUserId(), actualData.getUserId());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getCompleted(), actualData.getCompleted());


    }
}
