package net.flower.ixmsxms_admin.dao;

import java.util.List;

import net.flower.ixmsxms_admin.domain.CodeItem;

@Master
public interface CodeItemDao {
    public CodeItem select(Long itemId);
    public List<CodeItem> selectList(CodeItem codeItem);
    public List<CodeItem> selectAllList(CodeItem codeItem);
    public int selectListCount(CodeItem codeItem);
    public int insert(CodeItem codeItem);
    public int update(CodeItem codeItem);
    public int delete(Long itemId);
}