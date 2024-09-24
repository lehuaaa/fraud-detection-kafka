package com.lehua.fraud_detector.services;

import com.lehua.common.model.TransactionDto;
import com.lehua.fraud_detector.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionMapper {

    public Transaction toTransaction(TransactionDto transactionDto) {

        if (transactionDto == null)
            throw new NullPointerException("transactionDTO is null");

        return Transaction.builder()
                .id(transactionDto.getId())
                .senderAccountId(transactionDto.getSenderAccountId())
                .receiverAccountId(transactionDto.getReceiverAccountId())
                .amount(transactionDto.getAmount())
                .concurrency(transactionDto.getConcurrency())
                .timestamp(transactionDto.getTimestamp())
                .location(transactionDto.getLocation())
                .build();
    }
}
