package com.example.loginserver.domain.accountauth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountAuthRepository  extends JpaRepository<AccountAuth, Long>{

}
