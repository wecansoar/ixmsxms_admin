package net.flower.ixmsxms_admin.service;

import net.flower.ixmsxms_admin.dao.GrowthChildMapDao;
import net.flower.ixmsxms_admin.domain.GrowthChildMap;
import net.flower.ixmsxms_admin.utils.PaginateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GrowthChildMapService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private GrowthChildMapDao growthChildMapDao;

    public GrowthChildMap select(Long id) {
        return this.growthChildMapDao.select(id);
    }

    public List<GrowthChildMap> selectAllList(GrowthChildMap growthChildMap) {
        return this.growthChildMapDao.selectAllList(growthChildMap);
    }

    public Map<String, Object> selectList(GrowthChildMap growthChildMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", this.growthChildMapDao.selectList(growthChildMap));
        int totalCount = this.growthChildMapDao.selectListCount(growthChildMap);
        map.put("totalCount", totalCount);
        map.put("page", PaginateTool.paginate(growthChildMap.getPage(), 10, growthChildMap.getCount(), totalCount));
        return map;
    }

    public Map<String, Object> insert(GrowthChildMap growthChildMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.growthChildMapDao.insert(growthChildMap));
        map.put("item", growthChildMap);
        return map;
    }

    public Map<String, Object> update(GrowthChildMap growthChildMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.growthChildMapDao.update(growthChildMap));
        return map;
    }

    public Map<String, Object> delete(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.growthChildMapDao.delete(id));
        return map;
    }
}