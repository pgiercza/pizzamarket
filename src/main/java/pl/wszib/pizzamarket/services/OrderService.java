package pl.wszib.pizzamarket.services;

import org.springframework.stereotype.Service;
import pl.wszib.pizzamarket.data.entity.OrderAdresEntity;
import pl.wszib.pizzamarket.data.entity.OrderEntity;
import pl.wszib.pizzamarket.data.entity.PizzaEntity;
import pl.wszib.pizzamarket.data.repositories.OrderRepository;
import pl.wszib.pizzamarket.data.repositories.PizzaRepository;
import pl.wszib.pizzamarket.web.mappers.OrderAddressMapper;
import pl.wszib.pizzamarket.web.models.OrderAddressModel;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class OrderService {
    private final PizzaRepository pizzaRepository;
    private final OrderRepository orderRepository;

    public OrderService(PizzaRepository pizzaRepository, OrderRepository orderRepository) {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
    }


    @Transactional
    public void saveOrder(Long pizzaId, OrderAddressModel orderAddressModel) {
        OrderAdresEntity orderAddressEntity = OrderAddressMapper.toEntity(orderAddressModel);
        PizzaEntity pizzaEntity = pizzaRepository.findById(pizzaId).orElseThrow(EntityNotFoundException::new);
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setPizzaName(pizzaEntity.getName());
        orderEntity.setOrderAdress(orderAddressEntity);
        orderRepository.save(orderEntity);


    }
}
