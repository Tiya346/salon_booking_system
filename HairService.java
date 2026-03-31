// HairService extends Service and also implements Bookable
// This is inheritance - HairService gets everything Service has
public class HairService extends Service implements Bookable {

    // Extra fields specific to hair services
    private String hairLength;   // short, medium, or long
    private boolean includesWash;
    private int durationMinutes;
    private boolean isBooked;

    // Constructor
    public HairService(String serviceName, double basePrice, String staffName,
                       String hairLength, boolean includesWash, int durationMinutes) {
        // Call the parent class constructor first
        super(serviceName, basePrice, staffName);
        this.hairLength = hairLength;
        this.includesWash = includesWash;
        this.durationMinutes = durationMinutes;
        this.isBooked = false;
    }

    // Override calculatePrice from Service - this is polymorphism
    // Hair price changes based on length and whether wash is included
    @Override
    public double calculatePrice() {
        double totalPrice = getBasePrice();

        // Add extra cost based on hair length
        if (hairLength.equalsIgnoreCase("medium")) {
            totalPrice = totalPrice + 10.0;
        } else if (hairLength.equalsIgnoreCase("long")) {
            totalPrice = totalPrice + 20.0;
        }

        // Add wash cost if included
        if (includesWash) {
            totalPrice = totalPrice + 8.0;
        }

        return totalPrice;
    }

    // Override getServiceDetails from Service
    @Override
    public String getServiceDetails() {
        String washText = includesWash ? "Yes" : "No";
        return "Hair Service - " + getServiceName()
                + " | Length: " + hairLength
                + " | Wash included: " + washText
                + " | Duration: " + durationMinutes + " mins"
                + " | Total Price: $" + calculatePrice();
    }

    // Implement Bookable interface methods
    @Override
    public void confirmBooking() {
        isBooked = true;
        System.out.println("Hair service '" + getServiceName() + "' has been confirmed.");
    }

    @Override
    public void cancelBooking() {
        isBooked = false;
        System.out.println("Hair service '" + getServiceName() + "' has been cancelled.");
    }

    @Override
    public int getDurationMinutes() {
        return durationMinutes;
    }

    // Getters for hair-specific fields
    public String getHairLength() {
        return hairLength;
    }

    public boolean isIncludesWash() {
        return includesWash;
    }

    public boolean isBooked() {
        return isBooked;
    }
}
