package com.seq.login.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByUserId(String userId);
    Optional<Account> findByUserId(String userId);
}