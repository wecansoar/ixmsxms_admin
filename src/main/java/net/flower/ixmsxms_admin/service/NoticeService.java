package net.flower.ixmsxms_admin.service;

import net.flower.ixmsxms_admin.dao.NoticeDao;
import net.flower.ixmsxms_admin.domain.Notice;
import net.flower.ixmsxms_admin.utils.PaginateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private NoticeDao noticeDao;

    public Notice select(Long noticeId) {
        return this.noticeDao.select(noticeId);
    }

    public List<Notice> selectAllList(Notice notice) {
        return this.noticeDao.selectAllList(notice);
    }

    public Map<String, Object> selectList(Notice notice) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", this.noticeDao.selectList(notice));
        int totalCount = this.noticeDao.selectListCount(notice);
        map.put("totalCount", totalCount);
        map.put("page", PaginateTool.paginate(notice.getPage(), 10, notice.getCount(), totalCount));
        return map;
    }

    public Map<String, Object> insert(Notice notice) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.noticeDao.insert(notice));
        map.put("item", notice);
        return map;
    }

    public Map<String, Object> update(Notice notice) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.noticeDao.update(notice));
        return map;
    }

    public Map<String, Object> delete(Long noticeId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.noticeDao.delete(noticeId));
        return map;
    }
}