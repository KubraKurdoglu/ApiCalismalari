package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static herokuapp_smoketest.C01_PostRequest.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C05_DeleteRequest extends HerOkuAppBaseUrl {

    /*
Given
https://restful-booker.herokuapp.com/booking/:id

When
Send  DELETE request

Then
Status code is 200

And
Body should be : Created
 */

    @Test
    public void delete01() {

        //Set the Url
        spec.pathParams("first", "booking", "second", bookingId);

        //Set the expected data

        String expectedData = "Created";


        //Send the request and get the response
        Response response = given(spec).delete("{first}/{second}");

        //Do assertion

        assertEquals(201, response.statusCode());
        assertEquals(expectedData, response.asString());


    }
}
