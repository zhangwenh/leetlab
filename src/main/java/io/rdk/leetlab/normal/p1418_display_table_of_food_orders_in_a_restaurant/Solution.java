package io.rdk.leetlab.normal.p1418_display_table_of_food_orders_in_a_restaurant;

import java.util.*;

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        // 要求：桌号要做排序，菜品要做排序
        // 遍历订单，使用Map存放数据并进行reduce
        // 遍历过程中，使用TreeSet放标题、菜品
        Map<Integer, Map<String, Integer>> orderMap = new HashMap<>();//<table,<food,count>>
        TreeSet<Integer> tableSet = new TreeSet<>();
        TreeSet<String> foodSet = new TreeSet<>();
        for(List<String> order : orders){
            Integer table = new Integer(order.get(1));
            String food = order.get(2);
            tableSet.add(table);
            foodSet.add(food);
            Map<String, Integer> tableMap = orderMap.getOrDefault(table, new HashMap<>());
            tableMap.put(food, tableMap.getOrDefault(food, 0) + 1);
            orderMap.put(table, tableMap);
        }
        List<List<String>> res = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        titleList.add("Table");
        titleList.addAll(foodSet);
        res.add(titleList);
        for(Integer table: tableSet){
            List<String> tmpList = new ArrayList<>();
            tmpList.add(String.valueOf(table));
            Map<String, Integer> tableMap = orderMap.get(table);
            for(String food: foodSet){
                tmpList.add(String.valueOf(tableMap.getOrDefault(food,0)));
            }
            res.add(tmpList);
        }
        return res;
    }

}
