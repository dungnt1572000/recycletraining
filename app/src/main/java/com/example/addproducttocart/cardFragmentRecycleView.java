package com.example.addproducttocart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class cardFragmentRecycleView extends RecyclerView.Adapter<cardFragmentRecycleView.CardViewHolder> {
    List<product> list ;
    Context context;

    public void setData(List<product> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public List<product> getList() {
        return list;
    }

    public void setList(List<product> list) {
        this.list = list;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_productincardview, parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        product pr = list.get(position);
        holder.tensp.setText(pr.getTen());
        holder.gioithieu.setText(pr.getMota());
        holder.imgproduct.setImageResource(pr.getHinhanh());
        holder.soluongcathe.setText("1");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgproduct;
        TextView tensp,gioithieu,soluongcathe;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgproduct = (ImageView) itemView.findViewById(R.id.cardproductimage);
            soluongcathe = (TextView) itemView.findViewById(R.id.cardimgaddtocard);
            tensp =(TextView) itemView.findViewById(R.id.cardtvproductname);
            gioithieu = (TextView) itemView.findViewById(R.id.cardmotaproduct);
        }
    }
}
