package net.flower.ixmsxms_admin.controller;

import net.flower.ixmsxms_admin.domain.ContentCount;
import net.flower.ixmsxms_admin.service.ContentCountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/contentCount")
public class ContentCountController extends DefaultController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ContentCountService contentCountService;

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Object list(ContentCount contentCount) {
        return this.contentCountService.selectList(contentCount);
    }

    @RequestMapping(value="/{countId}", method=RequestMethod.GET)
    @ResponseBody
    public Object view(@PathVariable("countId") Long countId, ContentCount contentCount) {
        return this.contentCountService.select(countId);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody ContentCount contentCount) {
        return this.contentCountService.insert(contentCount);
    }

    @RequestMapping(value="/{countId}", method=RequestMethod.PUT)
    @ResponseBody
    public Object edit(@PathVariable("countId") Long countId, @RequestBody ContentCount contentCount) {
        return this.contentCountService.update(contentCount);
    }

    @RequestMapping(value="/{countId}", method=RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("countId") Long countId) {
        return this.contentCountService.delete(countId);
    }

    @RequestMapping("/list")
    public void list(HttpServletRequest request, ContentCount contentCount) {
        this.addAllAttributes(request, this.contentCountService.selectList(contentCount));
    }

    @RequestMapping("/form")
    public void form(HttpServletRequest request, ContentCount contentCount) {
        if (contentCount.getCountId() != null) {
            this.addAllAttributes(request, this.contentCountService.select(contentCount.getCountId()));
        }
    }
}