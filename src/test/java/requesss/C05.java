package requesss;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C05 extends JsonPlaceHolderBaseUrl {
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
