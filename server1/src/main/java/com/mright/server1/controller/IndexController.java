package com.mright.server1.controller;

import com.mright.server1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/6/3 16:53
 */
@RestController
@RequestMapping("/server2")
public class IndexController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/")
    public String insert(){
        return iUserService.insert();
    }
}
