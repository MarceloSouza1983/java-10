package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    //Optional<User> findById(Long userId);

    @Query("SELECT u FROM User u JOIN FETCH u.candidates c WHERE c.id.acceleration.name = :name")
    List<User> findByAccelerationName(@Param("name") String name);

    @Query("SELECT u FROM User u JOIN FETCH u.candidates c WHERE c.id.company.id = :id")
    List<User> findByCompanyId(@Param("id") Long companyId);

}