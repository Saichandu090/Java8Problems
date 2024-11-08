package problem3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book
{
    private String title;
    private String author;
    private String genre;
    private double rating;
}
