package net.flower.ixmsxms_admin.dao;

import java.util.List;

import net.flower.ixmsxms_admin.domain.ContentCountLog;

@Master
public interface ContentCountLogDao {
    public ContentCountLog select(Long logId);
    public List<ContentCountLog> selectList(ContentCountLog contentCountLog);
    public List<ContentCountLog> selectAllList(ContentCountLog contentCountLog);
    public int selectListCount(ContentCountLog contentCountLog);
    public int insert(ContentCountLog contentCountLog);
    public int update(ContentCountLog contentCountLog);
    public int delete(Long logId);
}