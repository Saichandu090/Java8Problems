package problem4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Claim
{
    private Integer claimId;
    private String policyNumber;
    private Double claimAmount;
    private LocalDate claimDate;
    private String status;
}
