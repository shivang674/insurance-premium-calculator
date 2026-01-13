public class PremiumCalculator {

    public static RiskLevel calculateRisk(Customer customer) {
        int riskScore = 0;
        if (customer.getAge() > 40) riskScore += 20;
        if (customer.isSmoker()) riskScore += 30;
        if (customer.hasPreExistingDisease()) riskScore += 25;
        if (customer.getAnnualIncome() < 500000) riskScore += 10;

        if (riskScore <= 30) return RiskLevel.LOW;
        else if (riskScore <= 60) return RiskLevel.MEDIUM;
        else return RiskLevel.HIGH;
    }

    public static double calculatePremium(PolicyType type, RiskLevel riskLevel) {
        double base = (type == PolicyType.HEALTH) ? 5000 : 3000;
        switch (riskLevel) {
            case LOW: return base * 1.1;
            case MEDIUM: return base * 1.3;
            case HIGH: return base * 1.6;
            default: return base;
        }
    }
}