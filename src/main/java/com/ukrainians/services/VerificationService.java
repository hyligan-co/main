package com.ukrainians.services;

import com.ukrainians.dto.UserInfoResponse;
import com.ukrainians.entity.UserInfoEntity;
import com.ukrainians.entity.VerificationTokenEntity;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface VerificationService {

    Optional<VerificationTokenEntity> findByToken(String token);

    Optional<VerificationTokenEntity> findByUserInfo(UserInfoEntity userInfo);

    void save(String token, UserInfoEntity userInfo);

    UserInfoResponse verifyToken(String token, HttpServletRequest request);

    UserInfoResponse validateToken(String token, HttpServletRequest request);
}
