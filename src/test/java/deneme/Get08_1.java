package deneme;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08_1 extends JsonPlaceHolderBaseUrl {

      /*
    Given
       https://jsonplaceholder.typicode.com/todos/2
   When
       I send GET Request to the URL
   Then
       Status code is 200
       And "completed" is false
       And "userId" is 1
       And "title" is "quis ut nam facilis et officia qui"
       And header "Via" is "1.1 vegur"
       And header "Server" is "cloudflare"
       {
           "userId": 1,
           "id": 2,
           "title": "quis ut nam facilis et officia qui",
           "completed": false
       }
*/

    @Test
     public void test01(){

        //set the URL

        spec.pathParams("pp1", "todos", "pp2", 2);

    //Set tha expected Data

       Map<String , Object> expectedData =  new JsonPlaceHolderTestData().expectedDataMapMethod(1,"quis ut nam facilis et officia qui", false );
        System.out.println(expectedData);


        //SEnd the requets and get the resonse

        Response response = given(spec).get("{pp1}/{pp2}");
        response.prettyPrint();


        //Do assertion

        Map<String, Object> actualData =  response.as(HashMap.class);
        System.out.println(actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));



        assertEquals("1.1 vegur", response.header("Via"));
        assertEquals("cloudflare", response.header("Server"));



    }
}
