package com.angelhack.angelcell.controller;

import com.angelhack.angelcell.biz.home.HomeService;
import com.angelhack.angelcell.domain.home.Users;
import com.angelhack.angelcell.dto.MessageSaveDto;
import com.angelhack.angelcell.dto.MessageSendDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Long regMessageByNum(@PathVariable("num") Long num, @RequestBody MessageSaveDto dto) {
        Users users = new Users();
        users.setNum(num);
        dto.setNum(users);
        return homeService.regMessageByNum(dto);
    }

    @PostMapping("/users/{num}/send")
    public int sendMessage(@PathVariable("num")Long num){
        int groupCount = homeService.getUserCountByGroupId(num);
        log.debug("$$$"+groupCount);
        return 0;
    }
}
