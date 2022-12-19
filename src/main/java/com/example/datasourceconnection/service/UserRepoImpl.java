package com.example.datasourceconnection.service;

import com.example.datasourceconnection.DAO.UserRepo;
import com.example.datasourceconnection.domain.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class UserRepoImpl implements UserRepo {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }
}
