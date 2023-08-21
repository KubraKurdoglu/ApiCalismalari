package get_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get02 {

            /*
   Given
       https://restful-booker.herokuapp.com/booking/0
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 404
   And
       Status Line should be "HTTP/1.1 404 Not Found"
   And
       Response body contains "Not Found"
   And
       Response body does not contain "TechProEd"
   And
       Server is "Cowboy"
*/

    @Test
    public void get02(){
        //i)Set the url
        String url = "https://restful-booker.herokuapp.com/booking/0";


        //ii) Set the expected data kur
        //bunu daha sonra yapacagiz

        //iii) Send the request and get the response
        Response response = given().get(url);
        response.prettyPrint();
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //yukarda bunu calistirinca hata aldim, bazi arkadaslar "<argLine>-Duser.language=en</argLine>" bunu
        //pom.xml de properties kisminin icindeki maven kisminin altin ayapistirin dedi, oyle yaptim duzeldi



        //iv) Do assertion
        response.then().
                statusCode(404).//==> burda biz 404 bekliyoruz.
                statusLine("HTTP/1.1 404 Not Found");//Status Line should be "HTTP/1.1 404 Not Found"


        // Response body contains "Not Found"
        System.out.println("-->" + response.asString());
        assertTrue(response.asString().contains("Not Found"));

        //Response body does not contain "TechProEd"
        assertFalse(response.asString().contains("TechProEd"));

        //Server is "Cowboy"

        //System.out.println(response.header("Server"));//==> bu bize kovboy donecek, ama bunu kullanma

        String server = response.header("Server");
        assertEquals("Cowboy", server );
    }
}
