package io.rasprovers.remotus.adapter;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.apache.commons.net.ftp.FTPFile;

import java.util.ArrayList;
import java.util.List;

import io.rasprovers.remotus.R;
import io.rasprovers.remotus.model.MyFtpFile;
import io.rasprovers.remotus.viewholders.FileViewHolder;

/**
 * Created by betterclever on 3/25/2017.
 */

public class FilesAdapter extends RecyclerView.Adapter<FileViewHolder> {
    
    private static final String TAG = FilesAdapter.class.getSimpleName();
    private ArrayList<MyFtpFile> ftpFiles;
    private Context context;
    
    public FilesAdapter(Context context){
        this.context = context;
        ftpFiles = new ArrayList<>();
    }
    
    @Override
    public FileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.file_layout, parent, false);
        return new FileViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(FileViewHolder holder, final int position) {
        holder.filenameTextView.setText(ftpFiles.get(position).getFtpFile().getName());
        String fileSize = ftpFiles.get(position).getFtpFile().getSize()/(1024) + " KB";
        holder.filesizeTextView.setText(fileSize);
        
        holder.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyFtpFile ftpFile = ftpFiles.get(position);
                Log.d(TAG, "onClick: "+ftpFile.getPath());
                
                Uri uri = Uri.parse("googlechrome://navigate?url="+ftpFile.getPath());
                Intent i = new Intent(Intent.ACTION_VIEW,uri);
                //i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }
    
    @Override
    public int getItemCount() {
        return ftpFiles.size();
    }
    
    public void addFiles(List<MyFtpFile> fileNames){
        ftpFiles.clear();
        ftpFiles.addAll(fileNames);
        notifyDataSetChanged();
    }
    
}
