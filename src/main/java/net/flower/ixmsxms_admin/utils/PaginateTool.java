package net.flower.ixmsxms_admin.utils;

public class PaginateTool {
    public static Page paginate(Integer currentPage, Integer pageSize,
                                Integer pageItemSize, Integer totalCount) {
        return new Page(currentPage, pageSize, pageItemSize, totalCount);
    }
}