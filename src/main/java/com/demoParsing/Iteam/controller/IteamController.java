package com.demoParsing.Iteam.controller;

import com.demoParsing.Iteam.dto.IteamDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IteamController {

    @RequestMapping(value = "/itemAdd",method = RequestMethod.POST)
    public ResponseEntity<String>createIteam(@RequestBody IteamDto iteamDto){
        return ResponseEntity.ok("Iteam created"+iteamDto);
    }
    @RequestMapping(value = "/itemsAll", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getItems() {
        List<String> items = new ArrayList<>();
        items.add("Item1");
        items.add("Item2");
        return ResponseEntity.ok(items);
    }
    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getItemById(@PathVariable("id") int id) {
        String item = "Item" + id;
        return ResponseEntity.ok(item);
    }
    @RequestMapping(value = "/item/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateItem(@PathVariable("id") int id, @RequestBody String updatedItem) {
        return ResponseEntity.ok("Item " + id + " updated to: " + updatedItem);
    }
    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteItem(@PathVariable("id") int id) {
        // Code to delete the item
        return ResponseEntity.ok("Item " + id + " deleted");
    }
}
