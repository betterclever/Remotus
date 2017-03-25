package io.rasprovers.remotus.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.rasprovers.remotus.R;
import io.rasprovers.remotus.adapter.FilesAdapter;
import io.rasprovers.remotus.model.MyFtpFile;

public class DownloadFilesActivity extends AppCompatActivity {
    
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<MyFtpFile> fileNames;
    FilesAdapter adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_files);
        ButterKnife.bind(this);
    
        getSupportActionBar().setTitle("Files on Server");
        
        fileNames = new ArrayList<>();
        
        String address = "192.168.43.151";
        String port = "21";
        
        ListFilesTask task = new ListFilesTask();
        task.execute(address,port);
        
        adapter = new FilesAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    
    }
    
    private class ListFilesTask extends AsyncTask<String,Void,List<MyFtpFile>> {
    
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    
        @Override
        protected List<MyFtpFile> doInBackground(String... params) {
            
            FTPClient client = new FTPClient();
            try {
                
                String ftpURL = "192.168.43.151";
                
                client.connect(ftpURL,21);
                client.login("anonymous","");
                
                FTPFile[] ftpFiles = client.listFiles();
                fileNames.clear();
                for(FTPFile ftpFile: ftpFiles){
                    if(!ftpFile.isDirectory()){
                        String path = "ftp://"+ftpURL+"/"+ftpFile.getName();
                        fileNames.add(new MyFtpFile(ftpFile,path));
                    }
                }
                return fileNames;
        
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            return null;
        }
    
        @Override
        protected void onPostExecute(List<MyFtpFile> ftpFiles) {
            super.onPostExecute(ftpFiles);
            adapter.addFiles(ftpFiles);
        }
    }
}
