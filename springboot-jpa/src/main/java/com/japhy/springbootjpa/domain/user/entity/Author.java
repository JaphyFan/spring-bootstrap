package com.japhy.springbootjpa.domain.user.entity;

import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OrderBy;
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
 * @since 2022/9/23 17:08
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "author")
@ToString(callSuper = true)
@SQLDelete(sql = "update author set deleted = 1 where id = ?")
@Where(clause = "deleted = 0")
public class Author extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = -8290904103171210611L;

    private String name;

    /**
     * 使用Set在删除关联表数据时直接执行删除sql，而不用全删再添加。
     * <p>
     *     {@code @OrderBy} 可以指定排序
     * </p>
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @ToString.Exclude
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    @OrderBy("title desc")
    private Set<Book> books = Sets.newHashSet();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(
                o)) {
            return false;
        }
        Author author = (Author) o;
        return id != null && Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
