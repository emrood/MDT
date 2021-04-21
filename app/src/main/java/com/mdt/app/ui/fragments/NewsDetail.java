package com.mdt.app.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.mdt.app.models.news;
import com.mdt.app.models.new_medias;

import com.mdt.app.R;
import com.mdt.app.tools.Constants;

import java.text.SimpleDateFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetail extends Fragment implements View.OnClickListener {

    private View base;
    private news selectedNew;
    private new_medias videoMedia;

    @BindView(R.id.iv_news_baner) ImageView ivBaner;
    @BindView(R.id.iv_media) ImageView ivMedia;
    @BindView(R.id.tv_news_title) TextView tvNewsTitle;
    @BindView(R.id.tv_news_content) TextView tvNewsContent;
    @BindView(R.id.tv_news_date) TextView tvNewsDate;
    @BindView(R.id.vv_news) VideoView videoView;

    public static NewsDetail newInstance(news selected_news) {
        Bundle args = new Bundle();
        args.putSerializable("NEWS", selected_news);
        NewsDetail fragment = new NewsDetail();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        base = inflater.inflate(R.layout.news_detail, container, false);
        return base;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        if(getArguments() != null){
            selectedNew = (news) getArguments().getSerializable("NEWS");
            if(selectedNew != null){
                populateView();
            }
        }
    }

    public void populateView(){

        tvNewsTitle.setText(selectedNew.getTitle());
        tvNewsContent.setText(selectedNew.getContent());
        tvNewsDate.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.FRANCE).format(selectedNew.getCreated()));

        try{
            if(selectedNew.getFk_news_media() != null){
                if(selectedNew.getFk_news_media().size() > 0){
                    Glide.with(getActivity()).load(Constants.BASE_FILE_PATH + selectedNew.getFk_news_media().get(0).getPath()).into(ivBaner);
                }

                if(selectedNew.getFk_news_media().size() > 1){
                    for (new_medias media : selectedNew.getFk_news_media()) {
                        switch (media.getMedia_type()){
                            case Constants.MEDIA_TYPE_VIDEO:
                                videoMedia = media;
                                break;
                            default:
                                // DO NOTHING
                                break;
                        }

                        if(videoMedia != null){
                            break;
                        }
                    }

                    if(videoMedia != null){
                        videoView.setVideoPath(Constants.BASE_FILE_PATH + videoMedia.getPath());
                        videoView.setOnClickListener(this);
                        videoView.setVisibility(View.VISIBLE);
                        Glide.with(getContext()).load(R.drawable.video).into(ivMedia);
                    }
                }
            }



        }catch (Exception e){

        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.vv_news:
                // TODO IMPLEMENT PLAY PAUSE FUNCTION
                break;
        }
    }
}
