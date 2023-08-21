package get_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonPlaceHolderBaseUrl {
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
    public void get08(){
        //set the url
        spec.pathParams("pp1", "todos", "pp2", 2);//==>pp1=petparam1

        //set the expected data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String, Object> expectedData = obj.expectedDataMapMethod(1, "quis ut nam facilis et officia qui", false);

        expectedData.put("Via", "1.1 vegur");
        expectedData.put("Server", "cloudflare");



        System.out.println("expectedData = " + expectedData);


        //new JsonPlaceHolderTestData().expectedDataMapMethod(1, "quis ut nam facilis et officia qui", false);==>boyle de yazilabilir
        System.out.println("expectedData = " + expectedData);

        //Send the request get the response

       Response response = given(spec).get("{pp1}/{pp2}");// petparam'lari pp1, pp2 seklinde de kullanabilirsin, "first" "second" sekli,de de.
        response.prettyPrint();

        //Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));

        //            And header "Via" is "1.1 vegur"
        assertEquals(expectedData.get("Via"), response.header("Via"));

        //            And header "Server" is "cloudflare"
        assertEquals(expectedData.get("Server"), response.header("Server"));


    }

}
