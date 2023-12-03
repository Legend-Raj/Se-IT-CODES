import java.util.Scanner;
interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
        // Additional logic for PayPal payment
    }
}

// Concrete implementation for BitCoin payment
class BitCoinPayment implements PaymentStrategy {
    private String walletAddress;

    public BitCoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using BitCoin.");
        // Additional logic for BitCoin payment
    }
}

// Context class that uses the payment strategy
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        } else {
            System.out.println("Please set a payment strategy first.");
        }
    }
}

public class ShoppingCartApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        int choice;
        do {
            System.out.println("1. Set Credit Card Payment");
            System.out.println("2. Set PayPal Payment");
            System.out.println("3. Set BitCoin Payment");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                switch (choice) {
                    case 1:
                        System.out.print("Enter Credit Card Number: ");
                        String cardNumber = scanner.nextLine();
                        System.out.print("Enter Expiry Date: ");
                        String expiryDate = scanner.nextLine();
                        System.out.print("Enter CVV: ");
                        String cvv = scanner.nextLine();
                        cart.setPaymentStrategy(new CreditCardPayment(cardNumber, expiryDate, cvv));
                        System.out.println("Credit Card Payment Set.");
                        break;

                    case 2:
                        System.out.print("Enter PayPal Email: ");
                        String email = scanner.nextLine();
                        cart.setPaymentStrategy(new PayPalPayment(email));
                        System.out.println("PayPal Payment Set.");
                        break;

                    case 3:
                        System.out.print("Enter BitCoin Wallet Address: ");
                        String walletAddress = scanner.nextLine();
                        cart.setPaymentStrategy(new BitCoinPayment(walletAddress));
                        System.out.println("BitCoin Payment Set.");
                        break;

                    case 4:
                        System.out.print("Enter the amount to checkout: ");
                        double amount = scanner.nextDouble();
                        cart.checkout(amount);
                        break;

                    case 5:
                        System.out.println("Exiting the program. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Consume the invalid input
                choice = 0; // Reset choice to continue the loop
            }
        } while (choice != 5);
    }
}
