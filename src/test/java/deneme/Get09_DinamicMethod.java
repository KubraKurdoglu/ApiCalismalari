package deneme;

import base_urls.HerOkuAppBaseUrl;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.Map;

public class Get09_DinamicMethod extends HerOkuAppBaseUrl {

    @Test
    public void test01(){

        //set the expected data

        spec.pathParams("pp1", "booking", "pp2", 288);

        //set the expected data

        HerOkuAppTestData obj = new HerOkuAppTestData();

        Map<String, String> bookingdatesMap =obj.bookingdatesMapMethod("2018-01-01", "2019-01-01");

       Map<String, Object> expectedData = obj.expectedDataMapMethod("John", "Smith", 111, true, bookingdatesMap, "Breakfeast");

        System.out.println("expectedData = " + expectedData);
    }
}
