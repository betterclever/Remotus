package io.rasprovers.remotus.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import io.rasprovers.remotus.R;
import io.rasprovers.remotus.model.Download;
import io.rasprovers.remotus.model.Stat;
import io.rasprovers.remotus.viewholders.DownloadViewHolder;

/**
 * Created by betterclever on 3/24/2017.
 */

public class DownloadsAdapter extends FirebaseRecyclerAdapter<Download,DownloadViewHolder> {
    
    
    private static final String TAG =  DownloadsAdapter.class.getSimpleName();
    private Context context;

    public DownloadsAdapter(Context context, Query ref) {
        super(Download.class, R.layout.item_download, DownloadViewHolder.class, ref);
        this.context = context;
    }
    
    @Override
    protected void populateViewHolder(DownloadViewHolder viewHolder, Download model, final int position) {
        viewHolder.nameTextView.setText(model.getName());
        if(model.getStat()!=null){
            Stat stats = model.getStat();
            double transferred = ( (double) stats.getSize().getTransferred()) / (1024 * 1024 );
            double total =  ((double) stats.getSize().getTotal()) /( 1024 * 1024 );
            String downloadProgress = round(transferred,2) + "/" + round(total,2) + " MB";
            viewHolder.downloadTextView.setText(downloadProgress);
            Log.d(TAG, "populateViewHolder: "+ stats.getPercent());
            viewHolder.progressBar.setProgress((int) (stats.getPercent()*100));

            double kbPerSec = (model.getStat().getSpeed()) / (1024);
            viewHolder.speed.setText(round(kbPerSec,2)+" KB/S");
        }
        else {
            viewHolder.downloadTextView.setText("");
            viewHolder.progressBar.setProgress(0);
            viewHolder.speed.setText("");
        }

        viewHolder.restart.setOnClickListener(null);

        viewHolder.restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference ref = DownloadsAdapter.this.getRef(position);
                ref.child("status").setValue("readded").addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(context, "Download Restarted", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        switch (model.getStatus()){
            case "end" : viewHolder.statusTextView.setText("finished");
                break;
            case "placed": viewHolder.statusTextView.setText("queued");
                break;
            case "progress": viewHolder.statusTextView.setText("downloading");
                break;
        }
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
