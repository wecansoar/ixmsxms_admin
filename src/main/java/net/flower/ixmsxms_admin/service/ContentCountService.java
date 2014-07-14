package net.flower.ixmsxms_admin.service;

import net.flower.ixmsxms_admin.dao.ContentCountDao;
import net.flower.ixmsxms_admin.domain.ContentCount;
import net.flower.ixmsxms_admin.utils.PaginateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentCountService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ContentCountDao contentCountDao;

    public ContentCount select(Long countId) {
        return this.contentCountDao.select(countId);
    }

    public List<ContentCount> selectAllList(ContentCount contentCount) {
        return this.contentCountDao.selectAllList(contentCount);
    }

    public Map<String, Object> selectList(ContentCount contentCount) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", this.contentCountDao.selectList(contentCount));
        int totalCount = this.contentCountDao.selectListCount(contentCount);
        map.put("totalCount", totalCount);
        map.put("page", PaginateTool.paginate(contentCount.getPage(), 10, contentCount.getCount(), totalCount));
        return map;
    }

    public Map<String, Object> insert(ContentCount contentCount) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.contentCountDao.insert(contentCount));
        map.put("item", contentCount);
        return map;
    }

    public Map<String, Object> update(ContentCount contentCount) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.contentCountDao.update(contentCount));
        return map;
    }

    public Map<String, Object> delete(Long countId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.contentCountDao.delete(countId));
        return map;
    }
}