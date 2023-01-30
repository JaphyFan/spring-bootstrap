package com.japhy.springbootjpa.domain.user.entity;

import com.google.common.collect.Sets;
import java.util.Objects;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
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

/**
 * @author Japhy
 * @since 2022/9/23 17:06
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
@ToString(callSuper = true)
@SQLDelete(sql = "update book set deleted = 1 where id = ?")
@Where(clause = "deleted = 0")
public class Book extends AbstractEntity {

    private String title;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    @ToString.Exclude
    private Set<Author> authors = Sets.newConcurrentHashSet();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(
                o)) {
            return false;
        }
        Book book = (Book) o;
        return id != null && Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
