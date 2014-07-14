package net.flower.ixmsxms_admin.service;

import net.flower.ixmsxms_admin.dao.HelpDao;
import net.flower.ixmsxms_admin.domain.Help;
import net.flower.ixmsxms_admin.utils.PaginateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HelpService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private HelpDao helpDao;

    public Help select(Long helpId) {
        return this.helpDao.select(helpId);
    }

    public List<Help> selectAllList(Help help) {
        return this.helpDao.selectAllList(help);
    }

    public Map<String, Object> selectList(Help help) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", this.helpDao.selectList(help));
        int totalCount = this.helpDao.selectListCount(help);
        map.put("totalCount", totalCount);
        map.put("page", PaginateTool.paginate(help.getPage(), 10, help.getCount(), totalCount));
        return map;
    }

    public Map<String, Object> insert(Help help) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.helpDao.insert(help));
        map.put("item", help);
        return map;
    }

    public Map<String, Object> update(Help help) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.helpDao.update(help));
        return map;
    }

    public Map<String, Object> delete(Long helpId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.helpDao.delete(helpId));
        return map;
    }
}