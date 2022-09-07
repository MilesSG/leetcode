package com.company.bishi.tuhu0907;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * title:
 *
 * @author: Miles
 * @date: 2022/9/7
 */
public class Test1 {
    public static void main(String[] args) {


    }

    public int timeRequiredToBuyCounpons (int[] coupons, int m) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<newMap> list = new ArrayList<>();
        for (int i = 0; i < coupons.length; i++) {
            map.put(i, coupons[i]);
            newMap newMap = new newMap(i, coupons[i]);
            list.add(newMap);
        }
        int res = 0;
        while (map.get(m) > 0) {
            newMap my = list.get(0);
            int key = my.getKey();
            int value = my.getValue();
            my.setValue(value - 1);
            map.put(key, value - 1);
            list.remove(0);
            if (my.getValue() != 0) {
                list.add(my);
            }
            res += 10;
        }
        return res;
    }


}

class newMap {
    int key;
    int value;

    public newMap(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public newMap() {
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
