package com.khj.restapi04.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // findAll(),save(),findById()


    // select * from user where email = ?; 을 만들어줌
    public User findByEmail(String email);

    public User findByEmailAndPassword(String email,String password);

    public List<User> findByUsernameContainingOrEmailContaining(String username,String email);
}
