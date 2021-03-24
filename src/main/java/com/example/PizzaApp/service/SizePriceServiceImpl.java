package com.example.PizzaApp.service;

import com.example.PizzaApp.model.SizePrice;
import com.example.PizzaApp.repository.SizePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizePriceServiceImpl implements SizePriceService {

    @Autowired
    private SizePriceRepository sizePriceRepository;

    @Override
    public List<SizePrice> getAllSizePrice() {
        List<SizePrice> sizePriceList = sizePriceRepository.findAll();
        return sizePriceList;
    }
}
