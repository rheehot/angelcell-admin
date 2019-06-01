package com.angelhack.angelcell.controller;

import com.angelhack.angelcell.biz.home.HomeService;
import com.angelhack.angelcell.domain.home.Users;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author seha
 * @date 2019-06-01
 */

@Controller
@AllArgsConstructor
@Log4j2
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/")
    @ResponseBody
    public Object mainPage(Model model) {
        Map<String, Object> map = new HashMap<>();
        List<Users> userList = homeService.getUserDataList();
//        model.addAttribute("userList", userList);
        map.put("userList", userList);

        log.error("###"+userList);
        return map;
    }

    @GetMapping("/users/{num}")
    public String getUserDetailPage(@PathVariable("num")Long num, Model model, HttpSession session) {
        model.addAttribute("userDetail", homeService.getUserDetail(num));
        model.addAttribute("userMessage", homeService.getUserMessage(num));
        return "user/detail";
    }

}
