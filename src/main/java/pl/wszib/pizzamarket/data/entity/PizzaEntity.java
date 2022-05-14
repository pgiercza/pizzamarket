package pl.wszib.pizzamarket.data.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name="pizzas")
public class PizzaEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private BigDecimal price;
    @ManyToMany
    @JoinTable(name = "pizza_ingredients",joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name="ingredient_id"))

    private Set<IngredientsEntity> ingredients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<IngredientsEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientsEntity> ingredients) {
        this.ingredients = ingredients;
    }
}
