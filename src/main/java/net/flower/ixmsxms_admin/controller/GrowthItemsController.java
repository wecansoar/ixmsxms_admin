package net.flower.ixmsxms_admin.controller;

import net.flower.ixmsxms_admin.domain.GrowthItems;
import net.flower.ixmsxms_admin.service.GrowthItemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/growthItems")
public class GrowthItemsController extends DefaultController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private GrowthItemsService growthItemsService;

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Object list(GrowthItems growthItems) {
        return this.growthItemsService.selectList(growthItems);
    }

    @RequestMapping(value="/{itemId}", method=RequestMethod.GET)
    @ResponseBody
    public Object view(@PathVariable("itemId") Long itemId, GrowthItems growthItems) {
        return this.growthItemsService.select(itemId);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody GrowthItems growthItems) {
        return this.growthItemsService.insert(growthItems);
    }

    @RequestMapping(value="/{itemId}", method=RequestMethod.PUT)
    @ResponseBody
    public Object edit(@PathVariable("itemId") Long itemId, @RequestBody GrowthItems growthItems) {
        return this.growthItemsService.update(growthItems);
    }

    @RequestMapping(value="/{itemId}", method=RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("itemId") Long itemId) {
        return this.growthItemsService.delete(itemId);
    }

    @RequestMapping("/list")
    public void list(HttpServletRequest request, GrowthItems growthItems) {
        this.addAllAttributes(request, this.growthItemsService.selectList(growthItems));
    }

    @RequestMapping("/form")
    public void form(HttpServletRequest request, GrowthItems growthItems) {
        if (growthItems.getItemId() != null) {
            this.addAllAttributes(request, this.growthItemsService.select(growthItems.getItemId()));
        }
    }
}