package net.flower.ixmsxms_admin.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import net.flower.ixmsxms_admin.utils.PaginateTool;
import net.flower.ixmsxms_admin.domain.Admin;
import net.flower.ixmsxms_admin.dao.AdminDao;

@Service
public class AdminService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private AdminDao adminDao;

    public Admin select(String adminId) {
        return this.adminDao.select(adminId);
    }

    public List<Admin> selectAllList(Admin admin) {
        return this.adminDao.selectAllList(admin);
    }

    public Map<String, Object> selectList(Admin admin) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", this.adminDao.selectList(admin));
        int totalCount = this.adminDao.selectListCount(admin);
        map.put("totalCount", totalCount);
        map.put("page", PaginateTool.paginate(admin.getPage(), 10, admin.getCount(), totalCount));
        return map;
    }

    public Map<String, Object> insert(Admin admin) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.adminDao.insert(admin));
        map.put("item", admin);
        return map;
    }

    public Map<String, Object> update(Admin admin) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.adminDao.update(admin));
        return map;
    }

    public Map<String, Object> delete(Long adminId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("row", this.adminDao.delete(adminId));
        return map;
    }
}