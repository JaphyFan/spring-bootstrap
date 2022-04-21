package com.japhy.springbootjpa.domain.user.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
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
public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = -5469016757179436385L;

    public AbstractEntity() {
        LocalDateTime now = LocalDateTime.now();
        this.creatTime = now;
        this.updateTime = now;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    protected Long id;

    @Version
    protected int version;

    @Column(columnDefinition = "tinyint(1) default 0")
    protected int deleted;

    @Column(name = "creat_time", nullable = false, columnDefinition = "TIMESTAMP")
    @CreatedDate
    protected LocalDateTime creatTime;

    @Column(name = "update_time", nullable = false, columnDefinition = "TIMESTAMP")
    @LastModifiedDate
    protected LocalDateTime updateTime;
}
