package com.japhy.springbootjpa.domain.user.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * @author Japhy
 * @since 2021/12/21 16:04
 */
@MappedSuperclass
public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = -5469016757179436385L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    protected Long id;

    @Version
    protected int version;

    @Column(name = "creat_time", nullable = false)
    protected LocalDateTime creatTime;

    @Column(name = "update_time", nullable = false)
    protected LocalDateTime updateTime;

    public AbstractEntity() {
        this.creatTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
    }
}
