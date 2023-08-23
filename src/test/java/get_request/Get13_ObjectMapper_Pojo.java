package get_request;

import base_urls.JsonPlaceHolderBaseUrl;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import test_data.JsonPlaceHolderTestData;
import utils.ObjectMapperUtils;

public class Get13_ObjectMapper_Pojo extends JsonPlaceHolderBaseUrl {
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
    public void get13(){
        //Set the url
        spec.pathParams("first", "todos", "second", 198);

        //Set the expected data
//        String body = "{\n" +
//                        "\"userId\": 10,\n" +
//                        "\"id\": 198,\n" +
//                        "\"title\": \"quis eius est sint explicabo\",\n" +
//                        "\"completed\": true\n" +
//                        "}";

        String body = JsonPlaceHolderTestData.expectedDataInString(10,"quis eius est sint explicabo",true);

        JsonPlaceHolderPojo expectedData = ObjectMapperUtils.convertJsonToJava(body, JsonPlaceHolderPojo.class);
        System.out.println("expectedData = " + expectedData);




    }

}
