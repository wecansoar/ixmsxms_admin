package net.flower.ixmsxms_admin.controller;

import net.flower.ixmsxms_admin.domain.Growth;
import net.flower.ixmsxms_admin.service.GrowthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/growth")
public class GrowthController extends DefaultController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private GrowthService growthService;

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Object list(Growth growth) {
        return this.growthService.selectList(growth);
    }

    @RequestMapping(value="/{growthId}", method=RequestMethod.GET)
    @ResponseBody
    public Object view(@PathVariable("growthId") Long growthId, Growth growth) {
        return this.growthService.select(growthId);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody Growth growth) {
        return this.growthService.insert(growth);
    }

    @RequestMapping(value="/{growthId}", method=RequestMethod.PUT)
    @ResponseBody
    public Object edit(@PathVariable("growthId") Long growthId, @RequestBody Growth growth) {
        return this.growthService.update(growth);
    }

    @RequestMapping(value="/{growthId}", method=RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("growthId") Long growthId) {
        return this.growthService.delete(growthId);
    }

    @RequestMapping("/list")
    public void list(HttpServletRequest request, Growth growth) {
        this.addAllAttributes(request, this.growthService.selectList(growth));
    }

    @RequestMapping("/form")
    public void form(HttpServletRequest request, Growth growth) {
        if (growth.getGrowthId() != null) {
            this.addAllAttributes(request, this.growthService.select(growth.getGrowthId()));
        }
    }
}