package com.example.btl.View;

import android.os.Build;
import android.os.Bundle;

import com.example.btl.Model.data.Product;
import com.example.btl.R;
import com.example.btl.View.adapter.ProductAdapter;
import com.example.btl.databinding.ActivityListProductBinding;

import java.util.ArrayList;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

public class ListProductActivity extends AppCompatActivity implements ProductAdapter.OnClickItemProduct{
        ActivityListProductBinding binding;

        ProductAdapter adapter;
        ArrayList<Product> list = new ArrayList<>();

//    Client client;
//
//    private productViewModel mproductViewModel;
//    private billViewModel mbillViewModel;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.toolbar.setTitleTextColor(getColor(R.color.white));
        binding.toolbar.setTitle("Danh sách sản phẩm");
//        mproductViewModel = new ViewModelProvider(this).get(productViewModel.class);
//        mbillViewModel = new ViewModelProvider(this).get(billViewModel.class);
         initAdapter();

        // SharedPref.write(SharedPref.USER, "" + user.getAccount());//save string in shared preference.
        // SharedPref.write(SharedPref.PASS, "" + user.getPassword());//save int in shared preference.

    }

    private void initAdapter() {
        adapter = new ProductAdapter(this,list,this);
        binding.rclistProduct.setLayoutManager(new GridLayoutManager(this,4));
        binding.rclistProduct.setAdapter(adapter);
    }


//    private void populateData(Integer idType) {
//        mproductViewModel.getProductWithType(idType).observe(this, new Observer<ProductResponse>() {
//            @Override
//            public void onChanged(ProductResponse productResponse) {
//                if(productResponse != null){
//                    if(productResponse.getStatus().equals("SUCCESS")){
//                        list.clear();
//                        list.addAll(productResponse.getData());
//                        adapter.notifyDataSetChanged();
//                    }
//                }
//            }
//        });
//    }
//
//    private void loadBill(int id_client, String stt) {
//        mbillViewModel.loadBill(id_client, stt).observe(ListProductActivity.this, new Observer<BillResponse>() {
//            @Override
//            public void onChanged(BillResponse billResponse) {
//                if (billResponse.getStatus().equals("SUCCESS")) {
//                    List<Bill> bills = billResponse.getData();
//                    EventBus.getDefault().postSticky(bills.get(0));
//                    loadDetailbills(bills.get(0).getIdBill());
//                }else{
//                    List<Bill> bills=new ArrayList<>();
//                    EventBus.getDefault().postSticky(bills);
//                }
//            }
//        });
//    }
//
//    private void loadDetailbills(Integer idBill) {
//        mbillViewModel.loadDetailBill(idBill).observe(this, new Observer<BillDetailResponse>() {
//            @Override
//            public void onChanged(BillDetailResponse billDetailResponse) {
//                if (billDetailResponse.getStatus().equals("SUCCESS")) {
//                    List<DetailBill> listDetail = billDetailResponse.getData();
//                    EventBus.getDefault().postSticky(listDetail);
//                }
//
//            }
//        });
//    }

    @Override
    public void onCLick(int type, Product product) {
//        EventBus.getDefault().postSticky(product);
//       startActivity(new Intent(ListProductActivity.this, ProductActivity.class));
    }
}