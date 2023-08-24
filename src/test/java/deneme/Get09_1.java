package deneme;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09_1 extends HerOkuAppBaseUrl {

      /*
   Given
       https://restful-booker.herokuapp.com/booking/544
   When
       I send GET Request to the url
   Then
       Response body should be like that;
        {
         "firstname": "John",
         "lastname": "Smith",
         "totalprice": 111,
         "depositpaid": true,
         "bookingdates": {
             "checkin": "2018-01-01",
             "checkout": "2019-01-01"
         },
         "additionalneeds": "Breakfast"
         }
*/
    
    
    @Test
    public void test01(){
        
        //Set the URL
        
        spec.pathParams("pp1", "booking", "pp2", 544);
        
        
        //Set the expected DAta

        Map<String, String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin", "2018-01-01");
        bookingdatesMap.put("checkout", "2019-01-01");
        
        
        Map<String, Object> expectedData = new HashMap<>();
        
        expectedData.put("firstname", "John");
        expectedData.put("lastname", "Smith");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingdatesMap);
        expectedData.put("additionalneeds", "Breakfast");

        System.out.println("expectedData = " + expectedData);
        
        //send the request and get the response

        Response response = given(spec).get("{pp1}/{pp2}");

        response.prettyPrint();

        //Do assertion

        Map<String , Object>  actualData =  response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));

        assertEquals(bookingdatesMap.get("checkin"), ((Map) actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"), ((Map) actualData.get("bookingdates")).get("checkout"));

        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));


    }
}
