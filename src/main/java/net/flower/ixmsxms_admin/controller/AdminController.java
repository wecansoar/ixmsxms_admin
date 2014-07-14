package net.flower.ixmsxms_admin.controller;

import net.flower.ixmsxms_admin.domain.Admin;
import net.flower.ixmsxms_admin.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController extends DefaultController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private AdminService adminService;

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Object list(Admin admin) {
        return this.adminService.selectList(admin);
    }

    @RequestMapping(value="/{adminId}", method=RequestMethod.GET)
    @ResponseBody
    public Object view(@PathVariable("adminId") String adminId, Admin admin) {
        return this.adminService.select(adminId);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody Admin admin) {
        return this.adminService.insert(admin);
    }

    @RequestMapping(value="/{adminId}", method=RequestMethod.PUT)
    @ResponseBody
    public Object edit(@PathVariable("adminId") Long adminId, @RequestBody Admin admin) {
        return this.adminService.update(admin);
    }

    @RequestMapping(value="/{adminId}", method=RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("adminId") Long adminId) {
        return this.adminService.delete(adminId);
    }

    @RequestMapping("/list")
    public void list(HttpServletRequest request, Admin admin) {
        this.addAllAttributes(request, this.adminService.selectList(admin));
    }

    @RequestMapping("/form")
    public void form(HttpServletRequest request, Admin admin) {
        if (admin.getAdminId() != null) {
            this.addAllAttributes(request, this.adminService.select(admin.getAdminId()));
        }
    }
}