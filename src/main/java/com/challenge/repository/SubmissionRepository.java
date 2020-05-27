package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    @Query("SELECT coalesce(max(s.score), 0) FROM Submission s JOIN s.id.challenge c WHERE c.id = :challengeId")
    BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query("SELECT distinct cid.submissions FROM Candidate c JOIN c.id.acceleration a JOIN a.challenge cid " +
            "WHERE a.id = :accelerationId AND cid.id = :challengeId")
    List<Submission> findByChallengeIdAndAccelerationId(
            @Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);

}