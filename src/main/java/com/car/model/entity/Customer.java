package com.car.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name", length = 45, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 45, nullable = false)
    private String lastName;

    @Column(name = "email", length = 45, nullable = false)
    private String email;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Collection<Comment> comments;


    @Override
    public String toString() {
        return "\n\nCustomer: id: " + id + ", first_name: " + firstName + ", last name: " + lastName
                +", email"+ email
                + "]";
    }
}
