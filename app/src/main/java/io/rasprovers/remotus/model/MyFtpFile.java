package io.rasprovers.remotus.model;

import org.apache.commons.net.ftp.FTPFile;

/**
 * Created by betterclever on 3/25/2017.
 */

public class MyFtpFile {
    
    private FTPFile ftpFile;
    private String path;
    
    public MyFtpFile(FTPFile ftpFile, String path) {
        this.ftpFile = ftpFile;
        this.path = path;
    }
    
    public FTPFile getFtpFile() {
        return ftpFile;
    }
    
    public void setFtpFile(FTPFile ftpFile) {
        this.ftpFile = ftpFile;
    }
    
    public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
}
