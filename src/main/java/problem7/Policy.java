package problem7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy
{
    private int policyId;
    private int policyHolderId;
    private LocalDate expiryDate;
    private double premiumAmount;
    private String status;
}
