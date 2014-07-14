package net.flower.ixmsxms_admin.dao;

import java.util.List;

import net.flower.ixmsxms_admin.domain.Version;

@Master
public interface VersionDao {
    public Version select(Long versionId);
    public List<Version> selectList(Version version);
    public List<Version> selectAllList(Version version);
    public int selectListCount(Version version);
    public int insert(Version version);
    public int update(Version version);
    public int delete(Long versionId);
}