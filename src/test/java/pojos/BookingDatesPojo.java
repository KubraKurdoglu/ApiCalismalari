package pojos;

public class BookingDatesPojo {

    //1.Private datalari olustur
    private String checkin;
    private String checkout;

    //2.parametreli ve parametresiz constructor


    public BookingDatesPojo() {
    }

    //this su demek, burda iki tane ayni isimde variable oldugu  icin java nin akli karisiyor
    //asagida constrctr icinde girilecek degeri yukardaki checkin icine at demektir bu.


    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;//this => bu class taki degere ata yukarda girilen degeri
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
