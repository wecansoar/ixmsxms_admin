package net.flower.ixmsxms_admin.dao;

import java.util.List;

import net.flower.ixmsxms_admin.domain.Child;

@Master
public interface ChildDao {
    public Child select(Long childId);
    public List<Child> selectList(Child child);
    public List<Child> selectAllList(Child child);
    public int selectListCount(Child child);
    public int insert(Child child);
    public int update(Child child);
    public int delete(Long childId);
}