package deneme;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest extends HerOkuAppBaseUrl {



    //When I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking
    //And Accept type is “application/JSON” Then HTTP Status Code should be 200
    //And Response format type should be "application/JSON"

    @Test
    public void test01(){


        //set the url

        spec.pathParams("first","booking");


        //set the expected data
        //send the request and get the response

        Response response = given(spec).get("{first}");

       // response.prettyPrint();

        //do assertion

    }

}
