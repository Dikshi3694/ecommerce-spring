package com.allstate.services;

import com.allstate.entities.Inventory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class InventoryServiceTest {
    @Autowired
    private  InventoryService service;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateInventory() throws Exception{
        Inventory before = new Inventory();
        before.setName("redmi");
        Inventory after = this.service.create(before);
        assertEquals("redmi",after.getName());
    }

    @Test
    public void shouldFindById() throws Exception {
        Inventory before = new Inventory();
        before.setName("redmi");
        this.service.create(before);
        Inventory after = this.service.findById(1);
        assertNotNull(after);
    }

    @Test
    public void shouldFindAll() throws Exception {
        ArrayList<Inventory> i = (ArrayList<Inventory>) this.service.findAll();
        assertEquals(1, i.size());
    }

    @Test
    public void shouldFindByStockNumber() throws Exception {
        Inventory before = new Inventory();
        before.setName("redmi");
        before.setStockNumber("12");
        this.service.create(before);
        Inventory after = this.service.findByStockNumber("12");
        assertNotNull(after);
    }

    @Test
    public void shouldDeleteById() throws Exception {
        this.service.delete(1);
        Inventory result = this.service.findById(1);
        assertNull(result);
    }

    @Test
    public void shouldUpdateInventory() throws Exception {
       Inventory i = this.service.findById(1);
        i.setQuantity(1);
        i.setActualPrice(100000);
        i.setDiscount(10);
        i.setStockNumber("6s");
        Inventory after= this.service.update(1,i);
        assertEquals(1,after.getQuantity());
        assertEquals("iphone",after.getName());
        assertEquals(100000,after.getActualPrice());
        assertEquals(10,after.getDiscount());
        assertEquals("6s",after.getStockNumber());

    }
}