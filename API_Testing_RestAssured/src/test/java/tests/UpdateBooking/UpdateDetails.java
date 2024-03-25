package tests.UpdateBooking;

import org.testng.annotations.Test;
import testdata.BookingData;
import testdata.BookingDates;
import testdata.PartialUpdateBookingData;
import tests.ID_TOKEN;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateDetails extends ID_TOKEN {

    @Test(priority =9)
    public void testUpdateBooking() {
        // Manual data input for updating the booking
        BookingData updateBooking = new BookingData("Ontor", "Vaia", 1500, true, new BookingDates("2024-03-01", "2024-03-10"), "Chicken");

        given().spec(requestSpec())
                .header("Cookie", "token=" + this.token)
                .body(updateBooking)
                .when()
                .put("/booking/" + this.bookingId)
                .then()
                .log().all()
                .spec(responseSpec());
    }
}
