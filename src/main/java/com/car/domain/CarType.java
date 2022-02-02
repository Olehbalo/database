package com.car.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "car_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class CarType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type", length = 45, nullable = false)
    private String type;


    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    private Car car;

    @Override
    public String toString() {
        return "\n\nCar Type: id: " + id + ", type: "
                + type + ", carId: " + car.getId()
                + "]";
    }
}