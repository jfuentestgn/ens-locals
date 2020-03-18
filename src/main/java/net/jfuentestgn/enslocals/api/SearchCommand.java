package net.jfuentestgn.enslocals.api;

import java.util.ArrayList;
import java.util.List;

public class SearchCommand extends PaginationCommand {

    private String q;
    private String type;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
