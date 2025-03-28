package com.anna.customer;


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
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {
    
    @Id
    @SequenceGenerator(
        name= "customer_id_sequence",
        sequenceName = "customer_id_sequence"
       
    )
    @GeneratedValue(
        strategy = jakarta.persistence.GenerationType.SEQUENCE ,
        generator = "customer_id_sequence"
    )
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
