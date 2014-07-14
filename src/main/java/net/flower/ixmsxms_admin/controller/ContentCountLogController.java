package net.flower.ixmsxms_admin.controller;

import net.flower.ixmsxms_admin.domain.ContentCountLog;
import net.flower.ixmsxms_admin.service.ContentCountLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/contentCountLog")
public class ContentCountLogController extends DefaultController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ContentCountLogService contentCountLogService;

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Object list(ContentCountLog contentCountLog) {
        return this.contentCountLogService.selectList(contentCountLog);
    }

    @RequestMapping(value="/{logId}", method=RequestMethod.GET)
    @ResponseBody
    public Object view(@PathVariable("logId") Long logId, ContentCountLog contentCountLog) {
        return this.contentCountLogService.select(logId);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody ContentCountLog contentCountLog) {
        return this.contentCountLogService.insert(contentCountLog);
    }

    @RequestMapping(value="/{logId}", method=RequestMethod.PUT)
    @ResponseBody
    public Object edit(@PathVariable("logId") Long logId, @RequestBody ContentCountLog contentCountLog) {
        return this.contentCountLogService.update(contentCountLog);
    }

    @RequestMapping(value="/{logId}", method=RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("logId") Long logId) {
        return this.contentCountLogService.delete(logId);
    }

    @RequestMapping("/list")
    public void list(HttpServletRequest request, ContentCountLog contentCountLog) {
        this.addAllAttributes(request, this.contentCountLogService.selectList(contentCountLog));
    }

    @RequestMapping("/form")
    public void form(HttpServletRequest request, ContentCountLog contentCountLog) {
        if (contentCountLog.getLogId() != null) {
            this.addAllAttributes(request, this.contentCountLogService.select(contentCountLog.getLogId()));
        }
    }
}