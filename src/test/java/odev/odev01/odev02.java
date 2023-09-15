package odev.odev01;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class odev02 extends ReqresBaseUrl {

     /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    @Test
    public void odev02(){

        // i)Set the url

        spec.pathParams("first", "users", "second", 23);


        //ii) Set the expected data

        // iii) Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();


        //iv) Do assertion --> Doğrulama yap

        response.then().statusCode(404).statusLine("HTTP/1.1 404 Not Found").body("", hasSize(lessThan(0)));

        //response.body().asString().equals(" ");


        //assertEquals(response.body().prettyPrint(), "");

        String server = response.header("Server");
        assertEquals("cloudflare", server );


        //Response body should be empty
        assertTrue(response.as(HashMap.class).isEmpty());//Gelen body'yi map'e çevirip boş olduğunu doğruluyoruz.

    }
}
