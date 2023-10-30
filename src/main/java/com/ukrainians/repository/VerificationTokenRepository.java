package com.ukrainians.repository;

import com.ukrainians.entity.UserInfoEntity;
import com.ukrainians.entity.VerificationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface VerificationTokenRepository extends JpaRepository<VerificationTokenEntity, String> {

    Optional<VerificationTokenEntity> findVerificationTokenEntitiesByToken(String token);
    Optional<VerificationTokenEntity> findVerificationTokenEntitiesByUserInfo (UserInfoEntity userInfo);

    @Modifying
    @Query("delete from VerificationTokenEntity ul WHERE ul.token =:token")
    void deleteByToken(@Param("token") String token);
}
