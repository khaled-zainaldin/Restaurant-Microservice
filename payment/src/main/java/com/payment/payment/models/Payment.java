package com.payment.payment.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Payment {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Double amount;

        private String method;

        private String status;

        private Long orderId;

}
