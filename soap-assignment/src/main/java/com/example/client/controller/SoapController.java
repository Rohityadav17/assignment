package com.example.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.services.SoapClientService;

@RestController
@RequestMapping("/soap")
public class SoapController {

    @Autowired
    private SoapClientService soapClientService;

    @GetMapping("/word/{number}")
    public String convertNumberToWords(@PathVariable int number) {
        return soapClientService.convertNumberToWords(number);
    }
    
    @GetMapping("/dollars/{number}")
    public String convertNumberToDollars(@PathVariable double number) {
        return soapClientService.convertNumberToDollars(number);
    }
}

