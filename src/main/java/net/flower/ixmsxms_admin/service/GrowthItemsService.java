package net.flower.ixmsxms_admin.service;

import net.flower.ixmsxms_admin.dao.GrowthItemsDao;
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
public class GrowthItemsService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private GrowthItemsDao growthItemsDao;

    public GrowthItems select(Long itemId) {
        return this.growthItemsDao.select(itemId);
    }

    public List<GrowthItems> selectAllList(GrowthItems growthItems) {
        return this.growthItemsDao.selectAllList(growthItems);
    }

    public Map<String, Object> selectList(GrowthItems growthItems) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", this.growthItemsDao.selectList(growthItems));
        int totalCount = this.growthItemsDao.selectListCount(growthItems);
        map.put("totalCount", totalCount);
        map.put("page", PaginateTool.paginate(growthItems.getPage(), 10, growthItems.getCount(), totalCount));
        return map;
    }

    public Map<String, Object> insert(GrowthItems growthItems) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.growthItemsDao.insert(growthItems));
        map.put("item", growthItems);
        return map;
    }

    public Map<String, Object> update(GrowthItems growthItems) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.growthItemsDao.update(growthItems));
        return map;
    }

    public Map<String, Object> delete(Long itemId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.growthItemsDao.delete(itemId));
        return map;
    }
}