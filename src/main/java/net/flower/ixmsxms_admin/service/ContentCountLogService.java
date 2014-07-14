package net.flower.ixmsxms_admin.service;

import net.flower.ixmsxms_admin.dao.ContentCountLogDao;
import net.flower.ixmsxms_admin.domain.ContentCountLog;
import net.flower.ixmsxms_admin.utils.PaginateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentCountLogService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ContentCountLogDao contentCountLogDao;

    public ContentCountLog select(Long logId) {
        return this.contentCountLogDao.select(logId);
    }

    public List<ContentCountLog> selectAllList(ContentCountLog contentCountLog) {
        return this.contentCountLogDao.selectAllList(contentCountLog);
    }

    public Map<String, Object> selectList(ContentCountLog contentCountLog) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", this.contentCountLogDao.selectList(contentCountLog));
        int totalCount = this.contentCountLogDao.selectListCount(contentCountLog);
        map.put("totalCount", totalCount);
        map.put("page", PaginateTool.paginate(contentCountLog.getPage(), 10, contentCountLog.getCount(), totalCount));
        return map;
    }

    public Map<String, Object> insert(ContentCountLog contentCountLog) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.contentCountLogDao.insert(contentCountLog));
        map.put("item", contentCountLog);
        return map;
    }

    public Map<String, Object> update(ContentCountLog contentCountLog) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.contentCountLogDao.update(contentCountLog));
        return map;
    }

    public Map<String, Object> delete(Long logId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.contentCountLogDao.delete(logId));
        return map;
    }
}