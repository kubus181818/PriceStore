import java.util.*;

public class PriceStore {
    public List<String> data = new ArrayList<>(); 

    public void addPrice(String ticker, double price, long timestamp) {
        String record = ticker + ":" + price + ":" + timestamp;
        data.add(record);
        System.out.println("Saved " + ticker);
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
