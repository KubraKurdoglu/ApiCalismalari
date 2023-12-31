package odev.odev01;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class odev03 extends ReqresBaseUrl {
    /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “email” is “janet.weaver@reqres.in”,
       And
           “first_name” is "Janet"
       And
           “last_name” is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */


    @Test
    public void odev03() {
        // i)Set the url

        spec.pathParams("first", "users", "second", 2);


        //ii) Set the expected data

        // iii) Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();


        //iv) Do assertion --> Doğrulama yap

        //  JsonPath jsonPath = response.jsonPath();

        response.then().statusCode(200).contentType("application/json").
                body("data.email", equalTo("janet.weaver@reqres.in"),
                "data.first_name", equalTo("Janet"), "data.last_name", equalTo("Weaver"),
                "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }
}
