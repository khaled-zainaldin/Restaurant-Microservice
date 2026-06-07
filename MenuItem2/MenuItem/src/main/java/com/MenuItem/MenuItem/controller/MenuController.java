package com.MenuItem.MenuItem.controller;

import com.MenuItem.MenuItem.models.MenuItem;
import com.MenuItem.MenuItem.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {



        @Autowired
        private MenuItemService menuItemService;

        @GetMapping
        public ResponseEntity<List<MenuItem>> getItems() {

            List<MenuItem> items = menuItemService.getAll();

            return new ResponseEntity<>(items, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<MenuItem> getItemById(@PathVariable Long id) {

            MenuItem retrievedItem = menuItemService.getById(id);

            return new ResponseEntity<>(retrievedItem, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<MenuItem> addItem(@RequestBody MenuItem menuItem) {

            MenuItem newItem = menuItemService.create(menuItem);

            return new ResponseEntity<>(newItem, HttpStatus.CREATED);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<MenuItem> updateItem(
                @PathVariable Long id,
                @RequestBody MenuItem menuItem) {

            MenuItem updatedItem = menuItemService.update(id, menuItem);

            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteItem(@PathVariable Long id) {

            menuItemService.delete(id);

            return new ResponseEntity<>("Item deleted successfully", HttpStatus.OK);
        }
    }

