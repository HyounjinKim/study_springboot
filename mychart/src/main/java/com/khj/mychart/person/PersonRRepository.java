package com.khj.mychart.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRRepository extends JpaRepository<Person,Long> {
}
