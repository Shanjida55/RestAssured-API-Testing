package tests.BookingCreation;

import org.testng.annotations.Test;
import testdata.BookingData;
import testdata.BookingDates;
import tests.BaseTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Keep_Firstname_blank extends BaseTest
{
    public int bookingId;

    BookingData bookingData = new BookingData(" ", "Labonno ",
            10, true, new BookingDates("2024-02-11",
            "2024-02-20"), "Steak");

    @Test(priority = 4)
    public void CreateBooking_Firstname_Blank() {
        this.bookingId = given().spec(requestSpec())
                .body(this.bookingData)
                .when()
                .post("/booking")
                .then()
                .spec(responseSpec())
                .and()
                .assertThat()
                .body("bookingid", is(notNullValue()))
                .body("firstname",is(nullValue()))
                .extract()
                .path("bookingid");
    }

}







