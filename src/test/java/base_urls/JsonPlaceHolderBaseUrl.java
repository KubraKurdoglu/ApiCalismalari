package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {



    protected RequestSpecification spec ;

    @Before//her test methodu oncesi calisir
    public void setUp(){
        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri("https://jsonplaceholder.typicode.com/").setAccept(ContentType.JSON).build();
        //Content type yukarda set yapti, veriyi alacak tarafin icerigi gorebilmesi icin yapti bunu

    }
}
