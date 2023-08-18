package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.example.Sample.setRandomPrice;

class Sample {
    static double setRandomPrice(String ticker) {
        return (Math.random() * 1000);
    }
}

public class RecordsPractice {
    public static void main(String[] args) {

        record Stock(String ticker, double price) {
            @Override
            public String ticker() {
                return ticker.trim().toUpperCase();
            }

            @Override
            public String toString() {
                //$%,.2f means a double(%f) with 2 decimal points
                return "%s: $%,.2f".formatted(ticker(), Stock.this.price);
            }
        }

        Stock stock = new Stock("TSLa", 299);
//        System.out.println(stock);
        List<String> tickers = List.of("Goog", "AMZN ", "AAPL");

        var stockStream = tickers.stream()
                .map(it -> new Stock(it, setRandomPrice(it)));

        Stream.concat(Stream.of(stock), stockStream)
                .sorted(Comparator.comparing(Stock::ticker))
                .forEach(System.out::println);
    }


}
