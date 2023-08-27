package deneme;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get10 extends GoRestBaseUrl {

    @Test
    public void test01(){
        //set the url
        spec.pathParam("first", "users");

        //set the expected data

        //send the request get the response

       Response response = given(spec).get("{first}");
       response.prettyPrint();


       //Do aserrtion

        /*
        response.then().
                statusCode(200).
                body("meta.pagination.limit", equalTo(10)),

         */

    }
}
