package ro.cristiantdrc.easy_yard_sale_final.Users;

import org.springframework.data.repository.CrudRepository;

import javax.naming.Reference;


public interface UserRepository extends CrudRepository <User, Integer> {
    public User findByUsername(String username);
    public User findByType(String userType);

}
