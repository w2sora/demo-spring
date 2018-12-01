package com.weiwei.controller.mybatis;

import com.weiwei.domain.UserDO;
import com.weiwei.service.MyBatisDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mybatis")
public class MyBatisDemoController {

    private final MyBatisDemoService service;

    @Autowired
    public MyBatisDemoController(MyBatisDemoService service) {
        this.service = service;
    }

    @GetMapping("/user/{user}")
    // @ResponseBody
    public String test1(@PathVariable("user") String username, ModelMap modelMap) {
        String password = service.queryPassword(username);
        modelMap.put("username", username);
        modelMap.put("password", password);
        return "/mybatis/mybatis";
    }

    @PutMapping("/user/{user}")
    @ResponseBody
    public String test2(@PathVariable("user") String username, @RequestBody UserDO user) {
        int result = service.updateUser(user, username);
        if (result > 0) {
            return "修改成功！";
        } else {
            return "修改失败！";
        }
    }

    @DeleteMapping("/user/{user}")
    @ResponseBody
    public String test3(@PathVariable String user) {
        int result = service.deleteUser(user);
        if (result > 0) {
            return "删除成功！";
        } else {
            return "删除失败！";
        }
    }

    @PostMapping("/user")
    @ResponseBody
    public String test4(@RequestBody UserDO user) {
        int result = service.insertUser(user);
        if (result > 0) {
            return "新增成功！";
        } else {
            return "新增失败！";
        }
    }
}
