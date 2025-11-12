import java.util.Scanner;
import java.util.Random;

class Register {
	// Regular Colors   
    	public static final String BLACK = "\033[0;30m";   // BLACK
    	public static final String red = "\033[0;31m";     // RED
    	public static final String green = "\033[0;32m";   // GREEN
    	public static final String yellow = "\033[0;33m";  // YELLOW
    	public static final String blue = "\033[0;34m";    // BLUE
    	public static final String purple = "\033[0;35m";  // PURPLE
    	public static final String cyan = "\033[0;36m";    // CYAN
    	public static final String white  = "\033[0;37m";   // WHITE
        
         //Reset
         public static final String reset = "\033[0m"; 

    static Scanner sc = new Scanner(System.in);
    private String username;
    private long phoneNumber;
    private String addressDetails;
    private String password;

    Register(String username, long phoneNumber, String addressDetails, String password) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.addressDetails = addressDetails;
        this.password = password;
    }

    String getu() {
        return username;
    }

    long getpn() {
        return phoneNumber;
    }

    String getad() {
        return addressDetails;
    }

    String getp() {
        return password;
    }

    void setu(String username) {
        this.username = username;
    }

    void setpn(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    void setad(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    void setp(String password) {
        this.password = password;
    }
}
////
class Dish {
	// Regular Colors   
    	public static final String BLACK = "\033[0;30m";   // BLACK
    	public static final String red = "\033[0;31m";     // RED
    	public static final String green = "\033[0;32m";   // GREEN
    	public static final String yellow = "\033[0;33m";  // YELLOW
    	public static final String blue = "\033[0;34m";    // BLUE
    	public static final String purple = "\033[0;35m";  // PURPLE
    	public static final String cyan = "\033[0;36m";    // CYAN
    	public static final String white  = "\033[0;37m";   // WHITE
        
         //Reset
         public static final String reset = "\033[0m"; 

    private int id;
    private String dishName;
    private String style;
    private int cookingTime;
    private String ingredients;

    Dish(int id, String dishName, String style, int cookingTime, String ingredients) {
        this.id = id;
        this.dishName = dishName;
        this.style = style;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
    }

    int getId() {
        return id;
    }

    String getDN() {
        return dishName;
    }

    String getSt() {
        return style;
    }

    int getcookingTime() {
        return cookingTime;
    }

    String getIngredients() {
        return ingredients;
    }

    void setIndedients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void displayDishInfo() {
        System.out.println("Dish ID      : " + id);
        System.out.println("Dish Name    : " + dishName);
        System.out.println("Style        : " + style);
        System.out.println("Cooking Time : " + cookingTime + " minutes");
        System.out.println("Ingredients  : " + ingredients);
        System.out.println("--------------------------------------------");
    }
}

class NorthIndian extends Dish {
    NorthIndian(int id, String name, String style, int time, String ingredients) {
        super(id, name, style, time, ingredients);
    }
}

class SouthIndian extends Dish {
    SouthIndian(int id, String name, String style, int time, String ingredients) {
        super(id, name, style, time, ingredients);
    }
}

class Chinese extends Dish {
    Chinese(int id, String name, String style, int time, String ingredients) {
        super(id, name, style, time, ingredients);
    }
}

class Booking {
	// Regular Colors   
    	public static final String BLACK = "\033[0;30m";   // BLACK
    	public static final String red = "\033[0;31m";     // RED
    	public static final String green = "\033[0;32m";   // GREEN
    	public static final String yellow = "\033[0;33m";  // YELLOW
    	public static final String blue = "\033[0;34m";    // BLUE
    	public static final String purple = "\033[0;35m";  // PURPLE
    	public static final String cyan = "\033[0;36m";    // CYAN
    	public static final String white  = "\033[0;37m";   // WHITE
        
         //Reset
         public static final String reset = "\033[0m";  

    static Scanner sc = new Scanner(System.in);
    Random ran = new Random();
    String bookingId;
    double price;
    int quantity;
    String tempAddress;
    double actualAmount;
    String status;
    Dish selectedDish;
    Chef selectedChef;

    Booking(String bookingId, Dish selectedDish, Chef selectedChef, String tempAddress, int quantity) {
        this.bookingId = bookingId;
        this.selectedDish = selectedDish;
        this.selectedChef = selectedChef;
        this.tempAddress = tempAddress;
        this.quantity = quantity;
        this.price = 500.0; // Fixed price per order
        this.actualAmount = quantity * price;
        this.status = "Pending";
    }

    void updateAddress() {
        System.out.println("Do you want to change the delivery address?");
        System.out.println("Enter 1 for Yes or 2 for No");
        int n = sc.nextInt();
        sc.nextLine();
        if (n == 1) {
            System.out.print("Enter new delivery address: ");
            this.tempAddress = sc.nextLine();
            System.out.println("Address updated successfully!");
        }
    }

    boolean addFundsToWallet(MainApp mainApp, double requiredAmount) {
        System.out.println("Insufficient wallet balance: " + mainApp.walletBalance);
        System.out.println("Required amount: " + requiredAmount);
        System.out.println("Select Payment Method to Add Funds:");
        System.out.println("1. UPI");
        System.out.println("2. Bank Transfer");
        System.out.print("Enter choice: ");
        int paymentMethod = sc.nextInt();
        if (paymentMethod == 1 || paymentMethod == 2) {
            System.out.print("Enter amount to add: ");
            double amount = sc.nextDouble();
            if (amount <= 0) {
                System.out.println("Invalid amount.");
                return false;
            }
            int otp = 100000 + ran.nextInt(90000); // Generate 6-digit OTP
            System.out.println("OTP sent to your registered phone number: " + otp);
            System.out.print("Enter OTP to confirm payment: ");
            int userOtp = sc.nextInt();
            if (userOtp == otp) {
                mainApp.walletBalance += amount;
                System.out.println("\n" + amount + " added successfully. New balance: " + mainApp.walletBalance);
                return true;
            } else {
                System.out.println("Invalid OTP. Fund addition failed.");
                return false;
            }
        } else {
            System.out.println("Invalid payment method.");
            return false;
        }
    }

    boolean processPayment(MainApp mainApp) {
        System.out.println("Total Amount: " + actualAmount);
        System.out.println("Select Payment Method:");
        System.out.println("1. Wallet");
        System.out.println("2. Cash (50% advance via wallet, rest on delivery)");
        System.out.print("Enter choice: ");
        int paymentMethod = sc.nextInt();

        if (paymentMethod == 1) {
            // Full payment via Wallet
            if (mainApp.walletBalance < actualAmount) {
                if (!addFundsToWallet(mainApp, actualAmount)) {
                    status = "Cancelled";
                    System.out.println("Booking cancelled due to failed fund addition.");
                    return false;
                }
            }
            mainApp.walletBalance -= actualAmount;
            status = "Confirmed";
            System.out.println("Payment successful via wallet! Booking confirmed. New wallet balance: " + mainApp.walletBalance);
            return true;
        } else if (paymentMethod == 2) {
            // Cash payment with 50% advance via wallet
            double advanceAmount = actualAmount * 0.5;
            if (mainApp.walletBalance < advanceAmount) {
                if (!addFundsToWallet(mainApp, advanceAmount)) {
                    status = "Cancelled";
                    System.out.println("Booking cancelled due to failed fund addition.");
                    return false;
                }
            }
            mainApp.walletBalance -= advanceAmount;
            status = "Confirmed (Cash on Delivery)";
            System.out.println("50% advance payment of " + advanceAmount + " successful via wallet. Remaining amount " + advanceAmount + " payable on delivery.");
            System.out.println("New wallet balance: " + mainApp.walletBalance);
            return true;
        } else {
            System.out.println("Invalid payment method.");
            status = "Cancelled";
            return false;
        }
    }

    void displayBookingInfo() {
        System.out.println("-----------------------------");
        System.out.println("Booking ID       : " + bookingId);
        System.out.println("Dish Name       : " + selectedDish.getDN());
        System.out.println("Chef Name       : " + selectedChef.name);
        System.out.println("Quantity        : " + quantity + " Kgs");
        System.out.println("Total Amount    : " + actualAmount);
        System.out.println("Delivery Address : " + tempAddress);
        System.out.println("Status          : " + status);
        System.out.println("-----------------------------");
    }
}

class Chef {
	// Regular Colors   
    	public static final String BLACK = "\033[0;30m";   // BLACK
    	public static final String red = "\033[0;31m";     // RED
    	public static final String green = "\033[0;32m";   // GREEN
    	public static final String yellow = "\033[0;33m";  // YELLOW
    	public static final String blue = "\033[0;34m";    // BLUE
    	public static final String purple = "\033[0;35m";  // PURPLE
    	public static final String cyan = "\033[0;36m";    // CYAN
    	public static final String white  = "\033[0;37m";   // WHITE
        
         //Reset
         public static final String reset = "\033[0m"; 

    int chefId;
    String name;
    String specialization;
    boolean isAvailable;
    double rating;
    int feedbackCount;
    double totalRating;
    int unavailableUntil; // Minutes until available (cooking time + 60 minutes)

    public Chef(int chefId, String name, String specialization, double rating) {
        this.chefId = chefId;
        this.name = name;
        this.specialization = specialization;
        this.rating = rating;
        this.isAvailable = true;
        this.feedbackCount = 1;
        this.totalRating = rating;
        this.unavailableUntil = 0;
    }

    void bookChef(int cookingTime) {
        if (isAvailable) {
            isAvailable = false;
            unavailableUntil = cookingTime + 60; // Cooking time + 1 hour
            System.out.println(name + " has been booked successfully.");
        } else {
            int hours = unavailableUntil / 60;
            int minutes = unavailableUntil % 60;
            System.out.println(name + " is not available. Available after approximately " + hours + " hour(s) and " + minutes + " minute(s).");
        }
    }

    void releaseChef() {
        isAvailable = true;
        unavailableUntil = 0;
        System.out.println(name + " is now available.");
    }

    void addFeedback(double feedbackRating) {
        totalRating += feedbackRating;
        feedbackCount++;
        rating = totalRating / feedbackCount;
        System.out.println("Feedback submitted. Updated rating for " + name + ": " + rating);
    }

    void displayChefInfo() {
        System.out.println("-----------------------------");
        System.out.println("Chef Id          : " + chefId);
        System.out.println("Chef Name        : " + name);
        System.out.println("Specialization   : " + specialization);
        System.out.println("Rating           : " + rating);
        System.out.println("Availability     : " + (isAvailable ? "Available" : "Not Available until ~" + (unavailableUntil / 60) + "h " + (unavailableUntil % 60) + "m"));
        System.out.println("-----------------------------");
    }
}

class ChefMain {
	// Regular Colors   
    	public static final String BLACK = "\033[0;30m";   // BLACK
    	public static final String red = "\033[0;31m";     // RED
    	public static final String green = "\033[0;32m";   // GREEN
    	public static final String yellow = "\033[0;33m";  // YELLOW
    	public static final String blue = "\033[0;34m";    // BLUE
    	public static final String purple = "\033[0;35m";  // PURPLE
    	public static final String cyan = "\033[0;36m";    // CYAN
    	public static final String white  = "\033[0;37m";   // WHITE
        
         //Reset
         public static final String reset = "\033[0m";  

    static Scanner sc = new Scanner(System.in);
    Chef nich11 = new Chef(1001, "Komali", "South Indian", 4.9);
    Chef nich22 = new Chef(1002, "Raju", "South Indian", 4.5);
    Chef nich33 = new Chef(1003, "Pavan", "South Indian", 4.0);
    Chef nich44 = new Chef(1004, "Siva Sai", "South Indian", 4.2);
    Chef nich55 = new Chef(1005, "Smitha", "South Indian", 3.9);
    Chef sich11 = new Chef(2001, "Ramesh", "North Indian", 4.6);
    Chef sich22 = new Chef(2002, "Gayathri", "North Indian", 4.9);
    Chef sich33 = new Chef(2003, "Komali", "North Indian", 4.4);
    Chef sich44 = new Chef(2004, "Vyshnavi", "North Indian", 4.2);
    Chef sich55 = new Chef(2005, "Arun", "North Indian", 4.8);
    Chef ch11 = new Chef(3001, "Veena", "Chinese", 4.2);
    Chef ch22 = new Chef(3002, "Ravali", "Chinese", 4.5);
    Chef ch33 = new Chef(3003, "Arun", "Chinese", 4.9);
    Chef ch44 = new Chef(3004, "Bhagya", "Chinese", 4.0);
    Chef ch55 = new Chef(3005, "Harsha", "Chinese", 4.6);

    void displaySouthIndianChefs() {
        System.out.println("South Indian Chefs:");
        nich11.displayChefInfo();
        nich22.displayChefInfo();
        nich33.displayChefInfo();
        nich44.displayChefInfo();
        nich55.displayChefInfo();
    }

    void displayNorthIndianChefs() {
        System.out.println("North Indian Chefs:");
        sich11.displayChefInfo();
        sich22.displayChefInfo();
        sich33.displayChefInfo();
        sich44.displayChefInfo();
        sich55.displayChefInfo();
    }

    void displayChineseChefs() {
        System.out.println("Chinese Chefs:");
        ch11.displayChefInfo();
        ch22.displayChefInfo();
        ch33.displayChefInfo();
        ch44.displayChefInfo();
        ch55.displayChefInfo();
    }

    Chef selectSouthIndianChef(int cookingTime) {
        System.out.print("Enter the Chef ID you want to book: ");
        int id = sc.nextInt();
        if (id == nich11.chefId) {
            nich11.bookChef(cookingTime);
            return nich11.isAvailable ? null : nich11;
        } else if (id == nich22.chefId) {
            nich22.bookChef(cookingTime);
            return nich22.isAvailable ? null : nich22;
        } else if (id == nich33.chefId) {
            nich33.bookChef(cookingTime);
            return nich33.isAvailable ? null : nich33;
        } else if (id == nich44.chefId) {
            nich44.bookChef(cookingTime);
            return nich44.isAvailable ? null : nich44;
        } else if (id == nich55.chefId) {
            nich55.bookChef(cookingTime);
            return nich55.isAvailable ? null : nich55;
        } else {
            System.out.println("Invalid chef ID. Please try again.");
            return selectSouthIndianChef(cookingTime);
        }
    }

    Chef selectNorthIndianChef(int cookingTime) {
        System.out.print("Enter the Chef ID you want to book: ");
        int id = sc.nextInt();
        if (id == sich11.chefId) {
            sich11.bookChef(cookingTime);
            return sich11.isAvailable ? null : sich11;
        } else if (id == sich22.chefId) {
            sich22.bookChef(cookingTime);
            return sich22.isAvailable ? null : sich22;
        } else if (id == sich33.chefId) {
            sich33.bookChef(cookingTime);
            return sich33.isAvailable ? null : sich33;
        } else if (id == sich44.chefId) {
            sich44.bookChef(cookingTime);
            return sich44.isAvailable ? null : sich44;
        } else if (id == sich55.chefId) {
            sich55.bookChef(cookingTime);
            return sich55.isAvailable ? null : sich55;
        } else {
            System.out.println("Invalid chef ID. Please try again.");
            return selectNorthIndianChef(cookingTime);
        }
    }

    Chef selectChineseChef(int cookingTime) {
        System.out.print("Enter the Chef ID you want to book: ");
        int id = sc.nextInt();
        if (id == ch11.chefId) {
            ch11.bookChef(cookingTime);
            return ch11.isAvailable ? null : ch11;
        } else if (id == ch22.chefId) {
            ch22.bookChef(cookingTime);
            return ch22.isAvailable ? null : ch22;
        } else if (id == ch33.chefId) {
            ch33.bookChef(cookingTime);
            return ch33.isAvailable ? null : ch33;
        } else if (id == ch44.chefId) {
            ch44.bookChef(cookingTime);
            return ch44.isAvailable ? null : ch44;
        } else if (id == ch55.chefId) {
            ch55.bookChef(cookingTime);
            return ch55.isAvailable ? null : ch55;
        } else {
            System.out.println("Invalid chef ID. Please try again.");
            return selectChineseChef(cookingTime);
        }
    }
}

class Main1 {
	// Regular Colors   
    	public static final String BLACK = "\033[0;30m";   // BLACK
    	public static final String red = "\033[0;31m";     // RED
    	public static final String green = "\033[0;32m";   // GREEN
    	public static final String yellow = "\033[0;33m";  // YELLOW
    	public static final String blue = "\033[0;34m";    // BLUE
    	public static final String purple = "\033[0;35m";  // PURPLE
    	public static final String cyan = "\033[0;36m";    // CYAN
    	public static final String white= "\033[0;37m";   // WHITE
        
         //Reset
         public static final String reset = "\033[0m"; 

    static Scanner sc = new Scanner(System.in);
    Random ran = new Random();
    Dish ni1 = new NorthIndian(101, "Paneer Butter Masala", "North Indian", 30, "Paneer, Tomato, Cream, Butter, Spices");
    Dish ni2 = new NorthIndian(102, "Dal Makhani", "North Indian", 25, "Urad Dal, Rajma, Butter, Spices");
    Dish ni3 = new NorthIndian(103, "Rajma Chawal", "North Indian", 35, "Rajma, Rice, Onion, Tomato, Spices");
    Dish ni4 = new NorthIndian(104, "Aloo Paratha", "North Indian", 20, "Wheat Flour, Potato, Spices");
    Dish ni5 = new NorthIndian(105, "Chole Bhature", "North Indian", 30, "Chickpeas, Flour, Onion, Tomato, Spices");
    Dish si1 = new SouthIndian(201, "Natukodi Chicken Curry", "South Indian", 30, "Chicken, Onion, Ginger, Garlic, Spices");
    Dish si2 = new SouthIndian(202, "Mutton Curry", "South Indian", 45, "Mutton, Onion, Spices");
    Dish si3 = new SouthIndian(203, "Chicken Biryani", "South Indian", 60, "Chicken, Rice, Spices, Yogurt");
    Dish si4 = new SouthIndian(204, "Mutton Biryani", "South Indian", 60, "Mutton, Rice, Spices, Yogurt");
    Dish si5 = new SouthIndian(205, "Veg Biryani", "South Indian", 10, "Rice, Vegetables, Spices");
    Dish ch1 = new Chinese(301, "Fried Rice", "Chinese", 18, "Rice, Vegetables, Soy Sauce");
    Dish ch2 = new Chinese(302, "Veg Noodles", "Chinese", 20, "Noodles, Vegetables, Soy Sauce");
    Dish ch3 = new Chinese(303, "Manchurian", "Chinese", 25, "Cabbage, Maida, Soy Sauce, Spices");
    Dish ch4 = new Chinese(304, "Chilli Paneer", "Chinese", 22, "Paneer, Capsicum, Soy Sauce, Spices");
    Dish ch5 = new Chinese(305, "Spring Roll", "Chinese", 15, "Vegetables, Maida, Soy Sauce");

    Booking[] previousBookings = new Booking[5]; // Store up to 5 previous bookings
    int bookingCount = 0; // Track number of bookings

    void typeDetails(Register user, ChefMain chefMain) {
        menu();
        choice(chefMain);
        selectRequiredDish(user, chefMain);
    }

    void menu() {
        System.out.println(green+"======= Welcome to Console Chef ======="+reset);
        System.out.println("Choose style to View Dishes:");
        System.out.println("1. North Indian");
        System.out.println("2. South Indian");
        System.out.println("3. Chinese");
    }

    void choice(ChefMain chefMain) {
        System.out.println(yellow+"==============Enter your choice (1-3)==========="+reset);
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println(cyan+"================Available North Indian Dishes==========="+reset);
            ni1.displayDishInfo();
            ni2.displayDishInfo();
            ni3.displayDishInfo();
            ni4.displayDishInfo();
            ni5.displayDishInfo();
        } else if (choice == 2) {
            System.out.println(purple+"================Available South Indian Dishes==========="+reset);
            si1.displayDishInfo();
            si2.displayDishInfo();
            si3.displayDishInfo();
            si4.displayDishInfo();
            si5.displayDishInfo();
        } else if (choice == 3) {
            System.out.println(blue+"================Available Chinese Dishes==========="+reset);
            ch1.displayDishInfo();
            ch2.displayDishInfo();
            ch3.displayDishInfo();
            ch4.displayDishInfo();
            ch5.displayDishInfo();
        } else {
            System.out.println("Invalid choice.");
            choice(chefMain);
        }
    }

    void selectRequiredDish(Register user, ChefMain chefMain) {
        System.out.print("Enter the dish ID you want: ");
        int id = sc.nextInt();
        Dish selectedDish = null;
        if (ni1.getId() == id) selectedDish = ni1;
        else if (ni2.getId() == id) selectedDish = ni2;
        else if (ni3.getId() == id) selectedDish = ni3;
        else if (ni4.getId() == id) selectedDish = ni4;
        else if (ni5.getId() == id) selectedDish = ni5;
        else if (si1.getId() == id) selectedDish = si1;
        else if (si2.getId() == id) selectedDish = si2;
        else if (si3.getId() == id) selectedDish = si3;
        else if (si4.getId() == id) selectedDish = si4;
        else if (si5.getId() == id) selectedDish = si5;
        else if (ch1.getId() == id) selectedDish = ch1;
        else if (ch2.getId() == id) selectedDish = ch2;
        else if (ch3.getId() == id) selectedDish = ch3;
        else if (ch4.getId() == id) selectedDish = ch4;
        else if (ch5.getId() == id) selectedDish = ch5;
        else {
            System.out.println("Dish ID not found. Please try again.");
            selectRequiredDish(user, chefMain);
            return;
        }
        updateIngredients(selectedDish);
        Chef selectedChef = selectChef(selectedDish.getSt(), chefMain, selectedDish.getcookingTime());
        if (selectedChef != null) {
            createBooking(user, selectedDish, selectedChef);
        } else {
            System.out.println("No chef booked. Returning to dish selection.");
            selectRequiredDish(user, chefMain);
        }
    }

    void updateIngredients(Dish dish) {
        System.out.println(green+"========= Selected Dish Details ========="+reset);
        dish.displayDishInfo();
        System.out.print("Do you want to change the ingredients? (Press 1 for Yes, 0 for No): ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            System.out.print("Enter new ingredients: ");
            String newIngredients = sc.nextLine();
            dish.setIndedients(newIngredients);
            System.out.println("Ingredients updated successfully!");
            System.out.println("Updated Dish Info:");
            dish.displayDishInfo();
        }
    }

    Chef selectChef(String style, ChefMain chefMain, int cookingTime) {
        if (style.equals("North Indian")) {
            chefMain.displayNorthIndianChefs();
            return chefMain.selectNorthIndianChef(cookingTime);
        } else if (style.equals("South Indian")) {
            chefMain.displaySouthIndianChefs();
            return chefMain.selectSouthIndianChef(cookingTime);
        } else if (style.equals("Chinese")) {
            chefMain.displayChineseChefs();
            return chefMain.selectChineseChef(cookingTime);
        }
        return null;
    }

    void createBooking(Register user, Dish selectedDish, Chef selectedChef) {
        System.out.print("Enter quantity for the order (in Kgs): ");
        int quantity = sc.nextInt();
        sc.nextLine();
        String bookingId = "B" + (100000 + ran.nextInt(100000));
        Booking booking = new Booking(bookingId, selectedDish, selectedChef, user.getad(), quantity);
        booking.updateAddress();
        if (booking.processPayment(MainApp.thisMainApp)) {
            // Store the booking in previousBookings
            if (bookingCount < 5) {
                previousBookings[bookingCount] = booking;
                bookingCount++;
            } else {
                // Shift bookings to keep only the latest 5
                for (int i = 0; i < 4; i++) {
                    previousBookings[i] = previousBookings[i + 1];
                }
                previousBookings[4] = booking;
            }
            System.out.println("Booking Details:");
            booking.displayBookingInfo();
            provideFeedback(selectedChef);
        } else {
            selectedChef.releaseChef();
        }
    }

    void provideFeedback(Chef chef) {
        System.out.print("Please provide feedback rating for the chef (1.0 to 5.0): ");
        double rating = sc.nextDouble();
        if (rating >= 1.0 && rating <= 5.0) {
            chef.addFeedback(rating);
        } else {
            System.out.println("Invalid rating. Please enter a rating between 1.0 and 5.0.");
            provideFeedback(chef);
        }
    }

    void viewPreviousOrder() {
        if (bookingCount == 0) {
            System.out.println("No previous orders found.");
        } else {
            System.out.println(yellow+"===== Previous Orders (Up to 5) ====="+reset);
            for (int i = 0; i < bookingCount; i++) {
                System.out.println("Order " + (i + 1) + ":");
                previousBookings[i].displayBookingInfo();
            }
        }
    }
}

