package com.japhy.springbootjpa.domain.user.entity;

import jakarta.persistence.Converter;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Japhy
 * @since 2021/12/21 16:04
 */
@MappedSuperclass
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity extends AbstractAggregateRoot<AbstractEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    protected Long id;

    @Version
    protected int version;

    @Column(columnDefinition = "tinyint(1) default 0")
    protected Boolean deleted;

    @Column(name = "creat_time", nullable = false, columnDefinition = "TIMESTAMP")
    @CreatedDate
    protected LocalDateTime creatTime;

    @Column(name = "update_time", nullable = false, columnDefinition = "TIMESTAMP")
    @LastModifiedDate
    protected LocalDateTime updateTime;

    public AbstractEntity() {
        this.deleted = false;
        this.version = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractEntity that = (AbstractEntity) o;
        return Objects.equals(id, that.id);
    }

}
