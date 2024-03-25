package tests;

import org.testng.annotations.Test;
import testdata.AuthData;
import testdata.BookingData;
import testdata.BookingDates;
import tests.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class ID_TOKEN extends BaseTest {
    public int bookingId;
    public String token;
    // Manual data input
    BookingData bookingData = new BookingData("Shanjida", "Labonno",
            1200, true, new BookingDates("2024-02-11",
            "2024-02-20"), "Steak");
    AuthData authData = new AuthData("admin", "password123");


    @Test(priority = 1)
    public void CreateBooking() {
        this.bookingId = given().spec(requestSpec())
                .body(this.bookingData)
                .when()
                .post("/booking")
                .then()
                .extract()
                .path("bookingid");
    }
    @Test(priority = 2)
    public void TokenGeneration() {
        // Using manual authData instead of TestDataBuilder.getAuthData()
        this.token = given().spec(requestSpec())
                .body(this.authData)
                .when()
                .post("/auth")
                .then()
                .assertThat()
                .body("token", is(notNullValue()))
                .extract().path("token");
    }
}
