package problem6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction
{
    private int transactionId;
    private String policyNumber;
    private Double amount;
    private LocalDate transactionDate;
    private boolean isFraudulent;
}
