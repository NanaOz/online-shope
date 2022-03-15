package com.company.saving;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class InitializeFromFile implements Serializable {

    public static <T> ArrayList<T> initializeFromFile(String file) {
        ArrayList<T> arrayList = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            arrayList = (ArrayList<T>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

//    public static HashMap<Product, Integer> initializeFromFileBuyHistory(String file) {
//        HashMap<Product, Integer> buyHistory = new HashMap<>();
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
//            buyHistory = (HashMap<Product, Integer>) ois.readObject();
//            int max=0;
//            for(Product product: buyHistory.keySet()){
////                if(Integer.valueOf(String.valueOf(product))>max) max = Integer.valueOf(String.valueOf(product));
//                if(Integer.parseInt(String.valueOf(product))>max) max = Integer.parseInt(String.valueOf(product));
//            }
//            BuyingHistory.id=max;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return buyHistory;
//    }
}
