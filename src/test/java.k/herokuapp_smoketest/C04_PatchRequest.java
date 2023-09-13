package herokuapp_smoketest;
import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static herokuapp_smoketest.C01_PostRequest.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C04_PatchRequest extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    And
        {
        "additionalneeds": "Lunch"
        }
    When
        Send patch request
    Then
        Status code is 200
    And
        Body:
        {
        "firstname": "Ali",
        "lastname": "Can",
        "totalprice": 222,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Lunch"
    }
     */

    @Test
    public void patch01(){
        //Set the url
        spec.pathParams("first","booking", "second", bookingId);

        //Set the expected data
        Map<String, Object> expectedData =  new HashMap<>();
        expectedData.put("additionalneeds", "Lunch");

        //Send the request and get the response

        Response response = given(spec).body(expectedData).patch("{first}/{second}");
        response.prettyPrint();


        //Do assertion
       Map<String, Object> actualData =  ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
       assertEquals(200, response.statusCode());
       assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));


       //Runner class tan geciyor, burdan "method not alloved" veriyor.

    }


}