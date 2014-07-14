package net.flower.ixmsxms_admin.controller;

import net.flower.ixmsxms_admin.domain.GrowthChildMap;
import net.flower.ixmsxms_admin.service.GrowthChildMapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/growthChildMap")
public class GrowthChildMapController extends DefaultController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private GrowthChildMapService growthChildMapService;

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Object list(GrowthChildMap growthChildMap) {
        return this.growthChildMapService.selectList(growthChildMap);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Object view(@PathVariable("id") Long id, GrowthChildMap growthChildMap) {
        return this.growthChildMapService.select(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody GrowthChildMap growthChildMap) {
        return this.growthChildMapService.insert(growthChildMap);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @ResponseBody
    public Object edit(@PathVariable("id") Long id, @RequestBody GrowthChildMap growthChildMap) {
        return this.growthChildMapService.update(growthChildMap);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("id") Long id) {
        return this.growthChildMapService.delete(id);
    }

    @RequestMapping("/list")
    public void list(HttpServletRequest request, GrowthChildMap growthChildMap) {
        this.addAllAttributes(request, this.growthChildMapService.selectList(growthChildMap));
    }

    @RequestMapping("/form")
    public void form(HttpServletRequest request, GrowthChildMap growthChildMap) {
        if (growthChildMap.getId() != null) {
            this.addAllAttributes(request, this.growthChildMapService.select(growthChildMap.getId()));
        }
    }
}