package problem5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyHolder
{
    private int holderId;
    private String name;
    private int age;
    private String policyType;
    private double premiumAmount;
}
