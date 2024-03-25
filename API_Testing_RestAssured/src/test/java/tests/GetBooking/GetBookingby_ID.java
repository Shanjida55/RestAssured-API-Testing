package tests.GetBooking;


import org.testng.annotations.Test;
import tests.ID_TOKEN;
import static io.restassured.RestAssured.given;


public class GetBookingby_ID extends ID_TOKEN {

   @Test(priority = 8)
        public void GetBookingDetails() {
            given().spec(requestSpec())
                    .when()
                    .get("/booking/" + this.bookingId)
                    .then()
                    .spec(responseSpec());

       System.out.println(bookingId);


   }
        }









