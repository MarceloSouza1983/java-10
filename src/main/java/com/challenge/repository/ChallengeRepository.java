package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    @Query("SELECT a.challenge FROM Candidate c JOIN c.id.user u JOIN c.id.acceleration a " +
            "WHERE a.id = :accelerationId AND u.id = :userId")
    List<Challenge> findByAccelerationIdAndUserId(
            @Param("accelerationId") Long accelerationId,
            @Param("userId") Long userId);

}