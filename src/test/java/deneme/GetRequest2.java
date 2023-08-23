package deneme;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class GetRequest2 extends HerOkuAppBaseUrl {


    //When I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/5 And Accept type is “application/JSON”
    //Then HTTP Status Code should be 200 And first name should be “Mary”
    //And total price should be 814

    @Test
    public void test01(){

        //set the URL
        spec.pathParams("ppt1", "booking", "ppt2", "5");

        //set the expected data

        //send the request and get the response

        Response response = given(spec).get("{ppt1}/ {ppt2}");

        response.prettyPrint();

        //Do assertion

        response.then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", hasItem("Sally")).
                body("totalprice", hasItem(675));

    }

}
