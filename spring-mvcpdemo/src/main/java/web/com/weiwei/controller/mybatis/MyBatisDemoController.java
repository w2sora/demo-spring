package web.com.weiwei.controller.mybatis;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.com.weiwei.domain.UserDO;
import web.com.weiwei.exceptionHandler.UserNotFoundException;
import web.com.weiwei.service.MyBatisDemoService;

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
        // public String test1(@PathVariable("user") String username, Model model) {
        // public String test1(@PathVariable("user") String username, Map<String, String> map) {
        // public ModelAndView test1(@PathVariable("user") String username) {

        String password = service.queryPassword(username);
        if (StringUtils.isNotBlank(password)) {
            modelMap.put("username", username); // put允许传null
            modelMap.addAttribute("password", password); // 先判断不可为null，再调用put

            // model.addAttribute("username", username);
            // model.addAttribute("password", password);

            // map.put("username", username);
            // map.put("password", password);

            // ModelAndView mav = new ModelAndView("/mybatis/mybatis");
            // mav.addObject("username", username);
            // mav.addObject("password", password);
            // return mav;

            return "/mybatis/mybatis";
        } else {
            throw new UserNotFoundException();
        }
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
