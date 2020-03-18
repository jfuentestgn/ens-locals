package net.jfuentestgn.enslocals.api;

import java.util.ArrayList;
import java.util.List;

public class PaginationCommand {

    public static final int DEFAULT_PAGE = 1;
    public static final int DEFAULT_SIZE = 10;

    private int page;
    private int size;
    private List<String> sort;

    public int getPage() {
        if (page < 1) {
            page = DEFAULT_PAGE;
        }
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        if (size < 1) {
            size = DEFAULT_SIZE;
        }
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<String> getSort() {
        if (this.sort == null) {
            this.sort = new ArrayList<>();
        }
        return this.sort;
    }

    public void setSort(List<String> sort) {
        this.sort = sort;
    }
}
