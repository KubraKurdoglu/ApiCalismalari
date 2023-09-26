package requesss;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponsePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Put02 extends DummyRestApiBaseUrl {

    @Test
    public void test01(){
        //set the url
        spec.pathParams("first", "update","second", 21);

        //set the expected data
      DummyRestApiDataPojo expectedData =  new DummyRestApiDataPojo("Ali Can", 111111, 23, "Perfect image");
        System.out.println("expectedData = " + expectedData);

        //send the url and get the response
        Response response  = given(spec).contentType(ContentType.JSON).put("{first}/{second}");
        response.prettyPrint();


        //Do assertion

        DummyRestApiResponsePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), DummyRestApiResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getProfile_image(), actualData.getData());
        assertEquals(expectedData.getEmployee_salary(), actualData.getData().getEmployee_salary());
        assertEquals(expectedData.getEmployee_name(), actualData.getData().getEmployee_name());
        assertEquals(expectedData.getEmployee_age(), actualData.getData().getEmployee_age());






    }


}