class MainApp {
	// Regular Colors   
    	public static final String BLACK = "\033[0;30m";   // BLACK
    	public static final String red = "\033[0;31m";     // RED
    	public static final String green = "\033[0;32m";   // GREEN
    	public static final String yellow = "\033[0;33m";  // YELLOW
    	public static final String blue = "\033[0;34m";    // BLUE
    	public static final String purple = "\033[0;35m";  // PURPLE
    	public static final String cyan = "\033[0;36m";    // CYAN
    	public static final String white  = "\033[0;37m";   // WHITE
        
         //Reset
         public static final String reset = "\033[0m"; 

    static Scanner sc = new Scanner(System.in);
    static MainApp thisMainApp;
    Register user;
    Main1 main1;
    ChefMain chefMain;
    double walletBalance;

    MainApp() {
        thisMainApp = this;
        System.out.println("Enter Username: ");
        String name = sc.nextLine();
        System.out.println("Enter Phone Number: ");
        Long ph= sc.nextLong();
        sc.nextLine();
        System.out.println("Enter Address: ");  
        String Address= sc.nextLine();
        System.out.println("Enter password: "); 
            String pass = sc.nextLine();
        System.out.println();
            
        user = new Register(name, ph,Address, pass);
        main1 = new Main1();
        chefMain = new ChefMain();
        walletBalance = 0.0;
    }

