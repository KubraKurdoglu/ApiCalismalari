package get_request;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {


    /*
1) Postman manuel test için kullanılır
2) Otomasyon için Rest-Assured library kullanıyoruz
3) Otomasyonu yazabilmek için şu adımların izlenmesi gerekir:
    a) Gereksinimleri anlama
    b) Test case yazma:
        -Test yazmak için Gherkin Language kullanılır
        x) Given: Ön koşullar --> Url, Body ...
        y) When: Yapılacak işlemler --> Get, Put, Post ... requests...
        z) Then: Dönütler, çıktılar --> Assertion, close...
        t) And: Art arda yapılan aynı çoklu işlmeleri bağlamak için kullanılır
    c) Otomasyon kodlarını yazma:
          i)Set the url --> endpoint'i kur
          ii) Set the expected data --> beklenen veriyi kur
          iii) Send the request and get the response --> request'i gönder ve response'ı al
          iv) Do assertion --> Doğrulama yap

 */
    public static void main(String[] args) {

        //Get request nasil yapilir?
        String url = "https://petstore.swagger.io/v2/pet/16161616";
        Response response = given().get(url);//importa dikkat==>"import static io.restassured.RestAssured.given;"
        //response bir interface, given bize onu donuyor
        response.prettyPrint();//prettyPrint()==> methodu ile responsu(data'nin kendisi) konsola yazdirdik

        //Status code nasill yazdirilir:

        System.out.println("Status code: "+ response.statusCode());

        //Content Type nasil yazdirilir?
        System.out.println("contentType: " + response.contentType());//icerdigi yazi tipini dondurecek, yani http mi
        // json mu, bunu veriyor


        //Status Line nasil yazdirilir:
        System.out.println("statusLine:" + response.statusLine());//==> statu kodunu verecek==>200,300, 400 vs.


        //Header nasil yazdirilir(Hedars dersek tamamini verir):==>her ne istiyorsak bize onun degerini verecek
        System.out.println(response.header("Date"));//==> Date'in degerini verecek
        System.out.println(response.header("Connection"));
        System.out.println(response.header("Server"));
        System.out.println(response.header("Transfer-Encoding"));


        //Headers nasil yazdirilir: ==> buna herhangi bir sey atamaya gerek yok, kendi degerini veriyor
        System.out.println("------------------HEADERS-------------");
        System.out.println(response.headers());

        //TIME nasil yazdirilir
        System.out.println("Time: "+response.time());









    }
}
