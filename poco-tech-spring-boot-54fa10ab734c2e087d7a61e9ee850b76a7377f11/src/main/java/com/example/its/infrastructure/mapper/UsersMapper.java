package com.example.its.infrastructure.mapper;

import com.example.its.common.domain.SampleType;
import com.example.its.domain.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    Users toModel(com.example.its.infrastructure.entity.Users entity);

    //List<Users> toModel(List<com.example.its.infrastructure.entity.Users> entities);

    Users mapToDomain(com.example.its.infrastructure.entity.Users entity);

    //Users mapToEntity(com.example.its.infrastructure.entity.Users entity);

//    @Mapping(target = "userId", source = "users.userId")
    default com.example.its.infrastructure.entity.Users mapToEntity(Users users) {

        String authority;
        // users.getAuthority()がADMIN等の値の場合
        if (users.getAuthority().equals(SampleType.SAMPLE_1.getName())) {
            // 列挙定数のnameと同一だったら 列挙定数のid=1を代入
            authority = SampleType.SAMPLE_1.getValue().toString();
        }
        else {
            // 列挙定数のnameと同一ではなかったら それ以外の列挙定数のid=2を代入
            authority = SampleType.SAMPLE_2.getValue().toString();
        }
        //取得したauthorityをentityにセットしてentityのインスタンスを作成
		return new com.example.its.infrastructure.entity.Users(
                users.getUserId(),
                users.getUsername(),
                users.getPassword(),
                authority,
                users.getIsDeleted(),
                users.getCreatedAt(),
                users.getUpdatedAt()
        );
    }
}



