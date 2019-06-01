package com.angelhack.angelcell.controller;

import com.angelhack.angelcell.biz.home.HomeService;
import com.angelhack.angelcell.domain.home.Users;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author seha
 * @date 2019-06-01
 */

@RestController
@AllArgsConstructor
@Log4j2
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/")
    public Object mainPage() {
        Map<String, Object> map = new HashMap<>();
        List<Users> userList = homeService.getUserDataList();
        map.put("userList", userList);

        return map;
    }

    @GetMapping("/users/{num}")
    public Object getUserDetailPage(@PathVariable("num")Long num) {
        Map<String, Object> map = new HashMap<>();
        map.put("userDetail", homeService.getUserDetail(num));
        map.put("userMessage", homeService.getUserMessage(num));
        return map;
    }

}