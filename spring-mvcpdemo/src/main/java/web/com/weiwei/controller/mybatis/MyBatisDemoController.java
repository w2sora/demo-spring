package web.com.weiwei.controller.mybatis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mybatis")
public class MyBatisDemoController {

    @GetMapping("/user/{user}")
    // @ResponseBody
    public String test1(@PathVariable("user") String username, ModelMap modelMap) {
        // public String test1(@PathVariable("user") String username, Model model) {
        // public String test1(@PathVariable("user") String username, Map<String, String> map) {
        // public ModelAndView test1(@PathVariable("user") String username) {

        String password = "123456"; // service.queryPassword(username);
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

        return "mybatis/mybatis";
    }
}
