package com.mdt.app.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.mdt.app.App;
import com.mdt.app.R;
import com.mdt.app.ui.adapters.NewsAdapter;
import com.mdt.app.models.news;
import com.mdt.app.models.new_medias;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home extends Fragment implements NewsAdapter.OnNewClickListener {

    private View base;

    @BindView(R.id.rv_news) RecyclerView rvNews;

    LinearLayoutManager mLayoutManager;
    NewsAdapter adapter;
    List<news> newsList = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        base = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, base);
        return base;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new NewsAdapter(getActivity(), newsList);
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvNews.setLayoutManager(mLayoutManager);
        rvNews.setItemAnimator(new DefaultItemAnimator());
        adapter.setNewCLickListener(this);
        rvNews.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(newsList.size() == 0){
            getNews();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onNewClick(View view, news service) {
        try{
            Toast.makeText(App.getContext(), service.getCreated().toString(), Toast.LENGTH_SHORT).show();
        }catch (Exception e){

        }
    }

    public void getNews(){

        DataQueryBuilder queryBuilder = DataQueryBuilder.create();

        queryBuilder.setPageSize(20);
        queryBuilder.setSortBy("created DESC");
//        queryBuilder.setRelated('fk_news_media');
        queryBuilder.setRelationsDepth(1);

        news.findAsync(queryBuilder, new AsyncCallback<List<news>>() {
            @Override
            public void handleResponse(List<news> response) {
                try{
                    if(response.size() > 0){
                        newsList = response;
                        adapter = new NewsAdapter(getActivity(), newsList);
                        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                        rvNews.setLayoutManager(mLayoutManager);
                        rvNews.setItemAnimator(new DefaultItemAnimator());
                        adapter.setNewCLickListener(Home.this::onNewClick);
                        rvNews.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                }catch (Exception e){

                }
            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });
    }
}
