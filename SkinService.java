// SkinService extends Service and also implements Bookable
// Another subclass that inherits from Service - inheritance again
public class SkinService extends Service implements Bookable {

    // Fields specific to skin services
    private String skinType;        // normal, oily, dry, sensitive
    private boolean isPremiumProduct;
    private int durationMinutes;
    private boolean isBooked;

    // Constructor
    public SkinService(String serviceName, double basePrice, String staffName,
                       String skinType, boolean isPremiumProduct, int durationMinutes) {
        // Call parent constructor
        super(serviceName, basePrice, staffName);
        this.skinType = skinType;
        this.isPremiumProduct = isPremiumProduct;
        this.durationMinutes = durationMinutes;
        this.isBooked = false;
    }

    // Override calculatePrice from Service - polymorphism
    // Skin service price changes based on skin type and product quality
    @Override
    public double calculatePrice() {
        double totalPrice = getBasePrice();

        // Sensitive skin needs special treatment, costs more
        if (skinType.equalsIgnoreCase("sensitive")) {
            totalPrice = totalPrice + 15.0;
        } else if (skinType.equalsIgnoreCase("dry")) {
            totalPrice = totalPrice + 10.0;
        }

        // Premium products cost extra
        if (isPremiumProduct) {
            totalPrice = totalPrice + 25.0;
        }

        return totalPrice;
    }

    // Override getServiceDetails from Service
    @Override
    public String getServiceDetails() {
        String productText = isPremiumProduct ? "Premium" : "Standard";
        return "Skin Service - " + getServiceName()
                + " | Skin type: " + skinType
                + " | Products: " + productText
                + " | Duration: " + durationMinutes + " mins"
                + " | Total Price: $" + calculatePrice();
    }

    // Implement Bookable interface methods
    @Override
    public void confirmBooking() {
        isBooked = true;
        System.out.println("Skin service '" + getServiceName() + "' has been confirmed.");
    }

    @Override
    public void cancelBooking() {
        isBooked = false;
        System.out.println("Skin service '" + getServiceName() + "' has been cancelled.");
    }

    @Override
    public int getDurationMinutes() {
        return durationMinutes;
    }

    // Getters for skin-specific fields
    public String getSkinType() {
        return skinType;
    }

    public boolean isPremiumProduct() {
        return isPremiumProduct;
    }

    public boolean isBooked() {
        return isBooked;
    }
}
