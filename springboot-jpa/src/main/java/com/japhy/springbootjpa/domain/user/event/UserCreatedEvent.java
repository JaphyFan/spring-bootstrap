package com.japhy.springbootjpa.domain.user.event;

import com.japhy.springbootjpa.domain.user.entity.User;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Japhy
 * @since 2022/9/23 13:25
 */
@AllArgsConstructor
@Getter
public class UserCreatedEvent {

    private User user;

}
