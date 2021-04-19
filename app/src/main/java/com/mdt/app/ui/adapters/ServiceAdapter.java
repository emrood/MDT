package com.mdt.app.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mdt.app.R;
import com.mdt.app.models.services;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {
    List<services> servicesList;
    Context mContext;
    private LayoutInflater layoutInflater;
    private int focusedItem = 0;

    private OnServiceClickListener mServiceClickLister;
    public int selectedPos = RecyclerView.NO_POSITION;

    public ServiceAdapter(Context context, List<services> servicesList) {
        this.servicesList = servicesList;
        mContext = context;
        layoutInflater = LayoutInflater.from(mContext);
        selectedPos = getItemCount() - 1;
    }


    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_service, parent, false);

        return new ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ServiceViewHolder holder, final int position) {

//        holder.itemView.setSelected(selectedPos == 0);

        holder.name.setText(servicesList.get(position).getName());
        Glide.with(mContext).load(servicesList.get(position).getImage_path()).into(holder.ivService);

    }

    public interface OnServiceClickListener {
        void onServiceClick(View view, services service);
    }

    public void setServiceClickListener(OnServiceClickListener onServiceClickListener) {
        this.mServiceClickLister = onServiceClickListener;
    }

    @Override
    public int getItemCount() {
        return servicesList.size();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.iv_service) ImageView ivService;
        @BindView(R.id.tv_service_name) TextView name;

        public ServiceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            notifyItemChanged(selectedPos);
            selectedPos = getLayoutPosition();
            notifyItemChanged(selectedPos);

            if (mServiceClickLister != null) {
                mServiceClickLister.onServiceClick(v, servicesList.get(getAdapterPosition()));
            }
        }
    }


    public void setNotifiedDataSetChanged(List<services> list_services) {
        servicesList.clear();
        servicesList = list_services;
        notifyDataSetChanged();
        Toast.makeText(mContext, "Services updated", Toast.LENGTH_SHORT).show();
    }


}

