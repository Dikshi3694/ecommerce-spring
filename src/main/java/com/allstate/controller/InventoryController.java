package com.allstate.controller;

import com.allstate.entities.Inventory;
import com.allstate.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/products")
public class InventoryController {
    private InventoryService service;

    @Autowired
    public void setService(InventoryService service) {
        this.service = service;
    }

    @RequestMapping(value ={"","/"}, method = RequestMethod.POST)
    public  Inventory create(@RequestBody Inventory inventory){
        return this.service.create(inventory);
    }
    @RequestMapping(value ={"/{id}"}, method = RequestMethod.GET)
    public  Inventory findById(@PathVariable int id){
        return this.service.findById(id);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Inventory> findAll(){
        return this.service.findAll();
    }



}
