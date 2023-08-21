package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class ReqresBaseUrl {

    protected RequestSpecification spec;

    @Before//her test methodu oncesi calisir
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("https://reqres.in/api/").setContentType(ContentType.JSON).setAccept(ContentType.JSON).build();


    }
}
