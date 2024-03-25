package tests.BookingCreation;

import org.testng.annotations.Test;
import testdata.AuthData;
import testdata.BookingData;
import testdata.BookingDates;
import tests.BaseTest;
import tests.ID_TOKEN;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class Successful_BookingCreation_usingValidData extends BaseTest
{
        // Manual data input
        public int bookingId;

        // Manual data input
        BookingData bookingData = new BookingData("Shanjida", "Labonno ",
                1200, true, new BookingDates("2024-02-11",
                "2024-02-20"), "Steak");

        @Test(priority = 3)
        public void Successful_BookingCreation() {
        this.bookingId = given().spec(requestSpec())
                .body(this.bookingData)
                .when()
                .post("/booking")
                .then()
                .spec(responseSpec())
                .and()
                .assertThat()
                .body("bookingid", is(notNullValue()))
                .body("booking.firstname", equalTo(this.bookingData.firstname()))
                .body("booking.bookingdates.checkin", equalTo(this.bookingData.bookingdates().checkin()))
                .extract()
                .path("bookingid");
    }




}
