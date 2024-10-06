package com.demoParsing.apiParsing;

import org.json.JSONObject;
import org.json.JSONArray;

public class JsonParsingExample {
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

        // Parse JSON String to JSONObject
        JSONObject jsonObject = new JSONObject(jsonString);

        // Get values from JSON Object
        String name = jsonObject.getString("name");
        int age = jsonObject.getInt("age");
        boolean isEmployee = jsonObject.getBoolean("isEmployee");

        // Get nested JSON Object (address)
        JSONObject address = jsonObject.getJSONObject("address");
        String street = address.getString("street");
        String city = address.getString("city");

        // Get JSON Array (phone numbers)
        JSONArray phoneNumbers = jsonObject.getJSONArray("phoneNumbers");
        String phone1 = phoneNumbers.getString(0);
        String phone2 = phoneNumbers.getString(1);

        // Output values
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Is Employee: " + isEmployee);
        System.out.println("Address: " + street + ", " + city);
        System.out.println("Phone 1: " + phone1);
        System.out.println("Phone 2: " + phone2);
    }
}
