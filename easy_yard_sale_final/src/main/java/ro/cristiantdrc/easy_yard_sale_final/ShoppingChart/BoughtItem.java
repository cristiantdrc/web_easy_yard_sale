package ro.cristiantdrc.easy_yard_sale_final.ShoppingChart;

import org.springframework.beans.factory.annotation.Autowired;
import ro.cristiantdrc.easy_yard_sale_final.Items.Item;
import ro.cristiantdrc.easy_yard_sale_final.Users.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BoughtItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int itemId;
    private int quantity;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
