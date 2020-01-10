package com.japhy.single.domain.order.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author Japhy
 * @date 2019/12/19 11:24
 */
@Entity
@NoArgsConstructor
@Data(staticConstructor = "of")
@Table(name = "`order`")
public class Order {

    @Id
    @GenericGenerator(name = "no_uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "no_uuid")
    @Column(unique = true)
    private UUID uuid;

}
