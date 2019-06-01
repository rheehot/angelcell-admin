package com.angelhack.angelcell.controller;

import com.angelhack.angelcell.biz.home.HomeService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

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
    public String mainPage(Model model) {
        return "main";
    }

    @GetMapping("/lobby")
    public String lobbyPage(Model model, HttpSession session) {
     return "lobby";
    }

}
