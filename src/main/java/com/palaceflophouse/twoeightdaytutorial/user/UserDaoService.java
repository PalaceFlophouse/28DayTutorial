package com.palaceflophouse.twoeightdaytutorial.user;

import com.palaceflophouse.twoeightdaytutorial.user.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Brandon Shaffer
 * 8/22/2025
 */
@Component
public class UserDaoService {

    //findaAll
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Brandon", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Jane", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Terry", LocalDate.now().minusYears(35)));
    }

    public List<User> findAll(){
        return users;
    }

    //save user
    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    //findOne
    public User findOne(Integer id){
        return users.stream().filter(u -> id.equals(u.getId())).findAny().orElse(null);
    }

    public void deleteById(Integer id) {
        users.removeIf(u -> id.equals(u.getId()));
    }
}