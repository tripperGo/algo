package com.mright.rabbit.platform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mright
 * @date: Created in 2020/5/24 3:11 PM
 * @desc:
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping
    public String index() {
        return "SUCCESS";
    }
}
