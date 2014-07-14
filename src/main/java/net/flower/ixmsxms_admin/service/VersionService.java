package net.flower.ixmsxms_admin.service;

import net.flower.ixmsxms_admin.dao.VersionDao;
import net.flower.ixmsxms_admin.domain.Version;
import net.flower.ixmsxms_admin.utils.PaginateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VersionService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private VersionDao versionDao;

    public Version select(Long versionId) {
        return this.versionDao.select(versionId);
    }

    public List<Version> selectAllList(Version version) {
        return this.versionDao.selectAllList(version);
    }

    public Map<String, Object> selectList(Version version) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", this.versionDao.selectList(version));
        int totalCount = this.versionDao.selectListCount(version);
        map.put("totalCount", totalCount);
        map.put("page", PaginateTool.paginate(version.getPage(), 10, version.getCount(), totalCount));
        return map;
    }

    public Map<String, Object> insert(Version version) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.versionDao.insert(version));
        map.put("item", version);
        return map;
    }

    public Map<String, Object> update(Version version) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.versionDao.update(version));
        return map;
    }

    public Map<String, Object> delete(Long versionId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.versionDao.delete(versionId));
        return map;
    }
}