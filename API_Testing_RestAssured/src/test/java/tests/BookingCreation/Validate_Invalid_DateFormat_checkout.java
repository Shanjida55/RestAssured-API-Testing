package tests.BookingCreation;

import org.testng.annotations.Test;
import testdata.BookingData;
import testdata.BookingDates;
import tests.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Validate_Invalid_DateFormat_checkout extends BaseTest {

    public int bookingId;

    BookingData bookingData = new BookingData("Ontor", "Vaia",
            1689, true, new BookingDates("2024-02-20",
            "03-12-03"), "Steak");

    @Test(priority = 7)
    public void Using_Invalid_Checkout_Date() {
        this.bookingId = given().spec(requestSpec())
                .body(this.bookingData)
                .when()
                .post("/booking")
                .then()
                .spec(responseSpec())
                .and()
                .assertThat()
                .body("bookingid", is(notNullValue()))
                .body("booking.bookingdates.checkout", is(notNullValue()))
                .extract()
                .path("bookingid");
    }

}
