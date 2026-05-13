import java.util.*;

public class PriceStore {
    public List<String> data = new ArrayList<>(); 

    public void addPrice(String ticker, double price, long timestamp) {
        String record = ticker + ":" + price + ":" + timestamp;
        data.add(record);
        System.out.printf("Saved price %s with value %s and time %s%n", ticker, price, timestamp);
    }

    public double getLatestPrice(String ticker) {
        double lastPrice = -1.0;
        for (String s : data) {
            if (s.startsWith(ticker)) {
                String[] parts = s.split(":");
                lastPrice = Double.parseDouble(parts[1]);
            }
        }
        return lastPrice;
    }
}

void main() {
    var priceStore = new PriceStore();
    
    var ticker = "CH0123456789";
    priceStore.addPrice(ticker, 1.0, System.currentTimeMillis());
    priceStore.addPrice(ticker, 2.0, System.currentTimeMillis());
    priceStore.addPrice(ticker, 3.0, System.currentTimeMillis());
    
    var latestPrice = priceStore.getLatestPrice(ticker);
    var expectedLatestPrice = 3.0;
    System.out.printf("Latest price for ticker %s is %s? %s%n", ticker, expectedLatestPrice, latestPrice == expectedLatestPrice);
    
    ticker = "CH9876543210";
    latestPrice = priceStore.getLatestPrice(ticker);
    expectedLatestPrice = -1d;
    System.out.printf("Latest price for ticker %s is %s? %s%n", ticker, expectedLatestPrice, latestPrice == expectedLatestPrice);
}
