package delete_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C02 extends JsonPlaceHolderBaseUrl{



       /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
         I send DELETE Request to the Url
      Then
         Status code is 200
         And Response body is { }
     */

        @Test
        public void delete01(){
            //Set the url
            spec.pathParams("first", "todos", "second", 198);

            //Set the expected data
            Map<String, String> expectedData = new HashMap<>();


            //Send the Request end get the response

            Response response = given(spec).delete("{first}/{second}");
            response.prettyPrint();

            //Do assertion
            Map<String, String> actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
            assertEquals(200, response.statusCode());

            //1.YOL
            assertEquals(expectedData.size(), actualData.size());

            //2.YOL
            assertEquals(0, actualData.size());


            //3.YOL

            assertTrue(actualData.isEmpty());





        }

}
