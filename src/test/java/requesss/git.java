package requesss;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class git extends JsonPlaceHolderBaseUrl {

    @Test
    public void test01(){

        //set the url
        spec.pathParams("first", "tools");


        //set the expected data

        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //send the request and the response

        //set the expected data
        GoRestDataPojo goRestDataPojo =  new GoRestDataPojo("Ganapati Prajapat","prajapat_ganapati@okeefe.org",
                "female", "active");
        GoRestPojo expectedData =  new GoRestPojo(null, goRestDataPojo);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the rsponse

        //Do assertion
        GoRestPojo actualData = response.as(GoRestPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getMeta(), actualData.getMeta());
        assertEquals(goRestDataPojo.getName(), actualData.getData().getName());
        assertEquals(goRestDataPojo.getEmail(), actualData.getData().getEmail());
        assertEquals(goRestDataPojo.getGender(), actualData.getData().getGender());
        assertEquals(goRestDataPojo.getStatus(), actualData.getData().getStatus());


        //assertEquals(expectedData.getData().getName(), actualData.getData().getName());
        //expectedData.getData()==> bunun yerine, yani bu kadar uzatmak yerine, olusturulan pojo class adini direk
        //yazabilirsin

        //bir de burda "setter" lari kullanmadik, ama data degistirilmesi gereken yerde kullanilabilir


    }
}
