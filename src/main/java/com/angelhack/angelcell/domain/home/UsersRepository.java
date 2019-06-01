package com.angelhack.angelcell.domain.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author seha
 * @date 2019-06-01
 */

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findAll();

    Users findUsersByNum(Long num);
}

