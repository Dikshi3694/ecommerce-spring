package com.allstate.controller;

import com.allstate.entities.Inventory;
import com.allstate.services.InventoryService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(InventoryController.class)
public class InventoryControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private InventoryService service;

    private Inventory i;

    @Before
    public void setUp() throws Exception {

        i = new Inventory();
        i.setName("redmi");
        i.setVersion(0);
        i.setActualPrice(12000);
        i.setDiscount(10);
        i.setStockNumber("Note3");
    }

    @Test
    public void shouldCreateInventory() throws Exception {

        given(this.service.create(Mockito.any(Inventory.class)))
                .willReturn(i);

        MockHttpServletRequestBuilder request = post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"motorola\"}");

        this.mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(0)))
                .andExpect(jsonPath("$.name",is("redmi")));
    }

    @Test
    public void shouldNotCreateInventoryBadUrl() throws Exception {

        MockHttpServletRequestBuilder request = post("/productzzzzz");

        this.mvc.perform(request)
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void shouldFindById() throws Exception {

        given(this.service.findById(3))
                .willReturn(i);

        MockHttpServletRequestBuilder request = get("/products/3");

        this.mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(0)))
                .andExpect(jsonPath("$.name", is("redmi")));
    }

    @Test
    public void shouldNotFindProductByIdThatDoesNotExist() throws Exception {

        MockHttpServletRequestBuilder request = get("/products/7");

        this.mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(is("")));
    }

    @Test
    public void shouldFindAllProducts() throws Exception {

        Inventory i1 = new Inventory();
        Inventory i2 = new Inventory();
        i1.setName("Nirmal");
        i2.setName("madNirmal");
        List<Inventory> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);

        given(this.service.findAll()).willReturn((Iterable<Inventory>) list);

        MockHttpServletRequestBuilder request = get("/products");

        this.mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)));
    }
}