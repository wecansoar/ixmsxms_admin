package net.flower.ixmsxms_admin.controller;

import net.flower.ixmsxms_admin.domain.Program;
import net.flower.ixmsxms_admin.service.ProgramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/program")
public class ProgramController extends DefaultController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ProgramService programService;

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Object list(Program program) {
        return this.programService.selectList(program);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Object view(@PathVariable("id") Long id, Program program) {
        return this.programService.select(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody Program program) {
        return this.programService.insert(program);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @ResponseBody
    public Object edit(@PathVariable("id") Long id, @RequestBody Program program) {
        return this.programService.update(program);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("id") Long id) {
        return this.programService.delete(id);
    }

    @RequestMapping("/list")
    public void list(HttpServletRequest request, Program program) {
        this.addAllAttributes(request, this.programService.selectList(program));
    }

    @RequestMapping("/form")
    public void form(HttpServletRequest request, Program program) {
        if (program.getId() != null) {
            this.addAllAttributes(request, this.programService.select(program.getId()));
        }
    }
}