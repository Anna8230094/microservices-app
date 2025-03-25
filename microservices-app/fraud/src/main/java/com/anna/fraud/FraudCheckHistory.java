package com.anna.fraud;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
@Builder
public class FraudCheckHistory {
    
    @Id
    @SequenceGenerator(
        name= "fraud_id_sequence",
        sequenceName = "fraud_id_sequence"
    )
    @GeneratedValue(
        strategy = jakarta.persistence.GenerationType.SEQUENCE ,
        generator = "fraud_id_sequence"
    )
    private Integer id;
    private  Integer customerId;
    private boolean isFraudster;
    private LocalDateTime createdAt;
}

