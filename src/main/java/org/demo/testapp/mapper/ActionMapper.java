package org.demo.testapp.mapper;

import org.demo.testapp.dto.ActionDto;
import org.demo.testapp.model.Action;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActionMapper {
    ActionDto toDto(Action action);

    Action toEntity(ActionDto dto);

    List<Action> toDtoList(List<Action> actions);

}
