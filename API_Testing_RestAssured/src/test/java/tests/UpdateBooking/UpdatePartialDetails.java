package tests.UpdateBooking;

import org.testng.annotations.Test;
import testdata.PartialUpdateBookingData;
import tests.ID_TOKEN;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdatePartialDetails extends ID_TOKEN {


    @Test(priority =10)
    public void testUpdatePartialBooking() {
        // Manual data input for updating the partial booking
        PartialUpdateBookingData partialUpdateData = new PartialUpdateBookingData(2500, "Apple");

        given().spec(requestSpec())
                .header("Cookie", "token=" + this.token)
                .body(partialUpdateData)
                .when()
                .patch("/booking/" + this.bookingId)
                .then()
                .log().all()
                .spec(responseSpec())
                .body("additionalneeds", equalTo(partialUpdateData.additionalneeds()));
    }
}
