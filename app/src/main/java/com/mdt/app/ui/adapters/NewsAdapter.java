package com.mdt.app.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mdt.app.R;
import com.mdt.app.models.news;
import com.mdt.app.models.new_medias;
import com.mdt.app.tools.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewViewHolder> {
    List<news> newsList;
    Context mContext;
    private LayoutInflater layoutInflater;
    private int focusedItem = 0;
    private int lastPosition = -1;

    private OnNewClickListener mNewClickListener;
    public int selectedPos = RecyclerView.NO_POSITION;

    public NewsAdapter(Context context, List<news> newsList) {
        this.newsList = newsList;
        mContext = context;
        layoutInflater = LayoutInflater.from(mContext);
        selectedPos = getItemCount() - 1;
    }


    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_news, parent, false);

        return new NewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewViewHolder holder, final int position) {

//        holder.itemView.setSelected(selectedPos == 0);
        holder.tvNewsTitle.setText(newsList.get(0).getTitle());

        try{
            if(newsList.get(position).getFk_news_media().size() > 0){
                new_medias media = newsList.get(position).getFk_news_media().get(0);
                switch (media.getMedia_type()){
                    case Constants.MEDIA_TYPE_AUDIO:
                        Glide.with(mContext).load(R.drawable.audio).into(holder.ivNews);
                        break;
                    case Constants.MEDIA_TYPE_IMAGE:
                        Glide.with(mContext).load(Constants.BASE_FILE_PATH + media.getPath()).into(holder.ivNews);
//                        Toast.makeText(mContext, Constants.BASE_FILE_PATH + media.getPath(), Toast.LENGTH_SHORT).show();
                        break;
                    case Constants.MEDIA_TYPE_DOCUMENT:
                        Glide.with(mContext).load(R.drawable.document).into(holder.ivNews);
                        break;
                    case Constants.MEDIA_TYPE_VIDEO:
                        Glide.with(mContext).load(R.drawable.video).into(holder.ivNews);
                        break;
                }
            }
        }catch (Exception e){

        }

        setAnimation(holder.itemView, position);
    }

    public interface OnNewClickListener {
        void onNewClick(View view, news service);
    }

    public void setNewCLickListener(OnNewClickListener onServiceClickListener) {
        this.mNewClickListener = onServiceClickListener;
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.iv_news) ImageView ivNews;
        @BindView(R.id.tv_news_title) TextView tvNewsTitle;

        public NewViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            notifyItemChanged(selectedPos);
            selectedPos = getLayoutPosition();
            notifyItemChanged(selectedPos);

            if (mNewClickListener != null) {
                mNewClickListener.onNewClick(v, newsList.get(getAdapterPosition()));
            }
        }
    }


    public void setNotifiedDataSetChanged(List<news> list_news) {
        newsList.clear();
        newsList = list_news;
        notifyDataSetChanged();
//        Toast.makeText(mContext, "Services updated", Toast.LENGTH_SHORT).show();
    }


    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

}