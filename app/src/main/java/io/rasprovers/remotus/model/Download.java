
package io.rasprovers.remotus.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Download {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("stat")
    @Expose
    private Stat stat;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("url")
    @Expose
    private String url;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
