package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingResponsePojo {

    /*
     "bookingid": 16,
      "booking" :{
     */

    //bu iki deger icin bu pojoyu olusturduk, ama bookingid ye gerek yok, cunku onu ignore etmistik
    //booking ==> ignore edilirse, icindeki degerleri null dondurur, o nedenle onun icin pojo gerekli tum adimlari yapmaliyiz


    private BookingPojo booking;

    public BookingResponsePojo() {
    }

    public BookingResponsePojo(BookingPojo booking) {
        this.booking = booking;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingResponsePojo{" +
                "booking=" + booking +
                '}';
    }
}

