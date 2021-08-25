package io.rdk.leetlab.yuanquan.p3;

/**
 * 输入打印格式，每行字幕前后顺序不考虑，A打印10次，B打印20次，C打印30次
 * ABCBCABACABCCABACBBCACBABCACBA
 * BCBCCBBCBCBCBCBCBCCB
 * CCCCCCCCCC
 *
 * 我们可以在Helper类的 handle的方法中实现按照指定的次数显示字符，
 * 另外你也可以增加一定的休眠(比如100毫秒)来延缓显示速度，这是模拟在数据比较多的情况下
 * handle处理的费时操作
 * */
public class ThreadMsgTest {
    public static void main(String[] args){
        Host host = new Host();
        /*启动线程，打印10次A*/
        host.request(10,'A');
        /*启动线程，打印20次B*/
        host.request(20,'B');
        /*启动线程，打印30次C*/
        host.request(30,'C');
    }
}
//No.1
//开始写代码，请在下面写出实现需求的代码
class Host{
    public void request(int count,char c){
        Runnable helper = new Helper(count, c);
        Thread t = new Thread(helper);
        t.start();
    }
}
class Helper implements Runnable{
    final int count;
    final char c;

    public Helper(int count, char c){
        this.count = count;
        this.c = c;
    }

    public void handle(int count,char c){
        while(count > 0){
            System.out.print(c);
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            count --;
        }
    }
    public void run(){
        handle(this.count, this.c);
    }

}
//end_code