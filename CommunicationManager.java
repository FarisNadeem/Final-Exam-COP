package finalexam.task5;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CommunicationManager {

    private String endpoint;

    public CommunicationManager(String endpoint) {
        this.endpoint = endpoint;
    }

    public String sendUserMessage(String message) {
        try {
            // Create URL object
            URL url = new URL(endpoint);

            // Create HttpURLConnection object
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method to POST
            connection.setRequestMethod("POST");

            // Set headers
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            // Create JSON payload
            String jsonInputString = "{\"message\": \"" + message + "\"}";

            // Write JSON payload to the output stream
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Read response
            try (Scanner scanner = new Scanner(connection.getInputStream(), "utf-8")) {
                String response = scanner.useDelimiter("\\A").next();
                return response;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Example usage
        CommunicationManager manager = new CommunicationManager("http://example.com/api/endpoint");
        String response = manager.sendUserMessage("Hello, this is a test message!");
        System.out.println("Response: " + response);
    }
}
