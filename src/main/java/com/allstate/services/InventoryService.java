package com.allstate.services;

import com.allstate.entities.Inventory;
import com.allstate.repositories.IInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private IInventoryRepository repository;

    @Autowired
    public void setRepository(IInventoryRepository repository) {
        this.repository = repository;
    }

    public Inventory create(Inventory i){
        return this.repository.save(i);
    }

    public Inventory findById(int id){return this.repository.findOne(id);}

    public Iterable<Inventory> findAll(){
        return this.repository.findAll();
    }

    public Inventory findByStockNumber(String stockNumber){
        return this.repository.findByStockNumber(stockNumber);
    }

    public void delete(int id){
        this.repository.delete(id);
    }

    public Inventory update(int id, Inventory i){
        Inventory old = this.repository.findOne(id);
        old.setName(i.getName());
        old.setQuantity(i.getQuantity());
        old.setRating(i.getRating());
        old.setStockNumber(i.getStockNumber());
        old.setActualPrice(i.getActualPrice());
        old.setDiscount(i.getDiscount());
        return this.repository.save(old);
    }

}