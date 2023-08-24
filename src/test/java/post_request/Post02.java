package post_request;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post02  extends HerOkuAppBaseUrl {



    @Test
    public void test01(){

        //set the uRL
        spec.pathParams("pp1", "booking");

        //set the expected data

        HerOkuAppTestData obj = new HerOkuAppTestData();

        Map<String, String> bookingDatesMap = obj.bookingdatesMapMethod("2021-09-09", "2021-09-21");
        Map<String, Object> expectedData = obj.expectedDataMapMethod("Yasin", "Anil", 11111, true, bookingDatesMap, "" );

        System.out.println("expectedData = " + expectedData);

        //send the request and the response

       Response response =  given(spec).body(expectedData).post("{pp1}");
       response.prettyPrint();

       //yukrada hata alirsan body'den once contentType(ContentType.JSON) yazmalisin
        //ama biz zaten Spec'in icine contentType'i koydugumuz icin, buna gerek kalmadi.


        //Do assertion
        //expected data ile actual data yi karsilastiracagiz, expected data map , donen response'yi de map'e cevirmek gerekiyor
        //bunun icin "response.as(HashMap.class);"==> bunu kullandik
        Map<String, Object> actualData =  response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("firstname"), ((Map)actualData.get("booking")).get("firstname"));
        assertEquals(expectedData.get("lastname"), ((Map)actualData.get("booking")).get("lastname"));
        assertEquals(expectedData.get("totalprice"), ((Map)actualData.get("booking")).get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), ((Map)actualData.get("booking")).get("depositpaid"));
        assertEquals(bookingDatesMap.get("checkin"), ((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(bookingDatesMap.get("checkout"), ((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkout"));

    }
}
