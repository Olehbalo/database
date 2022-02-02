package com.car.domain;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "site")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "car_dealership_id", referencedColumnName = "id", nullable = false)
    private CarDealership carDealership;
    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    private Car car;


    @Override
    public String toString() {
        return "\n\nSite: id: " + id + ", car Dealership Id: "
                + carDealership.getId() + ", car id: "
                + car.getId()
                + "]";
    }
}


