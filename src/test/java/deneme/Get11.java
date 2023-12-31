package deneme;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get11 extends HerOkuAppBaseUrl {

      /*
        Given
            https://restful-booker.herokuapp.com/booking/803
        When
          I send GET Request to the URL
       Then
          Status code is 200
      And
          Response body is like:(body boyl olacak demek assertion yap bunun icinde expected dta olustur)
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
    public void get11() {
        //Set the url
        spec.pathParams("first", "booking", "second", 803);

        //set the expected data (assertion yapabilmel icin expected data'yi kurmamiz lazim
        //bunu "Pojo Class" ile yapacagiz

        //Set the expected data

        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("28-01-01", "29-01-01");
        BookingPojo expectedData = new BookingPojo("John", "Smith", 111, true, bookingDatesPojo, "breakfast");

        //Send the request and the get the response

        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion(bunu yapabilmek icin  response yi nin data turunu degistiriyoruz
        BookingPojo actualData = response.as(BookingPojo.class);//De-serialization
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(bookingDatesPojo.getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(), actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());



    }


}
