package net.flower.ixmsxms_admin.controller;

import net.flower.ixmsxms_admin.domain.CodeItem;
import net.flower.ixmsxms_admin.service.CodeItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/codeItem")
public class CodeItemController extends DefaultController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private CodeItemService codeItemService;

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Object list(CodeItem codeItem) {
        return this.codeItemService.selectList(codeItem);
    }

    @RequestMapping(value="/{itemId}", method=RequestMethod.GET)
    @ResponseBody
    public Object view(@PathVariable("itemId") Long itemId, CodeItem codeItem) {
        return this.codeItemService.select(itemId);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody CodeItem codeItem) {
        return this.codeItemService.insert(codeItem);
    }

    @RequestMapping(value="/{itemId}", method=RequestMethod.PUT)
    @ResponseBody
    public Object edit(@PathVariable("itemId") Long itemId, @RequestBody CodeItem codeItem) {
        return this.codeItemService.update(codeItem);
    }

    @RequestMapping(value="/{itemId}", method=RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("itemId") Long itemId) {
        return this.codeItemService.delete(itemId);
    }

    @RequestMapping("/list")
    public void list(HttpServletRequest request, CodeItem codeItem) {
        this.addAllAttributes(request, this.codeItemService.selectList(codeItem));
    }

    @RequestMapping("/form")
    public void form(HttpServletRequest request, CodeItem codeItem) {
        if (codeItem.getItemId() != null) {
            this.addAllAttributes(request, this.codeItemService.select(codeItem.getItemId()));
        }
    }
}