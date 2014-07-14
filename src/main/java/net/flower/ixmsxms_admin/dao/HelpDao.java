package net.flower.ixmsxms_admin.dao;

import net.flower.ixmsxms_admin.domain.Help;

import java.util.List;

@Master
public interface HelpDao {
    public Help select(Long helpId);
    public List<Help> selectList(Help help);
    public List<Help> selectAllList(Help help);
    public int selectListCount(Help help);
    public int insert(Help help);
    public int update(Help help);
    public int delete(Long helpId);
}