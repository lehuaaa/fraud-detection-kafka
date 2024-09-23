package com.lehua.transaction_api;


import com.lehua.common.dtos.TransactionDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {

    private final TransactionsProducer transactionsProducer;

    public TransactionsController(TransactionsProducer transactionsProducer) {
        this.transactionsProducer = transactionsProducer;
    }

    @PostMapping
    public ResponseEntity<String> publishTransaction(@Valid @RequestBody TransactionDTO transaction) {
        transactionsProducer.sendMessage(transaction);
        return new ResponseEntity<>("Transaction successfully published", HttpStatus.CREATED);
    }
}