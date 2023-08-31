package post_request;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post04 extends HerOkuAppBaseUrl {

    @Test
    public void test01(){
        //set the url
        spec.pathParams("first", "booking");

        //set the expected data(payload)
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2023-09-21", "2023-10-09");
        BookingPojo expectedData = new BookingPojo("Yasin", "ANIL", 999, true, bookingDatesPojo, "livres");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
       Response response= given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
       BookingResponsePojo actualData =  response.as(BookingResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getBooking().getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getBooking().getDepositpaid());
        assertEquals(bookingDatesPojo.getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(), actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());


    }
}
