package udemy;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Result {

    static Gson gson = new Gson();

    public static void main(String[] args) throws Exception {
        System.out.println(getTransactions(2, 8, 5, 50));
    }

    public static int getTransactions(int userId, int locationId, int netStart, int netEnd) throws Exception {

        // get data for first page
        String firstPage = getResult(userId, 1);
        Response response = gson.fromJson(firstPage, Response.class);

        // how many pages
        int pages = response.total_pages;

        int sum = 0;

        // start querying
        for (int i = 1; i <= pages; i++) {
            response = gson.fromJson(getResult(userId, i), Response.class);
            // query data
            for (Data data : response.data) {
                // check location
                if (data.location.id == locationId) {
                    // query ip
                    String ip = data.ip;
                    int firstByte = Integer.parseInt(ip.split("\\.")[0]);
                    if (firstByte >= netStart && firstByte <= netEnd) {
                        String temp = data.amount;
                        temp = temp.replace(",", "");
                        if (data.amount.startsWith("$")) {
                            temp = temp.split("\\$")[1];
                        }
                        sum += (int) Double.parseDouble(temp);
                    }
                }
            }
        }

        return sum;
    }

    private static String getResult(int userId, int pageNum) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL("https://jsonmock.hackerrank.com/api/transactions/search?userid=" + userId + "&page=" + pageNum);
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
