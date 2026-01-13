import java.time.LocalDate;

public class Claim {
    private String claimId;
    private double claimAmount;
    private LocalDate claimDate;

    public Claim(String claimId, double claimAmount, LocalDate claimDate) {
        this.claimId = claimId;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
    }

    public double getClaimAmount() { return claimAmount; }
    public LocalDate getClaimDate() { return claimDate; }
}
