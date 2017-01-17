package com.allstate.repositories;

import com.allstate.entities.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface IInventoryRepository extends CrudRepository<Inventory,Integer>{
    public Inventory findByStockNumber(String stockNumber);

}