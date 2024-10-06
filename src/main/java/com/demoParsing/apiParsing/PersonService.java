package com.demoParsing.apiParsing;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class PersonService {

    // Method to fetch JSON from an API and map it to the PersonDTO
    public PersonDTO fetchPersonData() throws Exception {
        String apiUrl = "https://api.example.com/person";  // Replace with actual API URL
        String jsonResponse = fetchJsonFromApi(apiUrl);
        return parseJsonToDTO(jsonResponse);
    }

    // Fetch JSON from API
    private String fetchJsonFromApi(String apiUrl) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    // Parse JSON to DTO
    private PersonDTO parseJsonToDTO(String jsonString) {
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
