package com.lehua.fraud_detector.services;

import com.lehua.common.dtos.TransactionDTO;
import com.lehua.fraud_detector.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionMapper {

    public Transaction toTransaction(TransactionDTO transactionDTO) {

        if (transactionDTO == null)
            throw new NullPointerException("transactionDTO is null");

        return Transaction.builder()
                .id(transactionDTO.getId())
                .senderAccountId(transactionDTO.getSenderAccountId())
                .receiverAccountId(transactionDTO.getReceiverAccountId())
                .amount(transactionDTO.getAmount())
                .concurrency(transactionDTO.getConcurrency())
                .timestamp(transactionDTO.getTimestamp())
                .location(transactionDTO.getLocation())
                .build();
    }
}
