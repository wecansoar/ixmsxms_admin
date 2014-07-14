package net.flower.ixmsxms_admin.dao;

import java.util.List;

import net.flower.ixmsxms_admin.domain.ContentCount;

@Master
public interface ContentCountDao {
    public ContentCount select(Long countId);
    public List<ContentCount> selectList(ContentCount contentCount);
    public List<ContentCount> selectAllList(ContentCount contentCount);
    public int selectListCount(ContentCount contentCount);
    public int insert(ContentCount contentCount);
    public int update(ContentCount contentCount);
    public int delete(Long countId);
}