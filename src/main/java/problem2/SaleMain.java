package problem2;

import java.util.List;
import java.util.stream.Collectors;

public class SaleMain
{
    public static void main(String[] args) {

        List<Sale> saleList=List.of(new Sale(1,5,199.0),
                                    new Sale(2,11,1992.45),
                                    new Sale(3,5,123.34),
                                    new Sale(4,15,19.65),
                                    new Sale(5,7,1999.99),
                                    new Sale(6,25,2345.98),
                                    new Sale(7,2,122.23));

        List<Sale> soldOver10=saleList.stream()
                .filter(e->e.getQuantity()>10)
                .toList();
        soldOver10.forEach(System.out::println);

        System.out.println("====================");

        List<ProductSales> revenue=saleList.stream()
                .map(sale -> new ProductSales(sale.getProductId(),sale.getQuantity()*sale.getPrice()))
                .toList();

        revenue.forEach(System.out::println);

        System.out.println("=====================");

        List<ProductSales> sortByRevenue=revenue.stream()
                .sorted((s1,s2)-> (int) (s2.getRevenue()-s1.getRevenue()))
                .toList();

        sortByRevenue.forEach(System.out::println);

        System.out.println("======================");

        List<ProductSales> top5ByRevenue=sortByRevenue.stream()
                .limit(5)
                .toList();

        top5ByRevenue.forEach(System.out::println);

    }
}
