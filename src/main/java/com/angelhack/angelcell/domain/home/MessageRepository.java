package com.angelhack.angelcell.domain.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author seha
 * @date 2019-06-01
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}

