package com.angelhack.angelcell.controller;

import com.angelhack.angelcell.biz.home.HomeService;
import com.angelhack.angelcell.domain.home.Users;
import com.angelhack.angelcell.dto.user.MessageSaveDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seha
 * @date 2019-06-01
 */

@RestController
@AllArgsConstructor
@Log4j2
public class HomeRestController {

    @Autowired
    private HomeService homeService;

    @PostMapping("/users/{num}")
    public Long regMessageByNum(@PathVariable("num") Long num, MessageSaveDto dto) {
        Users users = new Users();
        users.setNum(num);
        return homeService.regMessageByNum(dto);
    }
}
