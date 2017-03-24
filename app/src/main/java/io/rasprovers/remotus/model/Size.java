
package io.rasprovers.remotus.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Size {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("transferred")
    @Expose
    private Integer transferred;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTransferred() {
        return transferred;
    }

    public void setTransferred(Integer transferred) {
        this.transferred = transferred;
    }

}
