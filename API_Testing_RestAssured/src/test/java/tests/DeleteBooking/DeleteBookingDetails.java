package tests.DeleteBooking;

import org.testng.annotations.Test;
import tests.ID_TOKEN;

import static io.restassured.RestAssured.given;

public class DeleteBookingDetails extends ID_TOKEN {


    @Test(priority = 11)
    public void DeleteBooking() {
        given().spec(requestSpec())
                .header("Cookie", "token=" + this.token).log().all()
                .when()
                .delete("/booking/" + this.bookingId)
                .then()
                .statusCode(201);
    }

}

