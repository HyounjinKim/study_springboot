package com.khj.restapi03.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // findAll(),save(),findById()


    // select * from user where email = ?; 을 만들어줌
    public User findByEmail(String email);

//    public User findByUserName(String username);
}
