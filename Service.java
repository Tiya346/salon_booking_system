// Abstract base class for all salon services
// Uses abstraction - you cannot create a Service object directly
public abstract class Service {

    // Private fields - encapsulation, no outside class can touch these directly
    private String serviceName;
    private double basePrice;
    private String staffName;

    // Constructor to set up a service
    public Service(String serviceName, double basePrice, String staffName) {
        this.serviceName = serviceName;
        this.basePrice = basePrice;
        this.staffName = staffName;
    }

    // Abstract method - every subclass MUST override this
    // This is where polymorphism happens
    public abstract double calculatePrice();

    // Abstract method - subclasses describe the service in their own way
    public abstract String getServiceDetails();

    // Getters so other classes can read the private fields
    public String getServiceName() {
        return serviceName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getStaffName() {
        return staffName;
    }

    // Setters in case we need to update the fields later
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    // A basic display method all services share
    public void displayInfo() {
        System.out.println("Service  : " + serviceName);
        System.out.println("Staff    : " + staffName);
        System.out.println("Price    : $" + calculatePrice());
    }
}
