package net.flower.ixmsxms_admin.controller;

import net.flower.ixmsxms_admin.domain.Child;
import net.flower.ixmsxms_admin.service.ChildService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/child")
public class ChildController extends DefaultController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ChildService childService;

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Object list(Child child) {
        return this.childService.selectList(child);
    }

    @RequestMapping(value="/{childId}", method=RequestMethod.GET)
    @ResponseBody
    public Object view(@PathVariable("childId") Long childId, Child child) {
        return this.childService.select(childId);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody Child child) {
        return this.childService.insert(child);
    }

    @RequestMapping(value="/{childId}", method=RequestMethod.PUT)
    @ResponseBody
    public Object edit(@PathVariable("childId") Long childId, @RequestBody Child child) {
        return this.childService.update(child);
    }

    @RequestMapping(value="/{childId}", method=RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("childId") Long childId) {
        return this.childService.delete(childId);
    }

    @RequestMapping("/list")
    public void list(HttpServletRequest request, Child child) {
        this.addAllAttributes(request, this.childService.selectList(child));
    }

    @RequestMapping("/form")
    public void form(HttpServletRequest request, Child child) {
        if (child.getChildId() != null) {
            this.addAllAttributes(request, this.childService.select(child.getChildId()));
        }
    }
}