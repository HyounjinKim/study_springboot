package com.firstproject.project.project.friend;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend,Long> {

    @Query("SELECT friendnick FROM Friend WHERE membernick = :membernick AND approve = 'Y'")
    List<String> findFriendList(@Param("membernick") String membernick);

    @Query("SELECT membernick FROM Friend WHERE friendnick = :friendnick AND approve = 'I'")
    List<String> findBerequestList(@Param("friendnick") String friendnick);

    @Query("select m from Friend m where membernick = :friendnick and friendnick = :membernick")
    Friend acceptFriend(@Param("membernick") String membernick,@Param("friendnick") String friendnick);

    @Query("select nickname from User where nickname = :friendnick")
    String findFriend(@Param("friendnick") String friendnick);

    @Query("select m from Friend m where membernick = :membernick and friendnick = :friendnick")
    Friend findDeleteFriend(@Param("membernick") String membernick,@Param("friendnick") String friendnick);
}
