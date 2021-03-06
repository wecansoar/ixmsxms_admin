package net.flower.ixmsxms_admin.service;

import net.flower.ixmsxms_admin.dao.UserDao;
import net.flower.ixmsxms_admin.domain.User;
import net.flower.ixmsxms_admin.utils.PaginateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserDao userDao;

    public User select(Long userId) {
        return this.userDao.select(userId);
    }

    public List<User> selectAllList(User user) {
        return this.userDao.selectAllList(user);
    }

    public Map<String, Object> selectList(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", this.userDao.selectList(user));
        int totalCount = this.userDao.selectListCount(user);
        map.put("totalCount", totalCount);
        map.put("page", PaginateTool.paginate(user.getPage(), 10, user.getCount(), totalCount));
        return map;
    }

    public Map<String, Object> insert(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.userDao.insert(user));
        map.put("item", user);
        return map;
    }

    public Map<String, Object> update(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.userDao.update(user));
        return map;
    }

    public Map<String, Object> delete(Long userId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.userDao.delete(userId));
        return map;
    }
}