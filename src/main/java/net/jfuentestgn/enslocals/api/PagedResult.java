package net.jfuentestgn.enslocals.api;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpParameters;
import io.micronaut.http.HttpRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PagedResult<T> {


    public static final String PARAM_PAGE = "page";
    public static final String PARAM_SIZE = "size";

    private final List<T> data;

    private final long total;
    private int perPage;
    private int currentPage;
    private int lastPage;
    private String firstPageUrl;
    private String lastPageUrl;
    private String nextPageUrl;
    private String prevPageUrl;
    private String path;
    private int from;
    private int to;

    public List<T> getData() {
        return data;
    }

    public long getTotal() {
        return total;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public String getFirstPageUrl() {
        return firstPageUrl;
    }

    public String getLastPageUrl() {
        return lastPageUrl;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public String getPrevPageUrl() {
        return prevPageUrl;
    }

    public String getPath() {
        return path;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    private PagedResult(Builder<T> builder) {
        this.data = builder.pagedData.getContent();
        this.total = builder.pagedData.getTotalSize();

        this.from = builder.pagedData.getPageNumber();
        this.to = this.from + builder.pagedData.getNumberOfElements() - 1;

        this.perPage = builder.pagedData.getSize();
        this.currentPage = 1 + (int) Math.floor((double) this.from / (double) this.perPage);

        if (builder.path != null) {
            String qStr = this.buildQueryStringTemplate(builder);
            if (qStr != null) {
                this.path = builder.path + "?" + replaceQueryString(qStr, this.currentPage);
                this.lastPageUrl = builder.path + "?" + replaceQueryString(qStr, builder.pagedData.getTotalPages());
                if (this.currentPage > 1) {
                    this.prevPageUrl = builder.path + "?" + replaceQueryString(qStr, this.currentPage - 1);
                }
                if (this.currentPage < builder.pagedData.getTotalPages()) {
                    this.nextPageUrl = builder.path + "?" + replaceQueryString(qStr, this.currentPage + 1);
                }
            }
        }
    }

    private String replaceQueryString(String qStr, int page) {
        return qStr.replace("#PAGE_NR#", String.valueOf(page));
    }


    private String buildQueryStringTemplate(Builder builder) {
        List<String> keyValuePairs = new ArrayList<>();
        boolean foundPageParam = false;
        boolean foundSizeParam = false;
        for (Map.Entry<String,List<String>> param : builder.parameters.asMap().entrySet()) {
            String paramName = param.getKey();
            if (paramName.equals(PARAM_PAGE)) {
                keyValuePairs.add(PARAM_PAGE + "=" + "#PAGE_NR#");
                foundPageParam = true;
            } else {
                if (paramName.equals(PARAM_SIZE)) {
                    foundSizeParam = true;
                }
                List<String> values = param.getValue();
                for (String value : values) {
                    keyValuePairs.add(paramName + "=" + value);
                }
            }
        }
        if (!foundPageParam) {
            keyValuePairs.add(PARAM_PAGE + "=" + "#PAGE_NR#");
        }
        if (keyValuePairs.size() > 0) {
            return String.join("&", keyValuePairs);
        }
        return null;
    }

    public static class Builder<T> {
        private HttpParameters parameters;
        private final Page<T> pagedData;
        private final Pageable pageable;
        private String path;

        public Builder(Page<T> pagedData/*, HttpRequest httpRequest*/) {
            this.pagedData = pagedData;
            this.pageable = pagedData.getPageable();
//            this.parameters = parameters;
        }

        public Builder withPath(String path) {
            this.path = path;
            return this;
        }

        public Builder withParameters(HttpParameters parameters) {
            this.parameters = parameters;
            return this;
        }

        public PagedResult<T> build() {
            return new PagedResult<>(this);
        }


    }


}
