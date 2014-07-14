package net.flower.ixmsxms_admin.controller;

import net.flower.ixmsxms_admin.domain.Notice;
import net.flower.ixmsxms_admin.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/notice")
public class NoticeController extends DefaultController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private NoticeService noticeService;

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Object list(Notice notice) {
        return this.noticeService.selectList(notice);
    }

    @RequestMapping(value="/{noticeId}", method=RequestMethod.GET)
    @ResponseBody
    public Object view(@PathVariable("noticeId") Long noticeId, Notice notice) {
        return this.noticeService.select(noticeId);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody Notice notice) {
        return this.noticeService.insert(notice);
    }

    @RequestMapping(value="/{noticeId}", method=RequestMethod.PUT)
    @ResponseBody
    public Object edit(@PathVariable("noticeId") Long noticeId, @RequestBody Notice notice) {
        return this.noticeService.update(notice);
    }

    @RequestMapping(value="/{noticeId}", method=RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("noticeId") Long noticeId) {
        return this.noticeService.delete(noticeId);
    }

    @RequestMapping("/list")
    public void list(HttpServletRequest request, Notice notice) {
        this.addAllAttributes(request, this.noticeService.selectList(notice));
    }

    @RequestMapping("/form")
    public void form(HttpServletRequest request, Notice notice) {
        if (notice.getNoticeId() != null) {
            this.addAllAttributes(request, this.noticeService.select(notice.getNoticeId()));
        }
    }
}