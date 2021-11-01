package one.digitalinnovation.studentapi.mapper;

import one.digitalinnovation.studentapi.dto.request.StudentDTO;
import one.digitalinnovation.studentapi.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

@Mapper
public interface StudentMapper {

        StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

        @Mapping(target = "birthDate", source = "birthDate",
        dateFormat = "dd-MM-yyyy")
        Student toModel(StudentDTO studentDTO);

        StudentDTO toDTO(Student student);
}
