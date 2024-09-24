package com.lehua.fraud_detector.model;

import com.lehua.common.enums.Concurrency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "approved_transactions")
public class Transaction {

    @Id
    private String id;

    @Column(name = "sender_account_id")
    private String senderAccountId;

    @Column(name = "receiver_account_id")
    private String receiverAccountId;

    private double amount;

    @Enumerated(EnumType.STRING)
    private Concurrency concurrency;

    private LocalDateTime timestamp;

    private String location;

}
