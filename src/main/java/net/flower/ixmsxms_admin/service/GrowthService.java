package net.flower.ixmsxms_admin.service;

import net.flower.ixmsxms_admin.dao.GrowthDao;
import net.flower.ixmsxms_admin.dao.GrowthItemsDao;
import net.flower.ixmsxms_admin.domain.Growth;
import net.flower.ixmsxms_admin.domain.GrowthItems;
import net.flower.ixmsxms_admin.utils.PaginateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GrowthService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private GrowthDao growthDao;

    public Growth select(Long growthId) {
        return this.growthDao.select(growthId);
    }

    public List<Growth> selectAllList(Growth growth) {
        return this.growthDao.selectAllList(growth);
    }

    public Map<String, Object> selectList(Growth growth) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", this.growthDao.selectList(growth));
        int totalCount = this.growthDao.selectListCount(growth);
        map.put("totalCount", totalCount);
        map.put("page", PaginateTool.paginate(growth.getPage(), 10, growth.getCount(), totalCount));
        return map;
    }

    public Map<String, Object> insert(Growth growth) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.growthDao.insert(growth));
        map.put("item", growthDao);
        return map;
    }

    public Map<String, Object> update(Growth growth) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.growthDao.update(growth));
        return map;
    }

    public Map<String, Object> delete(Long itemId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.growthDao.delete(itemId));
        return map;
    }
}