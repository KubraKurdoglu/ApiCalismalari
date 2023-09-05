package delete;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Delete01 extends JsonPlaceHolderBaseUrl {

    @Test
    public void test01(){

        //set the url
        spec.pathParams("first", "todos", "second", 198);


        //set the expected data
        Map<String, Object> expectedData = new HashMap<>();

        //send the request and get the response

        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

        //do assertion

        Map<String, Object> actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);

        assertEquals(200, response.statusCode());

        //1.YOL
        assertEquals(expectedData, actualData);

        //2.YOL
        assertTrue(actualData.isEmpty());

        //3.YOL
        assertEquals(0, actualData.size());

    }
}
