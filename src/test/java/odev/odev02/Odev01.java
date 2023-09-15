package odev.odev02;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Odev01 extends HerOkuAppBaseUrl {

     /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Josh&lastname=Allen  ==> Data değişebilir
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Josh" and lastname is "Allen"   ==> Data değişebilir

     */

    @Test
    public void test01(){
        //set the url
        spec.pathParams("first", "booking").queryParams("firstname", "Josh", "lastname", "Allen");

        //set the expected result

        //send the request end get the response

        Response response = given(spec).get("/{first}");
        response.prettyPrint();

        //Do assertion

        assertEquals(200, response.statusCode());
        assertTrue(response.asString().contains("bookingid"));
        //assertEquals();







    }

}
