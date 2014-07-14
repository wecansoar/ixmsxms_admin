package net.flower.ixmsxms_admin.dao;

import java.util.List;

import net.flower.ixmsxms_admin.domain.GrowthChildMap;

@Master
public interface GrowthChildMapDao {
    public GrowthChildMap select(Long id);
    public List<GrowthChildMap> selectList(GrowthChildMap growthChildMap);
    public List<GrowthChildMap> selectAllList(GrowthChildMap growthChildMap);
    public int selectListCount(GrowthChildMap growthChildMap);
    public int insert(GrowthChildMap growthChildMap);
    public int update(GrowthChildMap growthChildMap);
    public int delete(Long id);
}