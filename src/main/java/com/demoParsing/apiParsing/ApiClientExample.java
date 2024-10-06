package com.demoParsing.apiParsing;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import org.json.JSONArray;

public class ApiClientExample {

    public static void main(String[] args) throws Exception {
        // The API endpoint
        String apiUrl = "https://api.example.com/person"; // Replace with actual API URL

        // Fetch the JSON response from the API
        String jsonResponse = fetchJsonFromApi(apiUrl);

        // Parse the JSON and map it to the DTO
        PersonDTO person = parseJsonToDTO(jsonResponse);

        // Output DTO values
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Is Employee: " + person.isEmployee());
        System.out.println("Address: " + person.getAddress().getStreet() + ", " + person.getAddress().getCity());
        System.out.println("Phone 1: " + person.getPhoneNumbers()[0]);
        System.out.println("Phone 2: " + person.getPhoneNumbers()[1]);
    }

    // Method to fetch JSON from an API
    public static String fetchJsonFromApi(String apiUrl) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body(); // JSON response as a string
    }

    // Method to parse JSON and map it to the PersonDTO
    public static PersonDTO parseJsonToDTO(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);

        PersonDTO person = new PersonDTO();
        person.setName(jsonObject.getString("name"));
        person.setAge(jsonObject.getInt("age"));
        person.setEmployee(jsonObject.getBoolean("isEmployee"));

        // Parse address
        JSONObject addressJson = jsonObject.getJSONObject("address");
        AddressDTO address = new AddressDTO();
        address.setStreet(addressJson.getString("street"));
        address.setCity(addressJson.getString("city"));
        person.setAddress(address);

        // Parse phone numbers
        JSONArray phoneNumbersJson = jsonObject.getJSONArray("phoneNumbers");
        String[] phoneNumbers = new String[phoneNumbersJson.length()];
        for (int i = 0; i < phoneNumbersJson.length(); i++) {
            phoneNumbers[i] = phoneNumbersJson.getString(i);
        }
        person.setPhoneNumbers(phoneNumbers);

        return person;
    }
}
