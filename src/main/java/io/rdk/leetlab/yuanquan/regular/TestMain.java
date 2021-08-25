package io.rdk.leetlab.yuanquan.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain {
    public static void main(String[] args) {
        String line = "xfooxxxxxxfoo";
//        String pattern = ".*foo"; // 贪婪 xfooxxxxxxfoo
        String pattern = ".*?foo"; // 勉强 xfoo
//        String pattern = ".*+foo"; // 侵占 无结果，整个字符串被.*+消耗了
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println(m.group());
        }
    }
}
