package io.rasprovers.remotus.adapter;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

import io.rasprovers.remotus.R;
import io.rasprovers.remotus.model.Download;
import io.rasprovers.remotus.model.Stat;
import io.rasprovers.remotus.viewholders.DownloadViewHolder;

/**
 * Created by betterclever on 3/24/2017.
 */

public class DownloadsAdapter extends FirebaseRecyclerAdapter<Download,DownloadViewHolder> {
    
    
    public DownloadsAdapter(Query ref) {
        super(Download.class, R.layout.item_download, DownloadViewHolder.class, ref);
    }
    
    @Override
    protected void populateViewHolder(DownloadViewHolder viewHolder, Download model, int position) {
        viewHolder.nameTextView.setText(model.getName());
        if(model.getStat()!=null){
            Stat stats = model.getStat();
            double transferred = ( (double) stats.getSize().getTransferred()) / (1024 * 1024 );
            double total =  ((double) stats.getSize().getTotal()) /( 1024 * 1024 );
            String downloadProgress = transferred + "/" + total + " MB";
            viewHolder.downloadTextView.setText(downloadProgress);
            viewHolder.progressBar.setProgress(stats.getPercent().intValue());
        }
    }
}
