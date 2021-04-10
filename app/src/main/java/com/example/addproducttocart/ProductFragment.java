package com.example.addproducttocart;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
public class ProductFragment extends Fragment {


    RecyclerView rclViewproduct;
    View mview;
    MainActivity mainActivity;
    ProductAdapter productAdapter;
    int soluong=0;
    FragmentTransaction fragmentTransaction;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         mview = inflater.inflate(R.layout.fragment_product, container, false);
         rclViewproduct = (RecyclerView) mview.findViewById(R.id.rcvproduct);
         mainActivity = (MainActivity) getActivity();
         LinearLayoutManager linearLayout = new LinearLayoutManager(mainActivity);
         rclViewproduct.setLayoutManager(linearLayout);
         productAdapter = new ProductAdapter();

         productAdapter.setdata(getData(), new ProductAdapter.IClickAddProduct() {
             @Override
             public void OnClickAddProduct(ImageView imgAddtoCard, product prd) {
                AnimationUtils.translateAnimation(mainActivity.getViewAnimation(), imgAddtoCard, mainActivity.getViewEndAnimation(), new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        soluong++;
//                        CardFragment cardFragment = new CardFragment();
//                        Bundle bundle = new Bundle();
//                        bundle.putString("ten",prd.getTen());
//                        bundle.putString("mota",prd.getMota());
//                        bundle.putInt("hinhanh",prd.getHinhanh());
//                        cardFragment.setArguments(bundle);
//                        fragmentTransaction.add(R.id.rcvproduct,cardFragment);
//                        fragmentTransaction.commit();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        imgAddtoCard.setBackgroundResource(R.drawable.bg_grey);
                        productAdapter.notifyDataSetChanged();
                        mainActivity.setCounttoCart(soluong);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
             }
         });
        rclViewproduct.setAdapter(productAdapter);

        return mview;
    }

    private List<product> getData() {
        List<product> list = new ArrayList<>();
        list.add(new product(R.drawable.camera,"CAMERA","XIN XO, MOI NHAT"));
        list.add(new product(R.drawable.ip12,"IPHONE12","Moi, DEP"));
        list.add(new product(R.drawable.camera,"CAMERA","XIN XO, MOI NHAT"));
        list.add(new product(R.drawable.ip12,"IPHONE12","Moi, DEP"));
        list.add(new product(R.drawable.camera,"CAMERA","XIN XO, MOI NHAT"));
        list.add(new product(R.drawable.ip12,"IPHONE12","Moi, DEP"));
        list.add(new product(R.drawable.camera,"CAMERA","XIN XO, MOI NHAT"));
        list.add(new product(R.drawable.ip12,"IPHONE12","Moi, DEP"));
        list.add(new product(R.drawable.camera,"CAMERA","XIN XO, MOI NHAT"));
        list.add(new product(R.drawable.ip12,"IPHONE12","Moi, DEP"));
        return list;
    }
}