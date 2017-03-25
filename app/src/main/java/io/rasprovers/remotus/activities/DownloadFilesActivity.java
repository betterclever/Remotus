package io.rasprovers.remotus.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

public class DownloadFilesActivity extends AppCompatActivity {
    
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<FTPFile> fileNames;
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
        
        adapter = new FilesAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    
    }
    
    private class ListFilesTask extends AsyncTask<String,Void,List<FTPFile>> {
    
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    
        @Override
        protected List<FTPFile> doInBackground(String... params) {
            
            FTPClient client = new FTPClient();
            try {
                client.connect("192.168.43.151",21);
                client.login("anonymous","");
                
                FTPFile[] ftpFiles = client.listFiles();
                fileNames.clear();
                for(FTPFile ftpFile: ftpFiles){
                    if(!ftpFile.isDirectory()){
                        fileNames.add(ftpFile);
                    }
                }
                return fileNames;
        
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            return null;
        }
    
        @Override
        protected void onPostExecute(List<FTPFile> ftpFiles) {
            super.onPostExecute(ftpFiles);
            adapter.addFiles(ftpFiles);
        }
    }
}
