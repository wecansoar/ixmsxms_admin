package net.flower.ixmsxms_admin.dao;

import net.flower.ixmsxms_admin.domain.CodeGroup;

import java.util.List;

@Master
public interface CodeGroupDao {
    public CodeGroup select(Long groupId);
    public List<CodeGroup> selectList(CodeGroup codeGroup);
    public List<CodeGroup> selectAllList(CodeGroup codeGroup);
    public int selectListCount(CodeGroup codeGroup);
    public int insert(CodeGroup codeGroup);
    public int update(CodeGroup codeGroup);
    public int delete(Long groupId);
}