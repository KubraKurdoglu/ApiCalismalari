package get_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {

    //META DATA==> DATA HAKKINDAKI DATA, YANI HEADER DAKI DATA

      /*
Given
    https://restful-booker.herokuapp.com/booking/55
When
    User sends a GET Request to the url
Then
    HTTP Status Code should be 200
And
    Content Type should be "application/json"
And
    Status Line should be "HTTP/1.1 200 OK"
*/

    //test methodlari 1:public , 2: void, 3: adi olmali, 4: parametresiz olmalidir
    @Test
    public void test01(){

        //i)Set the url --> endpoint'i kur

        String url = "https://restful-booker.herokuapp.com/booking/55";

        // ii) Set the expected data --> beklenen veriyi kur(bu adimi post
        // ve put gibi data gonderilecek methodlarda kullanacagiz

        // iii) Send the request and get the response --> request'i gönder ve response'ı al
        //response ile yapilan her islem given().get(url);==> bununla da yapilir, mama daha makulu
        //koyteynira koymaktir
        Response response = given().get(url);
        response.prettyPrint();


        // iv) Do assertion --> Doğrulama yap
        response.then().
                statusCode(200).//HTTP Status Code should be 200
                contentType("application/json").//Content Type should be "application/json"
                statusLine("HTTP/1.1 200 OK");//Status Line should be "HTTP/1.1 200 OK"


        //==> bu method ile kolayca validation yapti
        //beklenen degeri icine yazdi. 200 bekliyorsun ve 200 gelince dogruluyor.


        //yukardaki gibi bitisik de yazabilirsin yada ayri ayri da calisir, ama bitisik daha iyi
        //response.then().contentType("application/json");


    }
}
