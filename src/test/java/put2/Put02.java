package put2;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponsePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends DummyRestApiBaseUrl {

    @Test
    public void test01(){
        ///set the url
        spec.pathParams("first", "update", "second", 21);


        //set the expected data
        DummyRestApiDataPojo expectedData= new DummyRestApiDataPojo("Ali Can", 111111, 23, "Perfect image");
        System.out.println("expectedData = " + expectedData);


        //send the request and get the response

        Response response = given(spec).contentType(ContentType.JSON).body(expectedData).put("{first}/{second}");
        response.prettyPrint();

        //Do asssertion
        DummyRestApiResponsePojo actulaData = ObjectMapperUtils.convertJsonToJava(response.asString(), DummyRestApiResponsePojo.class);
        System.out.println("actulaData = " + actulaData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getEmployee_age(),actulaData.getData().getEmployee_age());
        assertEquals(expectedData.getEmployee_salary(),actulaData.getData().getEmployee_salary());
        assertEquals(expectedData.getEmployee_name(),actulaData.getData().getEmployee_name());
        assertEquals(expectedData.getProfile_image(),actulaData.getData().getProfile_image());









    }
}
