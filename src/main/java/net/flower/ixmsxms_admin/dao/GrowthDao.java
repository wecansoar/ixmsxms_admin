package net.flower.ixmsxms_admin.dao;

import net.flower.ixmsxms_admin.domain.Growth;

import java.util.List;

@Master
public interface GrowthDao {
    public Growth select(Long growthId);
    public List<Growth> selectList(Growth growth);
    public List<Growth> selectAllList(Growth growth);
    public int selectListCount(Growth growth);
    public int insert(Growth growth);
    public int update(Growth growth);
    public int delete(Long growthId);
}