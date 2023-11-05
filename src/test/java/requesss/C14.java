package requesss;

public class C14 {
     /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "application/json; charset=utf-8"
        And
            Status Line should be HTTP/1.1 200 OK
     */


    @Test
    public void odev01(){

        // i)Set the url
        spec.pathParams("first", "users", "second", 3);


        //ii) Set the expected data

        // iii) Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //iv) Do assertion --> Doğrulama yap
        response.then().statusCode(200).contentType("application/json; charset=utf-8").statusLine("HTTP/1.1 200 OK");

    }
}
