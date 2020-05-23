package org.linqw.vhr.model;

import java.util.List;

public class RespPageBean {
    private long total;
    private List<?> data;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
