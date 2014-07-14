package net.flower.ixmsxms_admin.controller;

import net.flower.ixmsxms_admin.domain.CodeGroup;
import net.flower.ixmsxms_admin.service.CodeGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/codeGroup")
public class CodeGroupController extends DefaultController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private CodeGroupService codeGroupService;

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Object list(CodeGroup codeGroup) {
        return this.codeGroupService.selectList(codeGroup);
    }

    @RequestMapping(value="/{groupId}", method=RequestMethod.GET)
    @ResponseBody
    public Object view(@PathVariable("groupId") Long groupId, CodeGroup codeGroup) {
        return this.codeGroupService.select(groupId);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody CodeGroup codeGroup) {
        return this.codeGroupService.insert(codeGroup);
    }

    @RequestMapping(value="/{groupId}", method=RequestMethod.PUT)
    @ResponseBody
    public Object edit(@PathVariable("groupId") Long groupId, @RequestBody CodeGroup codeGroup) {
        return this.codeGroupService.update(codeGroup);
    }

    @RequestMapping(value="/{groupId}", method=RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("groupId") Long groupId) {
        return this.codeGroupService.delete(groupId);
    }

    @RequestMapping("/list")
    public void list(HttpServletRequest request, CodeGroup codeGroup) {
        this.addAllAttributes(request, this.codeGroupService.selectList(codeGroup));
    }

    @RequestMapping("/form")
    public void form(HttpServletRequest request, CodeGroup codeGroup) {
        if (codeGroup.getGroupId() != null) {
            this.addAllAttributes(request, this.codeGroupService.select(codeGroup.getGroupId()));
        }
    }
}