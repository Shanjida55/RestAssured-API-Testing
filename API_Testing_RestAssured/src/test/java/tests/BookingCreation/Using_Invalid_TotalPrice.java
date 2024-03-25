package tests.BookingCreation;

import org.testng.annotations.Test;
import testdata.BookingData;
import testdata.BookingDates;
import tests.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Using_Invalid_TotalPrice extends BaseTest
{
    public int bookingId;

    BookingData bookingData = new BookingData("labonno", "Islam",
            -100, false, new BookingDates("2024-02-15",
            "2024-02-20"), "Steak");

    @Test(priority = 5)
    public void Input_Negative_TotalPrice() {
        this.bookingId = given().spec(requestSpec())
                .body(this.bookingData)
                .when()
                .post("/booking")
                .then()
                .spec(responseSpec())
                .and()
                .assertThat()
                .body("bookingid", is(notNullValue()))
                .body("totalprice", is(nullValue()))
                .extract()
                .path("bookingid");
    }


}
