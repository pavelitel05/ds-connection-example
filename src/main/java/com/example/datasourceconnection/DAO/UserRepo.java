package com.example.datasourceconnection.DAO;

import com.example.datasourceconnection.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo {

    User getUserById(Long id);

    void addUser(User user);
}
