package com.htp.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "sensors")
public class Sensors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String sensorsName;

    @Column
    private String model;

    @Column
    private int rangeFrom;

    @Column
    private int rangeTo;

    @Column
    private String type;

    @Column
    private String unit;

    @Column
    private String location;

    @Column
    private String description;
}
