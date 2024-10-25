package com.luiscastillo.market.persistence.mapper;

import com.luiscastillo.market.domain.PurchaseDetail;
import com.luiscastillo.market.persistence.entity.DetalleCompra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseDetailMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")

    })
    PurchaseDetail toPurchaseDetail(DetalleCompra producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true)
    })
    DetalleCompra toDetalleCompra(PurchaseDetail item);
}
