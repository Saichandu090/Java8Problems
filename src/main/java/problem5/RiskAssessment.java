package problem5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskAssessment
{
    private int holderId;
    private String name;
    private Double riskScore;
}
