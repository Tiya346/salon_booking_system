// Interface that any bookable service must follow
public interface Bookable {

    // Every bookable service must be able to confirm a booking
    void confirmBooking();

    // Every bookable service must be able to cancel a booking
    void cancelBooking();

    // Every bookable service must return how long it takes in minutes
    int getDurationMinutes();
}
