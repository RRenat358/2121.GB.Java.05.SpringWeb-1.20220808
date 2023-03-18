package ru.titov.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import ru.titov.model.User;
import ru.titov.model.dto.UserDto;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserDtoMapper {

    @Mapping(target = "password", ignore = true)
    UserDto map(User user);

    @Mapping(target = "id", ignore = true)
    User map(UserDto dto);

}
