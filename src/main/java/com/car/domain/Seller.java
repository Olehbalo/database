package com.car.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "seller")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name", length = 45, nullable = false)
    private String firstName;

    @Column(name = "email", length = 45, nullable = false)
    private String email;

    @Column(name = "last_name", length = 45, nullable = false)
    private String lastName;

    @Column(name = "phone_number", length = 12, nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
    private Collection<Car> cars;
    @Override
    public String toString() {
        return "\n\nSeller: id: " + id + ", first name: "
                + firstName + ", email: " + email
                + ", last name: " + lastName
                + ", phone number: " + phoneNumber
                + "]";
    }
}


