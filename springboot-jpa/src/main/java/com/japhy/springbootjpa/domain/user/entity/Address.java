package com.japhy.springbootjpa.domain.user.entity;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * @author Japhy
 * @since 2021/7/16 13:08
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "address")
@ToString(callSuper = true)
@SQLDelete(sql = "update address set deleted = 1 where id = ?")
@Where(clause = "deleted = 0")
public class Address extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 601415684846777852L;

    private String city;


    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "user_id")
    private User user;

    public Address() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(
                o)) {
            return false;
        }
        Address address = (Address) o;
        return id != null && Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
