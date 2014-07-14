package net.flower.ixmsxms_admin.dao;

import java.util.List;

import net.flower.ixmsxms_admin.domain.Notice;

@Master
public interface NoticeDao {
    public Notice select(Long noticeId);
    public List<Notice> selectList(Notice notice);
    public List<Notice> selectAllList(Notice notice);
    public int selectListCount(Notice notice);
    public int insert(Notice notice);
    public int update(Notice notice);
    public int delete(Long noticeId);
}