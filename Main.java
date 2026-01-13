import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("===== INSURANCE PREMIUM CALCULATOR =====");

        System.out.print("Enter Customer ID: ");
        String customerId = sc.nextLine();

        int age;
        do {
            System.out.print("Enter Age: ");
            age = sc.nextInt();
        } while (age <= 0);

        double income;
        do {
            System.out.print("Enter Annual Income: ");
            income = sc.nextDouble();
        } while (income <= 0);

        boolean smoker = readYesNo("Are you a smoker? (yes/no): ");
        boolean disease = readYesNo("Do you have pre-existing disease? (yes/no): ");

        Customer customer = new Customer(customerId, age, income, smoker, disease);

        System.out.println("\nSelect Policy Type:");
        System.out.println("1. HEALTH");
        System.out.println("2. TERM");

        int choice;
        do {
            System.out.print("Enter choice (1 or 2): ");
            choice = sc.nextInt();
        } while (choice != 1 && choice != 2);

        PolicyType policyType =
                (choice == 1) ? PolicyType.HEALTH : PolicyType.TERM;

        double coverage;
        do {
            System.out.print("Enter Coverage Amount: ");
            coverage = sc.nextDouble();
        } while (coverage <= 0);

        Policy policy = new Policy(
                "P-" + customerId,
                policyType,
                LocalDate.now(),
                coverage
        );

        RiskLevel risk = PremiumCalculator.calculateRisk(customer);
        double premium = PremiumCalculator.calculatePremium(policyType, risk);

        policy.setRiskLevel(risk);
        policy.setPremium(premium);

        System.out.println("\n===== PREMIUM DETAILS =====");
        System.out.println("Risk Level     : " + risk);
        System.out.println("Annual Premium : ₹" + premium);

        savePolicyToFile(customer, policy);

        System.out.println("\n===== CLAIM VALIDATION =====");
        System.out.print("Enter Claim Amount: ");
        double claimAmount = sc.nextDouble();

        Claim claim = new Claim(
                "CL-" + customerId,
                claimAmount,
                LocalDate.now().plusDays(40)
        );

        ClaimStatus status =
                ClaimValidator.validateClaim(policy, claim);

        System.out.println("Claim Status: " + status);

        sc.close();
    }

    private static boolean readYesNo(String message) {
        String input;
        do {
            System.out.print(message);
            input = sc.next().toLowerCase();
        } while (!input.equals("yes") && !input.equals("no"));
        return input.equals("yes");
    }

    private static void savePolicyToFile(Customer customer, Policy policy) {
        try (FileWriter writer = new FileWriter("policy-details.txt", true)) {
            writer.write("Customer Age: " + customer.getAge() + "\n");
            writer.write("Policy Type : " + policy.getPolicyType() + "\n");
            writer.write("Risk Level  : " + policy.getRiskLevel() + "\n");
            writer.write("Premium     : " + policy.getPremium() + "\n");
            writer.write("-------------------------------\n");
        } catch (IOException e) {
            System.out.println("Error saving policy to file.");
        }
    }
}
