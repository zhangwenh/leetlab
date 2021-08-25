package io.rdk.leetlab.yuanquan.p1;

import java.util.*;

/**
 *
 * 合并账号20 分
 * 题目方向：Java
 * 题目名称：合并账号
 * 建议时长：30分钟
 * 题目描述
 * 某学习系统一个人可以拥有多个帐户，想要根据用户信息中的所有邮箱信息，
 * 把同一个人的不同账号进行合并，查询有多少独立用户，也就是说，两个账号即使姓名相同，它们也可能属于不同的人；
 * 只有账户信息中的相同邮箱，才能判定两个账号属于同一个人。阅读代码框内已给出的代码并完成需求。
 *
 */
public class AccountTest {
    public static List<List<String>> mergeUser(List<List<String>> users) {
        List<List<String>> resultList = new ArrayList<>();
        int[] userArray = new int[users.size()];
        for (int n = 0; n < userArray.length; n++) {
            userArray[n] = n;
        }
        Map<String, Integer> emailHashMap = new HashMap<>();
        Map<Integer, List<String>> positionHashMap = new HashMap<>();
        for (int i = 0; i < users.size(); i++) {
            for (int j = 1; j < users.get(i).size(); j++) {
                if (emailHashMap.containsKey(users.get(i).get(j))) {
                    union(userArray, i, emailHashMap.get(users.get(i).get(j)));
                } else {
                    emailHashMap.put(users.get(i).get(j), i);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : emailHashMap.entrySet()) {
            int position = find(userArray, entry.getValue());
            if (positionHashMap.get(position) != null) {
                List<String> emailList = positionHashMap.get(position);
                emailList.add(entry.getKey());
                positionHashMap.put(position, emailList);
            } else {
                List<String> emailList = new ArrayList<>();
                emailList.add(entry.getKey());
                positionHashMap.put(position, emailList);
            }
        }
        for (int position : positionHashMap.keySet()) {
            List<String> userList = new ArrayList<>();
            userList.addAll(positionHashMap.get(position));
            userList.add(0, users.get(position).get(0));
            Collections.sort(userList);
            resultList.add(userList);
        }
        return resultList;
    }
    //No.1
    //开始写代码，请结合需求和代码，完善下面两个方法从而实现需求。
    private static int find(int[] array, int x) {
        if(x == array[x]){
            return x;
        }
        return array[x] = find(array, array[x]);
    }
    private static void union(int[] array, int from, int to) {
        int realFrom = find(array, from);
        int realTo = find(array, to);
        if(realFrom != realTo){
            array[array[from]] = array[to];
        }
    }
    //end_code
    public static void main(String[] args) {
        String users[][] = {{"Ray", "rayShell@softchina.com", "ray001@163.com"},
                {"Ray", "xiang@sina.com"},
                {"Ray", "rayShell@softchina.com", "rui_xiang@qq.com"},
                {"Linda", "lindazheng@softchina.com"},
                {"Linda", "lindazheng@softchina.com", "linda777@sina.com"}};
        List<List<String>> list = new ArrayList<List<String>>();
        for (int i = 0; i < users.length; i++) {
            List<String> userList = new ArrayList<String>();
            for (int j = 0; j < users[i].length; j++) {
                userList.add(users[i][j]);
            }
            list.add(userList);
        }
        /*按数据给出格式输出：[姓名, 邮箱1, ..., 邮箱n]（邮箱不考虑顺序，姓名不同但邮箱有重合的，返回其中一个姓名即可*/
        List<List<String>> res = mergeUser(list);
        Iterator it = res.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
