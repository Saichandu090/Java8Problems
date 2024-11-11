package problem8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTransaction
{
    private int customerId;
    private LocalDate transactionDate;
    private Double transactionAmount;
}
