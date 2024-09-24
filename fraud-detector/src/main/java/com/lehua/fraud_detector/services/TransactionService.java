package com.lehua.fraud_detector.services;

import com.lehua.common.dtos.TransactionDTO;
import com.lehua.fraud_detector.model.Transaction;
import com.lehua.fraud_detector.repositories.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

    private final TransactionRepository transactionRepository;

    private final TransactionMapper transactionMapper;

    public TransactionService(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    public void save(TransactionDTO transactionDTO) {

        Transaction transaction = transactionMapper.toTransaction(transactionDTO);

        /* Implement a Machine learning model to detect fraud */
        if (transaction.getAmount() <= 5000) {
            transactionRepository.save(transaction);
            LOGGER.info("Transaction approved and stored inside the Database: " + transaction.toString());
        } else {
            LOGGER.info("Fraud detected on transaction: " + transaction.toString());
            /* Implement a mechanism to handle frauds */
        }
    }

}
