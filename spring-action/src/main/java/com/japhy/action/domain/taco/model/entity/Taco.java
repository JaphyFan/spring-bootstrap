package com.japhy.action.domain.taco.model.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Japhy
 * @since 2020/7/6 15:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "taco")
public class Taco {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Date create;

    @NotBlank(message = "name cant be blank")
    private String name;

    @NotEmpty
    @Transient
    private List<String> ingredients;

    @PrePersist
    void createAt() {
        this.create = new Date();
    }

    @PreUpdate
    void updateAt() {
        this.create = new Date();
    }
}
