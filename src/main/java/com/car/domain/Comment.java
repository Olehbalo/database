package com.car.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "comment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nickname", length = 45, nullable = false)
    private String nickname;

    @Column(name = "message", length = 45, nullable = false)
    private String message;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "comment", fetch = FetchType.EAGER)
    private Collection<Car> cars;

    @Override
    public String toString() {
        return "\n\nComment: id: " + id + ", nickname: " + nickname + ", message: "
                + message + ",  customer id "+
                customer.getId() + "]";
    }
}
