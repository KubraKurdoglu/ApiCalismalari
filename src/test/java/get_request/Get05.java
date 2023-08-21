package get_request;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET request to the URL
    Then
        Status code is 200
And
   Among the data there should be someone whose firstname is "Sally" and last name is "Brown"
        (Data içerisinde firstname değeri "Sally", lastname değeri "Brown" olan biri olmalı)
 */

    @Test
    public void get05(){

        //1. Set the URL
        spec.pathParam("first", "booking").
                queryParams("firstname", "John", "lastname", "Smith");
        //yukarda query params ile "Salyy Brown" dan kac tane var diye aradik

        //2.Set the expected data

        //3.sen the request and get the response

        Response response = given(spec).get("/{first}");
        response.prettyPrint();

        //4.Do assertion
        response.then().statusCode(200).body("", hasSize(greaterThan(0)));
        //yukarda nasil dogrulama yapabilirisn? Cunku liste de isim vs. gibi hic bilgi yok
        //bunun icin soyle yapabilirsin, arama listesi bos gelmemisse assertion "true" dir
        //belli sayida var, ama ne kadar oldugunu bilmiyorsun, o zaman "greaterThan" diyerek
        //yani belli bir sayidan fazla var mi diye arastirarak dogrulama yapabilirsin
        //greaterThan(0)==> 0'dan buyuk demek


        //burdaki bilgileri "Swagger" dokumana gore yapiyorsun


        //yada
        assertTrue(response.asString().contains("bookingid"));
    }
}
