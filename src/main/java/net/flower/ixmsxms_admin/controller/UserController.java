package net.flower.ixmsxms_admin.controller;

import net.flower.ixmsxms_admin.domain.User;
import net.flower.ixmsxms_admin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController extends DefaultController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserService userService;

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Object list(User user) {
        return this.userService.selectList(user);
    }

    @RequestMapping(value="/{userId}", method=RequestMethod.GET)
    @ResponseBody
    public Object view(@PathVariable("userId") Long userId, User user) {
        return this.userService.select(userId);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody User user) {
        return this.userService.insert(user);
    }

    @RequestMapping(value="/{userId}", method=RequestMethod.PUT)
    @ResponseBody
    public Object edit(@PathVariable("userId") Long userId, @RequestBody User user) {
        return this.userService.update(user);
    }

    @RequestMapping(value="/{userId}", method=RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("userId") Long userId) {
        return this.userService.delete(userId);
    }

    @RequestMapping("/list")
    public void list(HttpServletRequest request, User user) {
        this.addAllAttributes(request, this.userService.selectList(user));
    }

    @RequestMapping("/form")
    public void form(HttpServletRequest request, User user) {
        if (user.getUserId() != null) {
            this.addAllAttributes(request, this.userService.select(user.getUserId()));
        }
    }
}