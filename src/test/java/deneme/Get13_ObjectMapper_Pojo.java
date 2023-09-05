package deneme;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import test_data.JsonPlaceHolderTestData;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13_ObjectMapper_Pojo extends JsonPlaceHolderBaseUrl {


    @Test
    public void test01(){

        //set the url
        spec.pathParams("first", "todos", "second", 198);

        //set the expected data

        String body = JsonPlaceHolderTestData.expectedDataInString(10, "quis eusi est sint explicabo", true);

        JsonPlaceHolderPojo expectedData =  ObjectMapperUtils.convertJsonToJava(body, JsonPlaceHolderPojo.class);
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //do assertion
        JsonPlaceHolderPojo actualData =  ObjectMapperUtils.convertJsonToJava(response.asString(), JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getCompleted(), actualData.getCompleted());
        assertEquals(expectedData.getUserId(), actualData.getUserId());




    }
}
