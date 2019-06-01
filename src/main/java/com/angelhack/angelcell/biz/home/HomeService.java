package com.angelhack.angelcell.biz.home;

import com.angelhack.angelcell.domain.home.Users;
import com.angelhack.angelcell.domain.home.UsersRepository;
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

    private UsersRepository locationRepository;

    @Transactional(readOnly = true)
    public List<Users> getUserDataList() {
        return locationRepository.findAll();
    }

}