    void login() {
        System.out.println(yellow+"Login to Console Chef"+reset);
        System.out.println("Username: ");
        String username = sc.nextLine();
       
        System.out.println("Password: ");
        String pass = sc.nextLine();
        
        if (username.equals(user.getu()) && pass.equals(user.getp())) {
            System.out.println( green+"=== Welcome to Console Chef Platform =="+reset);
            showMainMenu();
        } else if (!username.equals(user.getu())) {
            System.out.println("Username not found.");
            System.out.println("Enter 1 to Try Again or 2 to Retrieve Username");
            int n = sc.nextInt();
            sc.nextLine();
            if (n == 1) login();
            else getUsername();
        } else {
            System.out.println("Password is incorrect.");
            System.out.println("Enter 1 to Try Again or 2 to Retrieve Password");
            int n = sc.nextInt();
            sc.nextLine();
            if (n == 1) login();
            else getPassword();
        }
    }

    void showMainMenu() {
        System.out.println("------------------------------------------");
        System.out.println("1. Menu");
        System.out.println("2. Previous Orders");
        System.out.println("3. Wallet");
        System.out.println("4. User Details");
        System.out.println("5. Logout");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                main1.typeDetails(user, chefMain);
                showMainMenu();
                break;
            case 2:
                main1.viewPreviousOrder();
                showMainMenu();
                break;
            case 3:
                manageWallet();
                showMainMenu();
                break;
            case 4:
                editUserDetails();
                showMainMenu();
                break;
            case 5:
                System.out.println("Successfully logged out. See you soon, " + user.getu());
                login();
                break;
            case 6:
                System.out.println("Thank you for using Console Chef. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                showMainMenu();
        }
    }

