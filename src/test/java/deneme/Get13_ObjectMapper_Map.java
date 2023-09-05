package deneme;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.internal.mapping.JsonbMapper;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13_ObjectMapper_Map extends JsonPlaceHolderBaseUrl {

    @Test
    public void test01(){
        //set the url
        spec.pathParams("first", "todos", "second", 198);

        //set the expected data
        String body = "{\n" +
                "\"userId\": 10,\n" +
                "\"id\": 198,\n" +
                "\"title\": \"quis eius est sint explicabo\",\n" +
                "\"completed\": true\n" +
                "}";

       Map<String, Object> expecteddata =  ObjectMapperUtils.convertJsonToJava(body, HashMap.class);
        System.out.println("expecteddata = " + expecteddata);

        //sen the request and get the response
        Response response  = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String, Object> actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expecteddata.get("userId"), actualData.get("userId"));
        assertEquals(expecteddata.get("title"), actualData.get("title"));
        assertEquals(expecteddata.get("completed"), actualData.get("completed"));

    }
}
