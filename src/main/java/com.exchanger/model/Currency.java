package com.exchanger.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(name = "currency_gen", sequenceName = "currency_generator", allocationSize = 1, schema = "public", catalog = "postgres")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currency_gen")
    Long id;
    String data;

    @Column(name = "time_creation")
    LocalDateTime timeCreation;
}
