package com.MenuItem.MenuItem.service;

import com.MenuItem.MenuItem.Repository.MenuItemRepository;
import com.MenuItem.MenuItem.models.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service

public class MenuItemServiceImpl implements MenuItemService{
    @Autowired
    private MenuItemRepository repository;

    @Override
    public List<MenuItem> getAll() {
        return repository.findAll();
    }

    public MenuItem getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "MenuItem not found with id: " + id
                ));
    }

    @Override
    public MenuItem create(MenuItem menuItem) {
        return repository.save(menuItem);
    }

    @Override
    public MenuItem update(Long id, MenuItem menuItem) {
        MenuItem existing = getById(id);

        MenuItem updated = existing.toBuilder()
                .name(menuItem.getName())
                .description(menuItem.getDescription())
                .price(menuItem.getPrice())
                .build();

        return repository.save(updated);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
