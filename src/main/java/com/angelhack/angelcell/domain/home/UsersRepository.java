package com.angelhack.angelcell.domain.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    List<Users> findAllByGroupId(Long groupId);

    @Query("SELECT COUNT(u) " +
            "FROM Users u " +
            "WHERE u.hpno = :hpno")
    int findUsersByHpno(@Param("hpno")String hpno);

    void deleteByHpno(String hpno);

    @Modifying
    @Query("UPDATE Users u SET " +
            "u.groupId = :groupId, " +
            "u.battery = :battery, " +
            "u.connectedHost = :connectedHost, " +
            "u.latitude = :latitude, " +
            "u.logitude = :logitude," +
            "u.myHost = :myHost " +
            "WHERE u.hpno = :hpno")
    int modUserData(@Param("battery")Long battery, @Param("groupId")Long groupId,
                    @Param("connectedHost")String connectedHost, @Param("latitude")String latitude,
                    @Param("logitude")String logitude, @Param("myHost")String myHost,
                    @Param("hpno")String hpno);


}

