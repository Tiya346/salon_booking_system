// Main class - this is where the program starts running
// It creates some services and appointments to show everything working together
public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the Java Salon Booking System");
        System.out.println("========================================");
        System.out.println();

        // Create a BookingManager to handle all appointments
        BookingManager manager = new BookingManager();

        // --- Create some Hair Services ---

        // Basic short haircut, no wash
        HairService haircut1 = new HairService(
                "Classic Haircut",   // service name
                30.0,                // base price
                "Sarah",             // staff name
                "short",             // hair length
                false,               // no wash
                30                   // 30 minutes
        );

        // Long hair blowout with wash
        HairService haircut2 = new HairService(
                "Blowout and Style",
                40.0,
                "Mike",
                "long",
                true,
                60
        );

        // --- Create some Skin Services ---

        // Basic facial for normal skin, standard products
        SkinService facial1 = new SkinService(
                "Basic Facial",      // service name
                50.0,                // base price
                "Lisa",              // staff name
                "normal",            // skin type
                false,               // standard products
                45                   // 45 minutes
        );

        // Deep treatment for sensitive skin with premium products
        SkinService facial2 = new SkinService(
                "Deep Hydration Treatment",
                70.0,
                "Lisa",
                "sensitive",
                true,
                90
        );

        System.out.println("--- Service Details ---");
        System.out.println(haircut1.getServiceDetails());
        System.out.println(haircut2.getServiceDetails());
        System.out.println(facial1.getServiceDetails());
        System.out.println(facial2.getServiceDetails());
        System.out.println();

        // --- Demonstrate Polymorphism ---
        // We store different service types in a Service array
        // When calculatePrice is called, Java knows which version to run
        System.out.println("--- Polymorphism Demo (calculatePrice on each service) ---");
        Service[] allServices = { haircut1, haircut2, facial1, facial2 };
        for (int i = 0; i < allServices.length; i++) {
            System.out.println(allServices[i].getServiceName()
                    + " costs: $" + allServices[i].calculatePrice());
        }
        System.out.println();

        // --- Book some Appointments ---
        System.out.println("--- Booking Appointments ---");

        Appointment appt1 = manager.addAppointment(
                "Alice Brown",
                "555-1001",
                "2025-08-15",
                "10:00 AM",
                haircut1
        );

        Appointment appt2 = manager.addAppointment(
                "Bob Smith",
                "555-1002",
                "2025-08-15",
                "11:00 AM",
                facial1
        );

        Appointment appt3 = manager.addAppointment(
                "Carol White",
                "555-1003",
                "2025-08-16",
                "02:00 PM",
                haircut2
        );

        Appointment appt4 = manager.addAppointment(
                "Dan Green",
                "555-1004",
                "2025-08-16",
                "03:30 PM",
                facial2
        );

        System.out.println();

        // --- Show all appointments ---
        manager.showAllAppointments();

        // --- Cancel one appointment ---
        System.out.println("--- Cancelling Appointment APT002 ---");
        manager.cancelAppointment("APT002");
        System.out.println();

        // --- Show only confirmed ones ---
        manager.showConfirmedAppointments();

        // --- Print total revenue ---
        System.out.println();
        System.out.println("Total confirmed revenue: $" + manager.getTotalRevenue());
        System.out.println("Total appointments on record: " + manager.getTotalAppointmentCount());
        System.out.println();
        System.out.println("Program finished.");
    }
}
