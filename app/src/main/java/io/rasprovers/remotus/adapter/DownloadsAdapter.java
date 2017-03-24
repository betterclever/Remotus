package io.rasprovers.remotus.adapter;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

import io.rasprovers.remotus.R;
import io.rasprovers.remotus.model.Download;
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
        
    }
}
