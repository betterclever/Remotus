package io.rasprovers.remotus.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Download {
    
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("downloadPercent")
    @Expose
    private String downloadPercent;
    @SerializedName("keywords")
    @Expose
    private List<String> keywords = null;
    @SerializedName("fileSize")
    @Expose
    private Integer fileSize;
    
    /**
     * No args constructor for use in serialization
     */
    public Download() {
    }
    
    /**
     * @param fileSize
     * @param id
     * @param keywords
     * @param downloadPercent
     * @param status
     * @param name
     * @param url
     */
    public Download(String id, String name, String url, String status, String downloadPercent, List<String> keywords, Integer fileSize) {
        super();
        this.id = id;
        this.name = name;
        this.url = url;
        this.status = status;
        this.downloadPercent = downloadPercent;
        this.keywords = keywords;
        this.fileSize = fileSize;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
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
    
    public String getDownloadPercent() {
        return downloadPercent;
    }
    
    public void setDownloadPercent(String downloadPercent) {
        this.downloadPercent = downloadPercent;
    }
    
    public List<String> getKeywords() {
        return keywords;
    }
    
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
    
    public Integer getFileSize() {
        return fileSize;
    }
    
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }
    
}