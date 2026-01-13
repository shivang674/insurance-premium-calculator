import java.time.LocalDate;

public class Policy {
    private String policyId;
    private PolicyType policyType;
    private LocalDate startDate;
    private double coverageAmount;
    private RiskLevel riskLevel;
    private double premium;
    private boolean active = true;

    public Policy(String policyId, PolicyType policyType,
                  LocalDate startDate, double coverageAmount) {
        this.policyId = policyId;
        this.policyType = policyType;
        this.startDate = startDate;
        this.coverageAmount = coverageAmount;
    }

    public PolicyType getPolicyType() { return policyType; }
    public LocalDate getStartDate() { return startDate; }
    public double getCoverageAmount() { return coverageAmount; }
    public boolean isActive() { return active; }
    public void setRiskLevel(RiskLevel riskLevel) { this.riskLevel = riskLevel; }
    public void setPremium(double premium) { this.premium = premium; }
    public RiskLevel getRiskLevel() { return riskLevel; }
    public double getPremium() { return premium; }
}
