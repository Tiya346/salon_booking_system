// Appointment holds all the info about one booking
// Plain class with encapsulated fields
public class Appointment {

    // Private fields - encapsulation
    private String appointmentId;
    private String customerName;
    private String customerPhone;
    private String appointmentDate;   // simple string like "2025-08-15"
    private String appointmentTime;   // simple string like "10:30 AM"
    private Service service;          // the service booked (HairService or SkinService)
    private String status;            // "Pending", "Confirmed", "Cancelled"

    // Constructor
    public Appointment(String appointmentId, String customerName, String customerPhone,
                       String appointmentDate, String appointmentTime, Service service) {
        this.appointmentId = appointmentId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.service = service;
        this.status = "Pending";   // every appointment starts as Pending
    }

    // Print a summary of this appointment
    public void printAppointmentSummary() {
        System.out.println("------------------------------------");
        System.out.println("Appointment ID : " + appointmentId);
        System.out.println("Customer       : " + customerName);
        System.out.println("Phone          : " + customerPhone);
        System.out.println("Date           : " + appointmentDate);
        System.out.println("Time           : " + appointmentTime);
        System.out.println("Status         : " + status);
        System.out.println("Service Info   : " + service.getServiceDetails());
        System.out.println("------------------------------------");
    }

    // Getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public Service getService() {
        return service;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setStatus(String status) {
        this.status = status;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
