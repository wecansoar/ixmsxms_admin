package net.flower.ixmsxms_admin.service;

import net.flower.ixmsxms_admin.dao.CodeItemDao;
import net.flower.ixmsxms_admin.domain.CodeItem;
import net.flower.ixmsxms_admin.utils.PaginateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CodeItemService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private CodeItemDao codeItemDao;

    public CodeItem select(Long itemId) {
        return this.codeItemDao.select(itemId);
    }

    public List<CodeItem> selectAllList(CodeItem codeItem) {
        return this.codeItemDao.selectAllList(codeItem);
    }

    public Map<String, Object> selectList(CodeItem codeItem) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", this.codeItemDao.selectList(codeItem));
        int totalCount = this.codeItemDao.selectListCount(codeItem);
        map.put("totalCount", totalCount);
        map.put("page", PaginateTool.paginate(codeItem.getPage(), 10, codeItem.getCount(), totalCount));
        return map;
    }

    public Map<String, Object> insert(CodeItem codeItem) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.codeItemDao.insert(codeItem));
        map.put("item", codeItem);
        return map;
    }

    public Map<String, Object> update(CodeItem codeItem) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.codeItemDao.update(codeItem));
        return map;
    }

    public Map<String, Object> delete(Long itemId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.codeItemDao.delete(itemId));
        return map;
    }
}