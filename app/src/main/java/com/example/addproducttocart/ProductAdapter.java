package com.example.addproducttocart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.aurelhubert.ahbottomnavigation.notification.AHNotification;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    List<product> list;
    Context context;
    IClickAddProduct iClickAddProduct;
    public void setdata(List<product> list,IClickAddProduct iClickAddProduct){
        this.list = list;
        this.iClickAddProduct = iClickAddProduct;
        notifyDataSetChanged();
    }
    public interface IClickAddProduct{
        void OnClickAddProduct(ImageView imgAddtoCard,product prd);
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_product,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        product pr = list.get(position);
        if (pr==null)
            return;
        else{
            holder.imgproduct.setImageResource(pr.getHinhanh());
            holder.tensp.setText(pr.getTen());
            holder.gioithieu.setText(pr.getMota());
            if (pr.isAddtoCard){
                holder.imgAddproduct.setBackgroundResource(R.drawable.sellproduct_6);
            }
            else{
                holder.imgAddproduct.setBackgroundResource(R.drawable.sellproduct_6);
            }
            holder.imgAddproduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!pr.isAddtoCard){
                        iClickAddProduct.OnClickAddProduct(holder.imgAddproduct,pr);
                    }

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (list.size() == 0)
            return 0;
        else
            return list.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView imgproduct,imgAddproduct;
        TextView tensp,gioithieu;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imgproduct = (ImageView) itemView.findViewById(R.id.productimage);
            imgAddproduct = (ImageView) itemView.findViewById(R.id.imgaddtocard);
            tensp =(TextView) itemView.findViewById(R.id.tvproductname);
            gioithieu = (TextView) itemView.findViewById(R.id.motaproduct);
        }
    }
}
