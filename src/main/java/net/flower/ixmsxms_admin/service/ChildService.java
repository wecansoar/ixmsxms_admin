package net.flower.ixmsxms_admin.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import net.flower.ixmsxms_admin.utils.PaginateTool;
import net.flower.ixmsxms_admin.domain.Child;
import net.flower.ixmsxms_admin.dao.ChildDao;

@Service
public class ChildService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ChildDao childDao;

    public Child select(Long childId) {
        return this.childDao.select(childId);
    }

    public List<Child> selectAllList(Child child) {
        return this.childDao.selectAllList(child);
    }

    public Map<String, Object> selectList(Child child) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", this.childDao.selectList(child));
        int totalCount = this.childDao.selectListCount(child);
        map.put("totalCount", totalCount);
        map.put("page", PaginateTool.paginate(child.getPage(), 10, child.getCount(), totalCount));
        return map;
    }

    public Map<String, Object> insert(Child child) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.childDao.insert(child));
        map.put("item", child);
        return map;
    }

    public Map<String, Object> update(Child child) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.childDao.update(child));
        return map;
    }

    public Map<String, Object> delete(Long childId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.childDao.delete(childId));
        return map;
    }
}