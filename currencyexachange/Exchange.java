package org.example;

import org.json.JSONObject;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input base currency, target currency, and amount
        System.out.print("Enter base currency (e.g., USD): ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency (e.g., EUR): ");
        String targetCurrency = scanner.next().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        try {
            // Construct the API URL
            String apiKey = "bfa999ca63b7b3af60356cab"; // Replace with your actual API key
            String urlString = "https://v6.exchangerate-api.com/v6/bfa999ca63b7b3af60356cab/latest/USD";
            System.out.println("URL: " + urlString); // Debugging line to check the URL

            // Open a connection to the URL
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Check HTTP response code
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) { // HTTP 200 OK
                // Read the response
                InputStream inputStream = connection.getInputStream();
                Scanner responseScanner = new Scanner(inputStream);
                StringBuilder jsonResponse = new StringBuilder();

                while (responseScanner.hasNext()) {
                    jsonResponse.append(responseScanner.nextLine());
                }

                responseScanner.close();

                // Parse JSON response
                JSONObject jsonObject = new JSONObject(jsonResponse.toString());
                JSONObject conversionRates = jsonObject.getJSONObject("conversion_rates");

                // Check if target currency exists and calculate conversion
                if (conversionRates.has(targetCurrency)) {
                    double rate = conversionRates.getDouble(targetCurrency);
                    double convertedAmount = amount * rate;
                    System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);
                } else {
                    System.out.println("Target currency not found in the conversion rates.");
                }
            } else {
                // Handle HTTP error response
                System.out.println("Error occurred: HTTP " + responseCode);
                System.out.println("Conversion failed. Please check your input or try again later.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}