    void manageWallet() {
        System.out.println("Current Wallet Balance: " + walletBalance);
        System.out.println("1. Add Money");
        System.out.println("2. Back to Main Menu");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("Select Payment Method to Add Funds:");
            System.out.println("1. UPI");
            System.out.println("2. Bank Transfer");
            System.out.print("Enter choice: ");
            int paymentMethod = sc.nextInt();
            if (paymentMethod == 1 || paymentMethod == 2) {
                System.out.print("Enter amount to add: ");
                double amount = sc.nextDouble();

                if (amount > 0) {
                    while(true){
                        Random ran = new Random();
                        int otp = 100000 + ran.nextInt(900000);
                        System.out.println("OTP sent to your registered phone number: " + otp);
                        System.out.print("Enter OTP to confirm payment: ");
                        int userOtp = sc.nextInt();
                        if (userOtp == otp) {
                            walletBalance += amount;
                            System.out.println("\n" + amount + " Added successfully. \nNew balance: " + walletBalance);
                            break;
                        } else {
                            System.out.println("Invalid OTP. Fund addition failed.");
                            System.out.println("Enter 1 for resend otp or 2 for cancel ");
                            int n = sc.nextInt();
                            if(n==1){

                            }
                            else    
                                System.out.println("Fund addition cancelled");
                                break;
                        }
                    }
                } else {
                    System.out.println("Invalid amount.");
                }
            } else {
                System.out.println("Invalid payment method.");
            }
        }
    }
    

    void editUserDetails() {
        System.out.println(yellow+"===== User Details ====="+yellow);
        System.out.println("Username: " + user.getu());
        System.out.println("Phone Number: " + user.getpn());
        System.out.println("Address: " + user.getad());
        System.out.println("1. Change Username");
        System.out.println("2. Change Phone Number");
        System.out.println("3. Change Address");
        System.out.println("4. Change Password");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Enter new username: ");
                user.setu(sc.nextLine());
                System.out.println("Username updated successfully!");
                break;
            case 2:
                System.out.print("Enter new phone number: ");
                user.setpn(sc.nextLong());
                System.out.println("Phone number updated successfully!");
                break;
            case 3:
                System.out.print("Enter new address: ");
                user.setad(sc.nextLine());
                System.out.println("Address updated successfully!");
                break;
            case 4:
                System.out.print("Enter new password: ");
                user.setp(sc.nextLine());
                System.out.println("Password updated successfully!");
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    void getUsername() {
        System.out.print("Enter phone number to retrieve username: ");
        long phone = sc.nextLong();
        sc.nextLine();
        if (phone == user.getpn()) {
            System.out.println("Username: " + user.getu());
            login();
        } else {
            System.out.println("Invalid phone number. Enter 1 to Try Again or 2 to Change Username");
            int n = sc.nextInt();
            if (n == 1) getUsername();
            else changeUsername();
        }
    }

    void getPassword() {
        System.out.print("Enter username and phone number to retrieve password: ");
        String username = sc.next();
        long phone = sc.nextLong();
        sc.nextLine();
        if (username.equals(user.getu()) && phone == user.getpn()) {
            System.out.println("Password: " + user.getp());
            login();
        } else {
            System.out.println("Invalid credentials. Enter 1 to Try Again or 2 to Change Password");
            int n = sc.nextInt();
            if (n == 1) getPassword();
            else changePassword();
        }
    }

    void changeUsername() {
        System.out.print("Enter new username: ");
        user.setu(sc.next());
        System.out.println("Username changed successfully: " + user.getu());
        login();
    }

    void changePassword() {
        System.out.print("Enter new password: ");
        user.setp(sc.next());
        System.out.println("Password changed successfully.");
        login();
    }

    public static void main(String[] args) {
        new MainApp().login();
    }
}
