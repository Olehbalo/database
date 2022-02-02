package com.car.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "test_drive")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class TestDrive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "brand", length = 45, nullable = false)
    private String brand;


    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    private Car car;


    @Override
    public String toString() {
        return "\n\nTest drive: id: " + id + ", brand: "
                + brand + ", carId: " + car.getId()
                + "]";
    }
}

