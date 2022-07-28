package com.example.PizzaApp.service;

import com.example.PizzaApp.dto.BillDto;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

public interface PaypalService {
    Payment createPayment(BillDto billDto,
                          String currency,
                          String cancelUrl,
                          String successUrl)throws PayPalRESTException;
    Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;
}
