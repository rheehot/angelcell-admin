package com.angelhack.angelcell.controller;

import com.angelhack.angelcell.biz.home.HomeService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
    HomeService homeService;

    @PostMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("userList", homeService.getUserDataList());
        return "main";
    }
}
