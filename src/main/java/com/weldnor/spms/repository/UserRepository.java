package com.weldnor.spms.repository;

import com.weldnor.spms.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    Optional<User> findByUserId(long id);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    void deleteByUserId(long id);

    @Query(value = "SELECT count(ugr) from users_global_roles ugr WHERE global_role_id = 2", nativeQuery = true)
    long getAdminsCount();
}
