package com.valcon.videotechatodor.repository;

import com.valcon.videotechatodor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
