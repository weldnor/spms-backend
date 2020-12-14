package com.weldnor.spms.mapper;

import java.util.ArrayList;
import java.util.List;

public interface Mapper<E, D> {
    E toEntity(D dto);

    default List<E> toEntity(List<D> dtoList) {
        List<E> result = new ArrayList<>();
        for (D dto : dtoList) {
            result.add(toEntity(dto));
        }
        return result;
    }

    D toDto(E entity);

    default List<D> toDto(List<E> entityList) {
        List<D> result = new ArrayList<>();
        for (E entity : entityList) {
            result.add(toDto(entity));
        }
        return result;
    }

}
