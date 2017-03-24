
package io.rasprovers.remotus.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stat {

    @SerializedName("percent")
    @Expose
    private Double percent;
    @SerializedName("size")
    @Expose
    private Size size;
    @SerializedName("speed")
    @Expose
    private double speed;
    @SerializedName("time")
    @Expose
    private Time time;

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
