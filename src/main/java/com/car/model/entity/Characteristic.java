package com.car.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "characteristic")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Characteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "drive", length = 45, nullable = false)
    private String drive;

    @Column(name = "color", length = 45, nullable = false)
    private String color;

    @Column(name = "car_body", length = 45, nullable = false)
    private String carBody;

    @Column(name = "transmission", length = 45, nullable = false)
    private String transmission;


    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    private Car car;


    @Override
    public String toString() {
        return "\n\nCharacteristic: id: " + id + ", drive: "
                + drive + ", color: " + color + ", carBody: " + carBody
                + " transmission :"+ transmission +" carId: " +car.getId()
                + "]";
            }


        }


