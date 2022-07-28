package com.example.PizzaApp.service;

import com.example.PizzaApp.dto.BillDto;
import com.example.PizzaApp.model.BillDetail;
import com.example.PizzaApp.model.Product;
import com.example.PizzaApp.repository.ProductRepository;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaypalServiceImpl implements PaypalService {

    @Autowired
    private APIContext apiContext;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Payment createPayment(BillDto billDto,
                                 String currency,
                                 String cancelUrl,
                                 String successUrl) throws PayPalRESTException {

        Amount amount = new Amount();
        amount.setCurrency(currency);
        amount.setTotal(billDto.getTotalPrice().toString());

        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<>();

        Transaction transaction = new Transaction();

        transaction.setDescription("transaction description");
        transaction.setAmount(amount);

        List<Transaction> transactions = new ArrayList<>();
        for(BillDetail detail : billDto.getBillDetails()){
            Item item = new Item();
            Product product = productRepository.findProductById(detail.getProductId());
            item.setCurrency("USD");
            item.setName(product.getName());
            item.setPrice(String.valueOf((product.getBasePrice()*detail.getQuantity())));
            item.setQuantity(String.valueOf(detail.getQuantity()));
            items.add(item);
        }
        itemList.setItems(items);
        transaction.setItemList(itemList);

        transactions.add(transaction);




        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        Payment payment = new Payment();
        payment.setIntent("authorize");
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(successUrl);
        payment.setRedirectUrls(redirectUrls);


        return payment.create(apiContext);
    }

    @Override
    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException{
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecute);
    }
}
