package org.example.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name="drivers")
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="license_number")
    private String licenseNumber;

    @OneToOne(mappedBy = "driver")
    private Car currentCar;

}