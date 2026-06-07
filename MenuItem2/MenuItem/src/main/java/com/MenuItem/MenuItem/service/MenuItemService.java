
package com.MenuItem.MenuItem.service;

import com.MenuItem.MenuItem.models.MenuItem;

import java.util.List;

public interface MenuItemService {


        List<MenuItem> getAll();
        MenuItem getById(Long id);
        MenuItem create(MenuItem menuItem);
        MenuItem update(Long id, MenuItem menuItem);
        void delete(Long id);

}