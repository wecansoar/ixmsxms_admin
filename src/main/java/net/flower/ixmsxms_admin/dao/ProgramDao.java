package net.flower.ixmsxms_admin.dao;

import net.flower.ixmsxms_admin.domain.Program;

import java.util.List;

@Master
public interface ProgramDao {
    public Program select(Long programId);
    public List<Program> selectList(Program program);
    public List<Program> selectAllList(Program program);
    public int selectListCount(Program program);
    public int insert(Program program);
    public int update(Program program);
    public int delete(Long programId);
}