package one.digitalinnovation.personapi.mapear;

import one.digitalinnovation.personapi.dto.request.JobDTO;
import one.digitalinnovation.personapi.entity.Job;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface JobMapper {
    JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);

    @Mapping(target = "salaryJob", source = "salaryJob", numberFormat = "$#.00")
    Job toModel(JobDTO jobDTO);

    JobDTO toDTO(Job job);
}
