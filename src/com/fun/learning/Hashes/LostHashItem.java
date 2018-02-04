package com.fun.learning.Hashes;

import java.util.HashMap;

public class LostHashItem {

    public static void main(String[] args) {
        HashMap<MyKey, Integer> hashMap1 = new HashMap<>();
        HashMap<MyKey, Integer> hashMap2 = new HashMap<>();
        MyKey myKey = new MyKey();
        myKey.setKeyName("key1");
        hashMap1.put(myKey, 8);
        hashMap2.put(myKey, 8);
        System.out.println(hashMap1.hashCode());
        System.out.println(hashMap2.hashCode());
        System.out.println(hashMap1.get(myKey));
        System.out.println(hashMap2.get(myKey));
        System.out.println(myKey.hashCode());
        myKey.setKeyName("key2");
        System.out.println(hashMap1.get(myKey));
        System.out.println(myKey.hashCode());
        System.out.println(hashMap1.hashCode());
        System.out.println(hashMap2.hashCode());
        System.out.println("a".substring(0,0));

    }

}

class MyKey {
    String keyName;

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }
}
