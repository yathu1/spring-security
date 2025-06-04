package com.yathu.spring_boot_security.repository;

import com.yathu.spring_boot_security.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
