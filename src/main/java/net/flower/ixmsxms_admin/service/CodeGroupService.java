package net.flower.ixmsxms_admin.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import net.flower.ixmsxms_admin.utils.PaginateTool;
import net.flower.ixmsxms_admin.domain.CodeGroup;
import net.flower.ixmsxms_admin.dao.CodeGroupDao;

@Service
public class CodeGroupService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private CodeGroupDao codeGroupDao;

    public CodeGroup select(Long groupId) {
        return this.codeGroupDao.select(groupId);
    }

    public List<CodeGroup> selectAllList(CodeGroup codeGroup) {
        return this.codeGroupDao.selectAllList(codeGroup);
    }

    public Map<String, Object> selectList(CodeGroup codeGroup) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", this.codeGroupDao.selectList(codeGroup));
        int totalCount = this.codeGroupDao.selectListCount(codeGroup);
        map.put("totalCount", totalCount);
        map.put("page", PaginateTool.paginate(codeGroup.getPage(), 10, codeGroup.getCount(), totalCount));
        return map;
    }

    public Map<String, Object> insert(CodeGroup codeGroup) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.codeGroupDao.insert(codeGroup));
        map.put("item", codeGroup);
        return map;
    }

    public Map<String, Object> update(CodeGroup codeGroup) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.codeGroupDao.update(codeGroup));
        return map;
    }

    public Map<String, Object> delete(Long groupId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.codeGroupDao.delete(groupId));
        return map;
    }
}