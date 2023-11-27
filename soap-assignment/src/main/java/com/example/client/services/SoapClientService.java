package com.example.client.services;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.client.wsimport.NumberConversionSoapType;


@Service
public class SoapClientService {

    @Autowired
    private NumberConversionSoapType numberConversionSoapType;

    public String convertNumberToWords(int number) {
        BigInteger ubiNum = BigInteger.valueOf(number);
        String response = numberConversionSoapType.numberToWords(ubiNum);
        return response;
    }

    public String convertNumberToDollars(double number) {
        BigDecimal bigDeci = BigDecimal.valueOf(number);
        String response = numberConversionSoapType.numberToDollars(bigDeci);
        return response;
    }
}
