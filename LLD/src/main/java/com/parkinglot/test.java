package com.parkinglot;

import java.util.*;

public class test {
    public class Node implements Comparator<Node>{

        public int key ;
        public int val;

        public Node(int key , int val){
            this.key = key;
            this.val = val;
        }

        @Override
        public int compare(Node o1, Node o2) {
            return o1.val - o2.val;
        }
    }

    public void createNode(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        int size = arr.length;
        for (int i =0 ;i< size; i++){
            int finalI = i;
            map.computeIfPresent(arr[i], (k, v )-> v + arr[finalI]);
        }
//        System.out.println(map.entrySet().stream().forEach( enty););
    }
}
