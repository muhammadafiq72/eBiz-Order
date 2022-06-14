package com.example.eBiz_Order.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.eBiz_Order.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {

    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts() {
        if (mutableProductList == null) {
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }

    private void loadProducts() {
        List<Product> productList = new ArrayList<>();
        String image;
        productList.add(new Product(UUID.randomUUID().toString(), "Laici", 10, true, "https://firebasestorage.googleapis.com/v0/b/ebiz-order.appspot.com/o/laici.jpeg?alt=media&token=66297ca9-0aba-4ef4-94d1-1b52cbcc5f7c" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Milo", 20, true, "https://firebasestorage.googleapis.com/v0/b/ebiz-order.appspot.com/o/milo.jpeg?alt=media&token=e8a4e8cd-4942-476b-8937-786f6824b7f9"));
        productList.add(new Product(UUID.randomUUID().toString(), "Asam Boi", 10, true, "https://firebasestorage.googleapis.com/v0/b/ebiz-order.appspot.com/o/asamboi.jpeg?alt=media&token=d2732b41-ad34-430f-b70c-a0995cbf63bb"));
        productList.add(new Product(UUID.randomUUID().toString(), "Cendol", 20, false, "https://firebasestorage.googleapis.com/v0/b/ebiz-order.appspot.com/o/cendol.jpeg?alt=media&token=06c63e9c-e161-41a3-9cb6-83cd5800404b"));
        productList.add(new Product(UUID.randomUUID().toString(), "Choki", 20, true, "https://firebasestorage.googleapis.com/v0/b/ebiz-order.appspot.com/o/choki.jpeg?alt=media&token=2f044a93-8d29-49a6-89e5-b0f9adb626d2"));
        productList.add(new Product(UUID.randomUUID().toString(), "Limau", 10, true, "https://firebasestorage.googleapis.com/v0/b/ebiz-order.appspot.com/o/limau.jpeg?alt=media&token=bb75135f-2daf-4097-8975-cd7173ec30a7"));
        productList.add(new Product(UUID.randomUUID().toString(), "Bandung", 20, true, "https://firebasestorage.googleapis.com/v0/b/ebiz-order.appspot.com/o/bandung.jpeg?alt=media&token=1efd591e-d7ab-4b97-898a-3e8033f824f4"));
        productList.add(new Product(UUID.randomUUID().toString(), "Chocolate", 20, true, "https://firebasestorage.googleapis.com/v0/b/ebiz-order.appspot.com/o/chocolate.jpeg?alt=media&token=5dd06208-ba2c-4e00-8aa3-92eb60af73a5"));
        productList.add(new Product(UUID.randomUUID().toString(), "Coffee", 20, true, "https://firebasestorage.googleapis.com/v0/b/ebiz-order.appspot.com/o/coffee.jpeg?alt=media&token=dcdec9c4-aec7-4401-b8de-c681ed7b6549"));
        productList.add(new Product(UUID.randomUUID().toString(), "Greentea", 20, true, "https://firebasestorage.googleapis.com/v0/b/ebiz-order.appspot.com/o/greentea.jpeg?alt=media&token=aad9fa25-c242-4712-9522-55b3377b2890"));
        productList.add(new Product(UUID.randomUUID().toString(), "Jagung", 20, true, "https://firebasestorage.googleapis.com/v0/b/ebiz-order.appspot.com/o/jagung.jpeg?alt=media&token=b854b468-7191-4d7c-b5ac-56cf47aafe0a"));
        productList.add(new Product(UUID.randomUUID().toString(), "Kacang", 10, true, "https://firebasestorage.googleapis.com/v0/b/ebiz-order.appspot.com/o/kacang.jpeg?alt=media&token=06210dd6-1c97-4ef4-977c-f9426ae10e72"));
        productList.add(new Product(UUID.randomUUID().toString(), "Manggo", 10, true, "https://firebasestorage.googleapis.com/v0/b/ebiz-order.appspot.com/o/mango.jpeg?alt=media&token=6dc8a6ae-3d6b-4120-b783-b6b430b29734"));
        productList.add(new Product(UUID.randomUUID().toString(), "Oreo", 20, true, "https://firebasestorage.googleapis.com/v0/b/ebiz-order.appspot.com/o/oreo.jpeg?alt=media&token=1ef70217-afb6-44f1-9ed4-19908713f595"));
        productList.add(new Product(UUID.randomUUID().toString(), "Strawberry", 10, true, "https://firebasestorage.googleapis.com/v0/b/ebiz-order.appspot.com/o/strawberry.jpeg?alt=media&token=046fd03e-3c46-4a17-ba46-8a95a647f9d2"));









        mutableProductList.setValue(productList);
    }
}
