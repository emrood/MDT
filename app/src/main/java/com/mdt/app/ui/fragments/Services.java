package com.mdt.app.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.mdt.app.App;
import com.mdt.app.R;
import com.mdt.app.models.services;
import com.mdt.app.ui.adapters.ServiceAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Services extends Fragment implements ServiceAdapter.OnServiceClickListener {

    private View base;

    @BindView(R.id.recycler_services) RecyclerView serviceRecycler;

    private ServiceAdapter serviceAdapter;
    private List<services> serviceList = new ArrayList<>();

    LinearLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        base = inflater.inflate(R.layout.fragment_services, container, false);
        ButterKnife.bind(this, base);
        return base;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        serviceAdapter = new ServiceAdapter(getActivity(), serviceList);
        mLayoutManager = new GridLayoutManager(getActivity(), 2);

        serviceRecycler.setLayoutManager(mLayoutManager);
        serviceRecycler.setItemAnimator(new DefaultItemAnimator());
        serviceAdapter.setServiceClickListener(this);
        serviceRecycler.setAdapter(serviceAdapter);
        serviceAdapter.notifyDataSetChanged();


    }

    @Override
    public void onResume() {
        super.onResume();
        getServices();
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
    public void onServiceClick(View view, com.mdt.app.models.services service) {
        Toast.makeText(getActivity(), service.getName() + " Clicked", Toast.LENGTH_SHORT).show();
    }


    public void getServices(){
        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setSortBy("name");
        services.findAsync(queryBuilder, new AsyncCallback<List<services>>() {
            @Override
            public void handleResponse(List<services> response) {
                serviceList = response;
                Toast.makeText(getActivity(), serviceList.get(0).getName(), Toast.LENGTH_SHORT).show();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        serviceAdapter = new ServiceAdapter(getActivity(), serviceList);
                        mLayoutManager = new GridLayoutManager(getActivity(), 2);
                        serviceRecycler.setLayoutManager(mLayoutManager);
                        serviceRecycler.setItemAnimator(new DefaultItemAnimator());
                        serviceAdapter.setServiceClickListener(Services.this::onServiceClick);
                        serviceRecycler.setAdapter(serviceAdapter);
                        serviceAdapter.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });
    }
}
