package io.rasprovers.remotus.viewholders;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.rasprovers.remotus.R;

/**
 * Created by betterclever on 3/25/2017.
 */

public class FileViewHolder extends RecyclerView.ViewHolder {
    
    @BindView(R.id.filenameTextView)
    public TextView filenameTextView;
    @BindView(R.id.floatingActionButton)
    public FloatingActionButton floatingActionButton;
    @BindView(R.id.filesizeTextView)
    public TextView filesizeTextView;
    
    public FileViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
