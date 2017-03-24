
package io.rasprovers.remotus.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Download {

    @SerializedName("ID")
    @Expose
    private Integer id;
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
    @SerializedName("status")
    @Expose
    private String status;
    
    public Download(Integer id, String name, String uid, String url, String status) {
        this.id = id;
        this.name = name;
        this.uid = uid;
        this.url = url;
        this.status = status;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
