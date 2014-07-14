package net.flower.ixmsxms_admin.controller;

import net.flower.ixmsxms_admin.domain.Version;
import net.flower.ixmsxms_admin.service.VersionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/version")
public class VersionController extends DefaultController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private VersionService versionService;

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Object list(Version version) {
        return this.versionService.selectList(version);
    }

    @RequestMapping(value="/{versionId}", method=RequestMethod.GET)
    @ResponseBody
    public Object view(@PathVariable("versionId") Long versionId, Version version) {
        return this.versionService.select(versionId);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody Version version) {
        return this.versionService.insert(version);
    }

    @RequestMapping(value="/{versionId}", method=RequestMethod.PUT)
    @ResponseBody
    public Object edit(@PathVariable("versionId") Long versionId, @RequestBody Version version) {
        return this.versionService.update(version);
    }

    @RequestMapping(value="/{versionId}", method=RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("versionId") Long versionId) {
        return this.versionService.delete(versionId);
    }

    @RequestMapping("/list")
    public void list(HttpServletRequest request, Version version) {
        this.addAllAttributes(request, this.versionService.selectList(version));
    }

    @RequestMapping("/form")
    public void form(HttpServletRequest request, Version version) {
        if (version.getVersionId() != null) {
            this.addAllAttributes(request, this.versionService.select(version.getVersionId()));
        }
    }
}