package put_request;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;

import static herokuapp_smoketest.C01_PostRequest.bookingId;
import static io.restassured.RestAssured.given;

public class Put03 extends HerOkuAppBaseUrl {

    @Test
    public void test01(){
        //set the url
        spec.pathParams("first", "booking", "second", bookingId);

        //set the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Ali", "Can Can", 222, true, bookingDatesPojo, "BreakFeast");
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response
        Response response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();


    }



}
