package requesss;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class git extends JsonPlaceHolderBaseUrl {

    @Test
    public void test01(){

        //set the url
        spec.pathParams("first", "tools");


        //set the expected data

        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //send the request and the response








    }
}
