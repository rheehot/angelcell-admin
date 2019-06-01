package com.angelhack.angelcell.controller;

import com.angelhack.angelcell.biz.home.HomeService;
import com.angelhack.angelcell.domain.home.Users;
import com.angelhack.angelcell.dto.MessageSaveDto;
import com.angelhack.angelcell.dto.MessageSendDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    public int sendMessage(@PathVariable("num")Long num) throws IOException {
        int groupCount = homeService.getUserCountByGroupId(num);
        log.debug("$$$"+groupCount);
        HttpConnection.Response rs = (HttpConnection.Response) Jsoup
                .connect("https://192.168.0.152")
                .data("I_D", "a")
                .data("P_W", "b")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36")
                .method(Connection.Method.POST).execute();
        return 0;
    }
}
