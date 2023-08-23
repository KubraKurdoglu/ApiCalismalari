package pojos;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05_ObjectMapper_Pojo extends JsonPlaceHolderBaseUrl {

      /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }


            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test//En iyi yöntem: ObjectMapper + Pojo Class
    public void post05() {

        //Set the Url
        spec.pathParam("first", "todos");

        //Set expected data(ayni zamanda gondrecegimiz data da bu)
       JsonPlaceHolderPojo expectedData =  new JsonPlaceHolderPojo(55, "Tidy your room", false);

       //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
        //test class larin da exception cok istenmezmis. Burda bir reusable method yapacagiz

        JsonPlaceHolderPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getUserId(), actualData.getUserId());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getCompleted(), actualData.getCompleted());

    }
}
