package udemy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Result {

    public static int getTransactions(int userId, int locationId, int netStart, int netEnd) throws IOException {


    }

    private static String getResult(String userId, String pageNum) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL("https://jsonmock.hackerrank.com/api.transactions/search?userid=" + userId + "&page=" + pageNum);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        return result.toString();
    }

    class Response {
        int page;
        int per_page;
        int total;
        int total_pages;
        Data[] data;
    }

    class Data {
        int id;
        int userId;
        String userName;
        long timestamp;
        String txnType;
        String amount;
        String ip;
        Location location;
    }

    class Location {
        int id;
        String address;
        String city;
        int zipCode;
    }
}
