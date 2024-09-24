package com.example.its.infrastructure.mapper;

import com.example.its.domain.model.sample.Sample;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface SampleMapper {

	Sample toModel(com.example.its.infrastructure.entity.Sample entity);

	//Optional<Sample> toModel(List<com.example.its.infrastructure.entity.Sample> entities);
}
