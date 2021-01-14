package com.japhy.hateoas.api.assembler;

import com.japhy.hateoas.api.UserApi;
import com.japhy.hateoas.model.entity.User;
import com.japhy.hateoas.model.enums.Status;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Japhy
 * @since 2021/1/12 12:21
 */
@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {

    @Override
    public EntityModel<User> toModel(User entity) {

        EntityModel<User> userEntityModel = EntityModel.of(entity,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserApi.class).one(entity.getId()))
                .withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserApi.class).all())
                .withRel("users"));

        if (entity.getStatus() == Status.CREATED) {
            // 直接指定rel的值为枚举，客户端直接根据rel值获取 或者 客户端需要维护一份状态表
            //FIXME:  japhy 2021/1/12
            userEntityModel.add(WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(UserApi.class)
                    .changeStatus(entity.getId(), Status.DELETED)).withRel(Status.DELETED.toString()));
            userEntityModel.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(UserApi.class)
                    .changeStatus(entity.getId(), Status.AUTHORIZED)).withRel(Status.AUTHORIZED.toString()));
        }
        return userEntityModel;
    }
}
