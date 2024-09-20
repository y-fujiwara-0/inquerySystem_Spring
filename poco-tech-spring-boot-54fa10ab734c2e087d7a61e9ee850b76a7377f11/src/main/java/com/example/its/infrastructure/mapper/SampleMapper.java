package com.example.its.infrastructure.mapper;

import com.example.its.domain.model.sample.Sample;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SampleMapper {

	Sample toModel(com.example.its.infrastructure.entity.Sample entity);

	List<Sample> toModel(List<com.example.its.infrastructure.entity.Sample> entities);
}
