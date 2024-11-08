package com.example.edoskop;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;

public class NeuralNetworkHelper {
    public static List<String> recognize(Bitmap image) {
        List<String> products = new ArrayList<>();

        // Здесь вы вызываете YOLO модель, натренированную на распознавание продуктов
        // Пример: products.add("яблоко"); products.add("банан");

        products.add("яблоко");
        products.add("банан");
        return products;
    }
}

