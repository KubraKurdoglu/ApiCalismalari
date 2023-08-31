package deneme;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12 extends GoRestBaseUrl {

     /*
    Given
        https://gorest.co.in/public/v1/users/2587
    When
        User send GET Request to the URL
    Then
        Status Code should be 200
    And
        Response body should be like
            {
                "meta": null,
                "data": {
                    "id": 2587,
                    "name": "Ganapati Prajapat",
                    "email": "prajapat_ganapati@okeefe.org",
                    "gender": "female",
                    "status": "active"
                }
            }
*/

    @Test//(L_JUnittten import ediyoruz)
    public void get12() {
        //Set the url
        spec.pathParams("first", "users", "second", 4890249);

        //set the expected data
        GoRestDataPojo goRestDataPojo =  new GoRestDataPojo("Anasuya Johar","anasuya_johar@barton.test",
                "male", "active");
        GoRestPojo expectedData =  new GoRestPojo(null, goRestDataPojo);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the rsponse

        Response response = given(spec).get("{first}/{second}");//spec==> ile tekrarli ogeleri aliriz
        response.prettyPrint();

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

    @Test
    public void test02(){

        //set the url
        spec.pathParams("first", "users", "second", 2587);

        //set the expected data

        new GoRestDataPojo("Ganapati Prajapat", "prajapat_ganapati@okeefe.org", "female", "active");



    }
}
