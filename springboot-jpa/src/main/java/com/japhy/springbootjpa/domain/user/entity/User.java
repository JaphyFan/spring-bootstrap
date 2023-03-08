package com.japhy.springbootjpa.domain.user.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
public class User extends AbstractEntity {

    public User() {
        super();
    }

    @ToString.Include
    private String name;

    private String nickName;

    private String phone;

    private String avatar;
//
//    @ToString.Exclude
//    private Set<Address> addressSet;

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


}
