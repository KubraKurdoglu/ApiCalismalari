package put_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put01 extends JsonPlaceHolderBaseUrl {

      /*
    Given
     1) https://jsonplaceholder.typicode.com/todos/198
     2) {
             "userId": 21,
             "title": "Wash the dishes",
             "completed": false
           }
    When
I send PUT Request to the Url
 Then
      Status code is 200
      And response body is like   {
                   "userId": 21,
                   "title": "Wash the dishes",
                   "completed": false
                   "id": 198
                  }
  */

    @Test
    public void put01(){
        //sout'lari silmek gerekiyormus, normalde kullanilmiyormus

        //Set the url(BaseURL+EndPOINT)

        spec.pathParams("first", "todos", "second", 198);

        //Set the expected data(Map'e cevirdi dinamik olsun diye)

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 21);
        expectedData.put("title", "Wash the dishes");
        expectedData.put("completed", false);
        System.out.println("expectedData = " + expectedData);


        //Send the request and get the response
        Response response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();


        //Do Assertion
        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialisation==>Json data to Java, (json datayi javaya cevirp gonderdik)
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
    }

    @Test
    public void put01b(){//yukardaki class ile tek fark "set expected data" kisminda yeni bir method kullanmasi

        //Set the url(BaseURL+EndPOINT)

        spec.pathParams("first", "todos", "second", 198);

        //Set the expected data

        Map<String, Object> expectedData = new JsonPlaceHolderTestData().expectedDataMapMethod(21, "Wash the dishes", false);


        //Send the request and get the response
        Response response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();


        //Do Assertion
        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialisation==>Json data to Java, (json datayi javaya cevirp gonderdik)
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
    }
}
