package com.example.btl.View.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.btl.Model.data.Product;
import com.example.btl.databinding.ItemProductBinding;
import com.example.btl.utils.RoundedTransformation;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    Context context;
    List<Product> list;
    OnClickItemProduct onClickItemProduct;

    public ProductAdapter(Context context, List<Product> list, OnClickItemProduct onClickItemProduct) {
        this.context = context;
        this.list = list;
        this.onClickItemProduct = onClickItemProduct;
    }

//    @Override
//    public int getItemViewType(int position) {
//        return list.get(position).getTypeView();
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ;
     //   return new ViewHolder((ItemProductBinding) DataBindingUtil.inflate(layoutInflater, R.layout.item_product, parent, false));
        return new ViewHolder(ItemProductBinding.inflate(layoutInflater,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get()
                .load(list.get(position).getImage())
                .fit()
                .transform(new RoundedTransformation(16, 0))
                .centerCrop()
                .into( holder.binding.bookImage);
        holder.binding.setProduct(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ItemProductBinding binding;

        public ViewHolder(@NonNull ItemProductBinding itemProductBinding) {
            super(itemProductBinding.getRoot());
            itemView.setOnClickListener(this);
            binding=itemProductBinding;
        }

        @Override
        public void onClick(View v) {
            onClickItemProduct.onCLick(getItemViewType(),list.get(getAdapterPosition()));
        }
    }
    public interface OnClickItemProduct
    {
        public void onCLick(int type, Product product);
    }
}
