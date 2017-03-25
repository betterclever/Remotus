package io.rasprovers.remotus.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.apache.commons.net.ftp.FTPFile;

import java.util.ArrayList;
import java.util.List;

import io.rasprovers.remotus.R;
import io.rasprovers.remotus.viewholders.FileViewHolder;

/**
 * Created by betterclever on 3/25/2017.
 */

public class FilesAdapter extends RecyclerView.Adapter<FileViewHolder> {
    
    ArrayList<FTPFile> ftpFiles;
    
    public FilesAdapter(){
        ftpFiles = new ArrayList<>();
    }
    
    @Override
    public FileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.file_layout, parent, false);
        return new FileViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(FileViewHolder holder, int position) {
        holder.filenameTextView.setText(ftpFiles.get(position).getName());
        String fileSize = ftpFiles.get(position).getSize()/(1024) + " MB";
        holder.filesizeTextView.setText(fileSize);
    }
    
    @Override
    public int getItemCount() {
        return ftpFiles.size();
    }
    
    public void addFiles(List<FTPFile> fileNames){
        ftpFiles.clear();
        ftpFiles.addAll(fileNames);
        notifyDataSetChanged();
    }
    
}
