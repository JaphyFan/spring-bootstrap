package com.japhy.single.domain.account.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@ToString
/**
 * builder need a allArgsConstructor
 */
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nickName;

    private String phone;

    private String avatar;

}
