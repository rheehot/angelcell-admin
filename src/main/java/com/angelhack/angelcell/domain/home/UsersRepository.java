package com.angelhack.angelcell.domain.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT COUNT(u) " +
            "FROM Users u " +
            "WHERE u.groupId = :groupId")
    int getUserCountByGroupId(@Param("groupId")Long groupId);
}

