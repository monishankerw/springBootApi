package com.demoParsing.items.controller;

import com.demoParsing.Iteam.dto.IteamDto;
import com.demoParsing.items.service.IteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IteamController {

    @Autowired
    private IteamService iteamService;

    @PostMapping("/itemAdd")
    public ResponseEntity<IteamDto> createIteam(@RequestBody IteamDto iteamDto) {
        IteamDto createdItem = iteamService.createIteam(iteamDto);
        return ResponseEntity.ok(createdItem);
    }

    @GetMapping("/itemsAll")
    public ResponseEntity<List<IteamDto>> getItems() {
        List<IteamDto> items = iteamService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<IteamDto> getItemById(@PathVariable("id") Long id) {
        IteamDto item = iteamService.getItemById(id);
        return ResponseEntity.ok(item);
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<IteamDto> updateItem(@PathVariable("id") Long id, @RequestBody IteamDto updatedItem) {
        IteamDto updated = iteamService.updateItem(id, updatedItem);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") Long id) {
        iteamService.deleteItem(id);
        return ResponseEntity.ok("Item " + id + " deleted");
    }
}
