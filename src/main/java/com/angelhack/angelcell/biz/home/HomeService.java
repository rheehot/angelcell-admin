package com.angelhack.angelcell.biz.home;

import com.angelhack.angelcell.domain.home.Message;
import com.angelhack.angelcell.domain.home.MessageRepository;
import com.angelhack.angelcell.domain.home.Users;
import com.angelhack.angelcell.domain.home.UsersRepository;
import com.angelhack.angelcell.dto.MessageSaveDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author seha
 * @date 2019-06-01
 */

@AllArgsConstructor
@Service
@Log4j2
public class HomeService {

    private UsersRepository usersRepository;
    private MessageRepository messageRepository;

    @Transactional(readOnly = true)
    public List<Users> getUserDataList() {
        return usersRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Users getUserDetail(Long num) {
        return usersRepository.findUsersByNum(num);
    }

    @Transactional(readOnly = true)
    public List<Message> getUserMessage(Long num) {
        Users users = new Users();
        users.setNum(num);
        return messageRepository.findByNum(users);
    }

    @Transactional
    public Long regMessageByNum(MessageSaveDto dto) {
        return messageRepository.save(dto.toEntity()).getIdx();
    }

    @Transactional
    public int getUserCountByGroupId(Long groupno) {
        return usersRepository.getUserCountByGroupId(groupno);
    }
}
