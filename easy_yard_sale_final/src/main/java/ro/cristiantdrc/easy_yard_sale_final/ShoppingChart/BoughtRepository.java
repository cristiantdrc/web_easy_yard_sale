package ro.cristiantdrc.easy_yard_sale_final.ShoppingChart;

import org.springframework.data.repository.CrudRepository;
import ro.cristiantdrc.easy_yard_sale_final.Items.Item;

import java.util.Optional;

public interface BoughtRepository extends CrudRepository<BoughtItem, Integer> {

    }
