package get_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

public class Get04 extends JsonPlaceHolderBaseUrl {
    /*
   Given
       https://jsonplaceholder.typicode.com/todos
   When
  I send a GET request to the Url
And
    Accept type is "application/json"
Then
    HTTP Status Code should be 200
And
    Response format should be "application/json"
And
    There should be 200 todos => toplam 200 todos olması gerekir
And
    "quis eius est sint explicabo" should be one of the todos title => todos başlıklarından en az birinin "quis eius est sint explicabo" olması gerekir
And
    2, 7, and 9 should be among the userIds => userId değerleri arasında 2, 7 ve 9 bulunmalıdır
*/

    @Test
    public void get04(){
        //1.set the url
        //String Url = "https://jsonplaceholder.typicode.com/todos"==> tavisiye edilmeyen yontem
        spec.pathParam("first", "todos");//tekbir deger konulacagi icin "param" oldu; cogul hali==>params
        //spec==> tekararli islemleri iceren  RequestSpecification objesi


        //2.set the expected data


        //3.Send the request and the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //4.Do assertion
        response.then().
                statusCode(200).// HTTP Status Code should be 200
                contentType(ContentType.JSON)//Response format should be "application/json"
                .body("", hasSize(200)).
                body("title", hasItem("qis eius est sint explicabo")).
                body("userId", hasItems(2,7,9));//There should be 200 todos








        //yukarda "id" leri list olarak bize dondurdu, istesek icicne "title", "completed" de yazabilirdik
        //o zaman onlari dondurecekti.
        //Path icine(yani su an 'id' yazdigimiz yer) bir sey yazmasak tum bilgileri (id, title, completed vs. dondurecek)
        //response==> bir list ldugu icin, icine hibbir sey koymasak da tum verileri bize dondurecektir

        //**************************
        // hasSize() methodu eleman sayısını assert eder
        // hasItem() methodu contains() gibi tek bir objenin içerilip içrilmediğini assert eder.
        // hasItems() methodu containsAll() gibi çoklu objelerin içerilip içrilmediğini assert eder.


    }
}
