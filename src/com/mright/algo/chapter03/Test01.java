package com.mright.algo.chapter03;

import com.mright.algo.chapter01.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/6/10 10:10
 */
public class Test01 {

    public static void main(String[] args) {
        LinkedHashMap<String,Integer> accessMap = new LinkedHashMap<>(16, 0.75f, true);

        accessMap.put("c", 100);
        accessMap.put("d", 200);
        accessMap.put("a", 500);
        accessMap.get("c");
        accessMap.put("d", 300);

        for(Map.Entry<String,Integer> entry : accessMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}
