package com.angelhack.angelcell.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
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
    @PostMapping("/")
    public String mainPage() {
        return "main";
    }
}
