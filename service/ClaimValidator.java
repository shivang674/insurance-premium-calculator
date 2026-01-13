import java.time.temporal.ChronoUnit;

public class ClaimValidator {
    private static final int WAITING_PERIOD_DAYS = 30;

    public static ClaimStatus validateClaim(Policy policy, Claim claim) {
        if (!policy.isActive()) return ClaimStatus.REJECTED;

        long days = ChronoUnit.DAYS.between(
                policy.getStartDate(), claim.getClaimDate());

        if (days < WAITING_PERIOD_DAYS) return ClaimStatus.REJECTED;
        if (claim.getClaimAmount() > policy.getCoverageAmount())
            return ClaimStatus.REJECTED;

        return ClaimStatus.APPROVED;
    }
}
