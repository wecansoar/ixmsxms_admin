package net.flower.ixmsxms_admin.service;

import net.flower.ixmsxms_admin.dao.ProgramDao;
import net.flower.ixmsxms_admin.domain.Program;
import net.flower.ixmsxms_admin.utils.PaginateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProgramService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ProgramDao programDao;

    public Program select(Long id) {
        return this.programDao.select(id);
    }

    public List<Program> selectAllList(Program program) {
        return this.programDao.selectAllList(program);
    }

    public Map<String, Object> selectList(Program program) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", this.programDao.selectList(program));
        int totalCount = this.programDao.selectListCount(program);
        map.put("totalCount", totalCount);
        map.put("page", PaginateTool.paginate(program.getPage(), 10, program.getCount(), totalCount));
        return map;
    }

    public Map<String, Object> insert(Program program) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.programDao.insert(program));
        map.put("item", program);
        return map;
    }

    public Map<String, Object> update(Program program) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.programDao.update(program));
        return map;
    }

    public Map<String, Object> delete(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.programDao.delete(id));
        return map;
    }
}