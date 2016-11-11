package com.danieladams.android.aca.finale;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;



public class MapsAdapter extends RecyclerView.Adapter<MapsAdapter.MyViewHolder>{
    private List<String> _list;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name;
        Context mContext;

        public MyViewHolder(View v, Context ctx) {
            super(v);
            this.mContext = ctx;
            v.setOnClickListener(this);
            name = (TextView) v.findViewById(R.id.lbl_map_name);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(this.mContext, MapInfoActivity.class);
            intent.putExtra("position", position);
            this.mContext.startActivity(intent);

        }
    }

    public MapsAdapter(List<String> list, Context ctx){
        this._list = list;
        this.mContext = ctx;
    }


    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mapCardView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_map, parent, false);

        return new MyViewHolder(mapCardView, mContext);
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        String str = _list.get(position);
        holder.name.setText(str);
    }

    public int getItemCount() {
        return _list.size();
    }
}
