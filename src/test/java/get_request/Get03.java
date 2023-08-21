package get_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get03 {


    //4 adimi UNUTMA SIRASIYLA HEPSINI YAPMALISIN, HENUZ 3. ADIMI GOSTERMEDI
    //     i)Set the url --> endpoint'i kur
    //          ii) Set the expected data --> beklenen veriyi kur
    //          iii) Send the request and get the response --> request'i gönder ve response'ı al
    //          iv) Do assertion --> Doğrulama yap
      /*
      Given
          https://jsonplaceholder.typicode.com/todos/23
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
And
    Response format should be "application/json"
And
    "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
And
    "completed" is false
And
    "userId" is 2
   */

    @Test
    public void get03(){

        // i)Set the url
        String url  = "https://jsonplaceholder.typicode.com/todos/23";

        //ii) Set the expected data
        //daha sonra yapacagiz


        // iii) Send the request and get the response
        Response response = given().get(url);
        response.prettyPrint();


        //iv) Do assertion --> Doğrulama yap
        //yukarda soruda bize "body" sorgulmasi yap diyor, o nedenle "body" kullandik
        //equalTo()==>bunu CoreMatchers'dan import ettik

        response.then()//==> then kullanmak bundan sonra assertion kullanacagim demek
                .statusCode(200).contentType("application/json").
                body("userId", equalTo(2)).//hard assertion
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed", equalTo(false));


        //2.YOL
        response.then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("userId", equalTo(2),//soft assertion
                        "title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed", equalTo(false));


        //yukarda "soft assertion" yapti. Body methodu icerinde yapti bu assertion u.
        //2. YOLU kullanarak coklu assertion da herhangi bir dogrulama kaldiginda onu gorebiliyoruz.
        //yukarda da bu sekilde oldu

        //Tek body() methodu içinde çoklu assertion yaparak "soft assertion" yapabiliriz. Tüm fail durumları hakkında bilgi alabiliriz.
        //Çoklu body() methodları içinde tek assertion yaparak "hard assertion" yaparız. İlk fail durumunda çalışma durur ve sonraki assetionlar hakkında bilgi alamayız.

    }

}
