package com.example.its.infrastructure.mapper;

import com.example.its.domain.model.Inquery;
import com.example.its.infrastructure.entity.Inquerys;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InquerysMapper {

    Inquery mapToDomain(com.example.its.infrastructure.entity.Inquerys entity);

    default Inquerys mapToEntity(Inquery inquery) {
        if (inquery == null) {
            return null;
        }

        Inquerys entity = new Inquerys(
        inquery.getInqueryId(),
        inquery.getMailAddress(),
        inquery.getName(),
        inquery.getAge(),
        inquery.getAddress(),
        inquery.getClassification(),
        inquery.getRegistrationAt(),
                inquery.getReplyAt(),
        inquery.getIsReaded(),
        inquery.getContent(),
        inquery.getCreatedAt(),
        inquery.getUpdatedAt()
);
        return entity;
    }
}
