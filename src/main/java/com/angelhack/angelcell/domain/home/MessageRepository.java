package com.angelhack.angelcell.domain.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author seha
 * @date 2019-06-01
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByNum(Users num);
}

