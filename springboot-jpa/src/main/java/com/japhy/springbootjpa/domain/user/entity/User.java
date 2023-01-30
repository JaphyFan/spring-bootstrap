package com.japhy.springbootjpa.domain.user.entity;

import com.japhy.springbootjpa.domain.user.event.UserCreatedEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.domain.DomainEvents;

/**
 * @author Japhy
 * @date 2019/12/19 10:59
 */
@AllArgsConstructor
@Entity
/**
 * builder need a allArgsConstructor
 */
@Builder
@Table(name = "user")
@Getter
@Setter
@ToString(callSuper = true)
@SQLDelete(sql = "update user set deleted = 1 where id = ? and version = ?")
@Where(clause = "deleted = 0")
@NoArgsConstructor
public class User extends AbstractEntity {

    @ToString.Include
    private String name;

    private String nickName;

    private String phone;

    private String avatar;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    @ToString.Exclude
    private List<Address> addresses;

    @Column(columnDefinition = "TIME")
    private LocalTime localTime;

    @Column(columnDefinition = "DATE")
    private LocalDate localDate;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(
                o)) {
            return false;
        }
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @DomainEvents
    public void registerAddressEvent() {
        registerEvent(new UserCreatedEvent(this));
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address) {
        address.setUser(null);
        this.addresses.remove(address);
    }

}
