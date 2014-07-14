package net.flower.ixmsxms_admin.dao;

import java.util.List;

import net.flower.ixmsxms_admin.domain.Admin;

@Master
public interface AdminDao {
    public Admin select(String adminId);
    public List<Admin> selectList(Admin admin);
    public List<Admin> selectAllList(Admin admin);
    public int selectListCount(Admin admin);
    public int insert(Admin admin);
    public int update(Admin admin);
    public int delete(Long adminId);
}