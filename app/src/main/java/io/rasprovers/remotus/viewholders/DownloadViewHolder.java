package io.rasprovers.remotus.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.rasprovers.remotus.R;

/**
 * Created by betterclever on 3/24/2017.
 */

public class DownloadViewHolder extends RecyclerView.ViewHolder {
    
    @BindView(R.id.nameTextView)
    public TextView nameTextView;
    
    @BindView(R.id.downloadTextView)
    public TextView downloadTextView;

    @BindView(R.id.speed)
    public TextView speed;

    @BindView(R.id.restart)
    public ImageView restart;
    
    @BindView(R.id.statusTextView)
    public TextView statusTextView;
    
    @BindView(R.id.progressBar)
    public ProgressBar progressBar;



    public DownloadViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
