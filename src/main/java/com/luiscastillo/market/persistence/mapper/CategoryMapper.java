package com.luiscastillo.market.persistence.mapper;

import com.luiscastillo.market.domain.Category;
import com.luiscastillo.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target ="categoryId"),
            @Mapping(source = "descripcion", target ="categoryName"),
            @Mapping(source = "estado", target ="active")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    //Como no mapeamos la lista de productos definida en la entidad Categoria, con esto le indicamos que no va a recibir esa lista y que la ignore
    @Mapping(target="productos", ignore = true)
    Categoria toCategoria(Category category);
}
