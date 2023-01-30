package com.japhy.cloud.user.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Japhy
 * @since 2022/1/18 10:33
 */
@Builder
@Table(name = "user")
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Version
        private int version;

        private String name;

        @Column(name = "nick_name")
        private String nickName;

        private String phone;

        private Integer age;

}
