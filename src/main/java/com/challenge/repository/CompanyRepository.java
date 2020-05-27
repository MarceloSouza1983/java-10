package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT distinct c.id.company FROM Candidate c JOIN c.id.acceleration a WHERE a.id = :accelerationId")
    List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);

    @Query("SELECT c.id.company FROM Candidate c JOIN c.id.user u WHERE u.id = :userId")
    List<Company> findByUserId(@Param("userId") Long userId);

}