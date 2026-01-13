public class Customer {
    private String customerId;
    private int age;
    private double annualIncome;
    private boolean smoker;
    private boolean hasPreExistingDisease;

    public Customer(String customerId, int age, double annualIncome,
                    boolean smoker, boolean hasPreExistingDisease) {
        this.customerId = customerId;
        this.age = age;
        this.annualIncome = annualIncome;
        this.smoker = smoker;
        this.hasPreExistingDisease = hasPreExistingDisease;
    }

    public int getAge() { return age; }
    public double getAnnualIncome() { return annualIncome; }
    public boolean isSmoker() { return smoker; }
    public boolean hasPreExistingDisease() { return hasPreExistingDisease; }
}