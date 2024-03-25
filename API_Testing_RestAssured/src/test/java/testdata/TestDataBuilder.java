package testdata;

public class TestDataBuilder {

    public static BookingData getBookingData(String firstName, String lastName, int price, boolean depositPaid, BookingDates bookingDates, String meal) {
        return new BookingData(firstName, lastName, price, depositPaid, bookingDates, meal);
    }

    public static AuthData getAuthData(String username, String password) {
        return new AuthData(username, password);
    }

    public static PartialUpdateBookingData getPartialUpdateBookingData(int price, String fruit) {
        return new PartialUpdateBookingData(price, fruit);
    }
}
