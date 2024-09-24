package com.lehua.transaction_api.controllers;


import com.lehua.common.dtos.TransactionDTO;
import com.lehua.transaction_api.services.TransactionProducer;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionProducer transactionProducer;

    public TransactionController(TransactionProducer transactionProducer) {
        this.transactionProducer = transactionProducer;
    }

    @PostMapping
    public ResponseEntity<String> publishTransaction(@Valid @RequestBody TransactionDTO transaction) {
        transactionProducer.sendMessage(transaction);
        return new ResponseEntity<>("Transaction successfully published", HttpStatus.CREATED);
    }
}