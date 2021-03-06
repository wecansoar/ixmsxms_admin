package net.flower.ixmsxms_admin.dao;

import net.flower.ixmsxms_admin.domain.User;

import java.util.List;

@Master
public interface UserDao {
    public User select(Long userId);
    public List<User> selectList(User user);
    public List<User> selectAllList(User user);
    public int selectListCount(User user);
    public int insert(User user);
    public int update(User user);
    public int delete(Long userId);
}