package net.flower.ixmsxms_admin.controller;

import net.flower.ixmsxms_admin.domain.Help;
import net.flower.ixmsxms_admin.service.HelpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/help")
public class HelpController extends DefaultController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private HelpService helpService;

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Object list(Help help) {
        return this.helpService.selectList(help);
    }

    @RequestMapping(value="/{helpId}", method=RequestMethod.GET)
    @ResponseBody
    public Object view(@PathVariable("helpId") Long helpId, Help help) {
        return this.helpService.select(helpId);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody Help help) {
        return this.helpService.insert(help);
    }

    @RequestMapping(value="/{helpId}", method=RequestMethod.PUT)
    @ResponseBody
    public Object edit(@PathVariable("helpId") Long helpId, @RequestBody Help help) {
        return this.helpService.update(help);
    }

    @RequestMapping(value="/{helpId}", method=RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("helpId") Long helpId) {
        return this.helpService.delete(helpId);
    }

    @RequestMapping("/list")
    public void list(HttpServletRequest request, Help help) {
        this.addAllAttributes(request, this.helpService.selectList(help));
    }

    @RequestMapping("/form")
    public void form(HttpServletRequest request, Help help) {
        if (help.getHelpId() != null) {
            this.addAllAttributes(request, this.helpService.select(help.getHelpId()));
        }
    }
}