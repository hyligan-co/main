package com.ukrainians.repository;

import com.ukrainians.dto.UserInfoRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<UserInfoRequest, Long> {
    boolean existsUserInfoRequestByNickName(String userName);
    boolean existsUserInfoRequestByEmail(String email);
}
