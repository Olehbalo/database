package com.car.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "car_dealership")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class CarDealership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "site", length = 45, nullable = false)
    private String site;

    @Column(name = "email", length = 45, nullable = false)
    private String email;


    @ManyToOne
    @JoinColumn(name = "car_Id", referencedColumnName = "id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "addres_id", referencedColumnName = "id", nullable = false)
    private Addres addres;

    @OneToMany(mappedBy = "carDealership", fetch = FetchType.LAZY)
    private Collection<Site> sites;


    @Override
    public String toString() {
        return "\n\n:Car Dealership  id: " + id
                + ", site: " + site + ", email: "
                + email +", car id: "
                + car.getId() + ", addres id: "
                +addres.getId()
                + "]";
    }
}




