package problem3;

import java.util.List;

public class BookMain
{
    public static void main(String[] args) {

        List<Book> bookList=List.of(new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
                                    new Book("Neuromancer", "William Gibson", "Science Fiction", 4.8),
                                    new Book("Foundation", "Isaac Asimov", "Horror", 4.7),
                                    new Book("Hyperion", "Dan Simmons", "Science Fiction", 3.3),
                                    new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.9),
                                    new Book("The Martian", "Andy Weir", "Thriller", 4.6));

        List<Book> filterByRating=bookList.stream()
                .filter(s->s.getRating()>4 && s.getGenre().equalsIgnoreCase("Science Fiction"))
                .toList();

        filterByRating.forEach(System.out::println);

        System.out.println("===================");

        List<BookRecommendation> bookRecommendations=bookList.stream()
                .map(s->new BookRecommendation(s.getTitle(),s.getRating()))
                .toList();

        bookRecommendations.forEach(System.out::println);

        System.out.println("===================");

        List<BookRecommendation> sortByRatingInDesc=bookRecommendations.stream()
                .sorted((s1,s2)->Double.compare(s2.getRating(),s1.getRating()))
                .toList();

        sortByRatingInDesc.forEach(System.out::println);

        System.out.println("==================");
    }
}
