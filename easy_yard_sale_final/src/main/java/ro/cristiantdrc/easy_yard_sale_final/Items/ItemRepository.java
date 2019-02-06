package ro.cristiantdrc.easy_yard_sale_final.Items;

import org.springframework.data.repository.CrudRepository;
import ro.cristiantdrc.easy_yard_sale_final.Users.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.List;

public interface ItemRepository extends CrudRepository <Item, Integer> {
    public Item findByPrice(BigDecimal price);
    public List<Item> findByCategory(String category);

}