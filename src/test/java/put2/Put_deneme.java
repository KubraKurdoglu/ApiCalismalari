package put2;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Put_deneme extends JsonPlaceHolderBaseUrl {

    /*
    Given
        https://jsonplaceholder.typicode.com/todos/198
    When
         I send GET Request to the URL
     Then
         Status code is 200
         And response body is like {
                                    "userId": 10,
                                    "id": 198,
                                    "title": "quis eius est sint explicabo",
                                    "completed": true
                                  }

*/

    @Test
    public void test01(){

        //set the url
        spec.pathParams("first", "todos", "second", 198);

        //set the expected data


        //send the request and get the response
        Response response = given(spec).put("{first}/{second}");
        response.prettyPrint();











    }
}
