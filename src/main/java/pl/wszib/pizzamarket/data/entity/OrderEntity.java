package pl.wszib.pizzamarket.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue
    @Column(name = "")
    private Long id;
    @Column(name = "pizza_name")
    private String pizzaName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_adress_id")
    private OrderAdresEntity orderAdress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public OrderAdresEntity getOrderAdress() {
        return orderAdress;
    }

    public void setOrderAdress(OrderAdresEntity orderAdress) {
        this.orderAdress = orderAdress;
    }
}
