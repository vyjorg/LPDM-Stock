package com.lpdm.msstock.Controller;

import com.lpdm.msstock.controller.StockController;
import com.lpdm.msstock.entity.Stock;
import com.lpdm.msstock.utils.ObjToJson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
public class StockControllerTest {

    private MockMvc mockMvc;

    @Mock
    private StockController stockController;

    private Stock stock;
    private List<Stock> stockList;

    @Before
    public void init(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(stockController).build();

        stock=new Stock();
        stock.setId(1);
        stock.setDescription("description");
        stock.setPackaging("packaging");
        stock.setQuantity(1);
        stock.setUnitByPackage(1);
        stock.setProductId(1);

        stockList = new ArrayList<Stock>();
        stockList.add(stock);
        stockList.add(stock);
    }

    @Test
    public void findStockByIdTest() throws Exception {
        Mockito.when(stockController.findStockById(1)).thenReturn(stock);

        mockMvc.perform(get("/stocks/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(ObjToJson.get(stock)));

        Mockito.verify(stockController, Mockito.times(1)).findStockById(1);
        Mockito.verifyNoMoreInteractions(stockController);
    }

    @Test
    public void listStockTest() throws Exception{
        Mockito.when(stockController.listStock()).thenReturn(stockList);

        mockMvc.perform(get("/stocks"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(ObjToJson.get(stockList)));

        Mockito.verify(stockController, Mockito.times(1)).listStock();
        Mockito.verifyNoMoreInteractions(stockController);

    }

    @Test
    public void deleteStockTest() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/stocks/1")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(ObjToJson.get(stock));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(print());
    }
}
