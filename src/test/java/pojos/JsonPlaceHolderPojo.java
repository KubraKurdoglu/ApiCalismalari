package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)//bunu taninmayan datayi ignore etmek icin kullandik
//yani biz response aldigimiz zaman bize ek olarak "id" geliyor ama biz o id'yi assertion yapamiyoruz
//boyle olu,ca o gelen "id" yi ignore ederek, cunku bilinmyene data o, bu hatadan korunmus oluyoruz
public class JsonPlaceHolderPojo {

    //1.private variable olustur
    //2. /2: Parametreli ve parametresiz constructor'lar oluşturunuz(bos icin "none select" secti)
    //3. public getter setter yapti
    //4. tostring yapti, yapmak zorunda degildik
    //pojo bir class'in ornegi imis
    //İnterwiewde bu soruyu sorabilirler: Serialization ve De-Serialization işlemlerini nasıl yaparsın

    private Integer userId;
    private String title;
    private Boolean completed;



    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
