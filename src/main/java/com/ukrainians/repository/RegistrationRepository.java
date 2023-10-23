package com.ukrainians.repository;

import com.ukrainians.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<UserInfoEntity, Long> {

    @Query("select ul.nickName from UserInfoEntity ul WHERE ul.nickName =:nickName")
    Optional<String> existsByNickName(String nickName);

    @Query("select ul.email from UserInfoEntity ul WHERE ul.email =:email")
    Optional<String> existsByEmail(String email);
}
