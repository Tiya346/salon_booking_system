import java.util.ArrayList;

// BookingManager keeps track of all appointments in the salon
// It can add, cancel, and show appointments
public class BookingManager {

    // Private list of all appointments - encapsulation
    private ArrayList<Appointment> appointmentList;
    private int nextIdNumber;   // used to make unique IDs like APT001, APT002

    // Constructor
    public BookingManager() {
        appointmentList = new ArrayList<Appointment>();
        nextIdNumber = 1;
    }

    // Make a new appointment and add it to the list
    public Appointment addAppointment(String customerName, String customerPhone,
                                      String date, String time, Service service) {

        // Build a simple ID like APT001
        String newId = "APT" + String.format("%03d", nextIdNumber);
        nextIdNumber++;

        // Create the appointment object
        Appointment newAppointment = new Appointment(newId, customerName, customerPhone,
                date, time, service);

        // Try to confirm the booking through the Bookable interface
        // We check if the service implements Bookable before calling confirmBooking
        if (service instanceof Bookable) {
            Bookable bookableService = (Bookable) service;
            bookableService.confirmBooking();
        }

        // Update appointment status to Confirmed
        newAppointment.setStatus("Confirmed");

        // Add to our list
        appointmentList.add(newAppointment);

        System.out.println("Appointment " + newId + " added for " + customerName + ".");
        return newAppointment;
    }

    // Cancel an appointment by its ID
    public void cancelAppointment(String appointmentId) {
        boolean found = false;

        for (int i = 0; i < appointmentList.size(); i++) {
            Appointment current = appointmentList.get(i);

            if (current.getAppointmentId().equals(appointmentId)) {
                // Cancel through Bookable interface if possible
                if (current.getService() instanceof Bookable) {
                    Bookable bookableService = (Bookable) current.getService();
                    bookableService.cancelBooking();
                }
                current.setStatus("Cancelled");
                found = true;
                System.out.println("Appointment " + appointmentId + " has been cancelled.");
                break;
            }
        }

        if (!found) {
            System.out.println("No appointment found with ID: " + appointmentId);
        }
    }

    // Show all appointments in the list
    public void showAllAppointments() {
        if (appointmentList.size() == 0) {
            System.out.println("No appointments on record.");
            return;
        }

        System.out.println("===== All Appointments =====");
        for (int i = 0; i < appointmentList.size(); i++) {
            appointmentList.get(i).printAppointmentSummary();
        }
    }

    // Show only confirmed appointments
    public void showConfirmedAppointments() {
        System.out.println("===== Confirmed Appointments =====");
        boolean anyFound = false;

        for (int i = 0; i < appointmentList.size(); i++) {
            Appointment current = appointmentList.get(i);
            if (current.getStatus().equals("Confirmed")) {
                current.printAppointmentSummary();
                anyFound = true;
            }
        }

        if (!anyFound) {
            System.out.println("No confirmed appointments found.");
        }
    }

    // Get total revenue from all confirmed appointments
    public double getTotalRevenue() {
        double total = 0.0;

        for (int i = 0; i < appointmentList.size(); i++) {
            Appointment current = appointmentList.get(i);
            if (current.getStatus().equals("Confirmed")) {
                // calculatePrice is polymorphic - calls the right version automatically
                total = total + current.getService().calculatePrice();
            }
        }

        return total;
    }

    // Get how many appointments are in the list
    public int getTotalAppointmentCount() {
        return appointmentList.size();
    }
}
