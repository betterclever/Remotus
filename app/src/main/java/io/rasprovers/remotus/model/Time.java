
package io.rasprovers.remotus.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Time {

    @SerializedName("elapsed")
    @Expose
    private Double elapsed;
    @SerializedName("remaining")
    @Expose
    private Double remaining;

    public Double getElapsed() {
        return elapsed;
    }

    public void setElapsed(Double elapsed) {
        this.elapsed = elapsed;
    }

    public Double getRemaining() {
        return remaining;
    }

    public void setRemaining(Double remaining) {
        this.remaining = remaining;
    }

}
