package com.demoParsing.apiParsing;

import org.json.JSONObject;
import org.json.JSONArray;

public class JsonParsingWithDTO {
    public static void main(String[] args) {
        // Example JSON String
        String jsonString = "{"
                + "\"name\": \"John\","
                + "\"age\": 30,"
                + "\"isEmployee\": true,"
                + "\"address\": {"
                + "  \"street\": \"123 Main St\","
                + "  \"city\": \"New York\""
                + "},"
                + "\"phoneNumbers\": [\"123-456-7890\", \"987-654-3210\"]"
                + "}";

        // Parse JSON String to PersonDTO
        PersonDTO person = parseJsonToDTO(jsonString);

        // Output DTO values
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Is Employee: " + person.isEmployee());
        System.out.println("Address: " + person.getAddress().getStreet() + ", " + person.getAddress().getCity());
        System.out.println("Phone 1: " + person.getPhoneNumbers()[0]);
        System.out.println("Phone 2: " + person.getPhoneNumbers()[1]);
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
