package tests.DeleteBooking;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Check_Successfull_Deletion extends DeleteBookingDetails {

    @Test(priority = 12)
    public void testDeletedBooking() {
        given().spec(requestSpec())
                .when()
                .get("/booking/" + this.bookingId)
                .then()
                .statusCode(404);
    }


}
