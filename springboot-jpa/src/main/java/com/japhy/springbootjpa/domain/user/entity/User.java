package com.japhy.springbootjpa.domain.user.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Japhy
 * @date 2019/12/19 10:59
 */
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@Entity
/**
 * builder need a allArgsConstructor
 */
@Builder
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nickName;

    private String phone;

    private String avatar;

    @Column(columnDefinition = "TIME")
    private LocalTime localTime;

    @Column(columnDefinition = "DATE")
    private LocalDate localDate;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;

}
