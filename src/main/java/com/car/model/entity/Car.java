package com.car.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "car")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "brand", length = 45, nullable = false)
    private String brand;

    @Column(name = "graduathion_year")
    private Integer graduathionYear ;

    @Column(name = "ser_num")
    private Integer serNum ;

    @Column(name = "is_new", length = 3, nullable = false)
    private String isNew ;

    @Column(name = "is_sold", length = 3, nullable = false)
    private String isSold;


    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "id", nullable = false)
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable = false)
    private Seller seller;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private Collection<CarDealership> carDealership;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private Collection<CarType> carTypes;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private Collection<Characteristic> characteristics;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private Collection<TestDrive> testDrives;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private Collection<Site> sites;

    @Override
    public String toString() {
        return "\n\n Car id: " + id + ", brand: "
                + brand + ", graduathionYear: " + graduathionYear
                + ", serNum" + serNum+ ", isNew: "
                + isNew +", isSold: "+ isSold
                + ", commentId: " + comment.getId()
                + ", sellerId: " + seller.getId()
                + "]" + "\n";
    }
}

