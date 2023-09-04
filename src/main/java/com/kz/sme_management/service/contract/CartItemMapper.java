package com.kz.sme_management.service.contract;

import com.kz.sme_management.model.contract.CartItem;
import com.kz.sme_management.model.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CartItemMapper {

    public static final CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);

    @Mapping(source = "brand.name", target = "brand")
    @Mapping(source = "category.name", target = "category")
    @Mapping(source = "type.name", target = "type")
    @Mapping(source = "size.name", target = "size")
    @Mapping(source = "id", target = "id", ignore = true)
    public abstract CartItem toCartItem(Product cartItemDto);
}
