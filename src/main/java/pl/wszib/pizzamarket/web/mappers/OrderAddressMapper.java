package pl.wszib.pizzamarket.web.mappers;

import pl.wszib.pizzamarket.data.entity.OrderAdresEntity;
import pl.wszib.pizzamarket.web.models.OrderAddressModel;

public class OrderAddressMapper {
    public static OrderAdresEntity toEntity(OrderAddressModel model) {
        OrderAdresEntity entity=new OrderAdresEntity();
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setStreet(model.getStreet());
        entity.setCity(model.getCity());
        entity.setPostalCode(model.getPostalCode());
        return entity;


    }
}
