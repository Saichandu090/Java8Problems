package problem7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RenewalRemainder
{
    private int policyId;
    private int policyHolderId;
    private int daysRemaining;
}
