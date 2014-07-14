package net.flower.ixmsxms_admin.dao;

import java.util.List;

import net.flower.ixmsxms_admin.domain.GrowthItems;

@Master
public interface GrowthItemsDao {
    public GrowthItems select(Long itemId);
    public List<GrowthItems> selectList(GrowthItems growthItems);
    public List<GrowthItems> selectAllList(GrowthItems growthItems);
    public int selectListCount(GrowthItems growthItems);
    public int insert(GrowthItems growthItems);
    public int update(GrowthItems growthItems);
    public int delete(Long itemId);
}