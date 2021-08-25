package io.rdk.leetlab.yuanquan.p5;

//No.1
//开始写代码，请结合现有代码和题目要求，在此实现转换器的代码。
abstract class Converter {
    public void convert(){}
}
class ConverterPDF extends Converter {
    public ConverterPDF(DB db){
        System.out.println("ConverterPDF db");
    }
    public void convert(){
        System.out.println("ConverterPDF convert");
    }
}
class ConverterTXT extends Converter {
    public ConverterTXT(DB db){
        System.out.println("ConverterTXT db");
    }
    public void convert(){
        System.out.println("ConverterTXT convert");
    }
}
//end_code
interface DB {
    void fromDB();
}
//No.2
//开始写代码，请结合代码和题目要求，在这里实现数据库适配的代码

class DBSQL implements DB{
    public void fromDB(){
        System.out.println("DBSQL");
    }
}
class DBOracle implements DB{
    public void fromDB(){
        System.out.println("DBOracle");
    }
}

//end_code
/*
 * 测试类
 * 最终输出的结果格式：
 * 例如：SQL数据转PDF
 * */
public class TestBridge {
    public static void main(String[] args) {
        /*从MySql数据库转换pdf文件*/
        Converter converterPDF = new ConverterPDF(new DBSQL());
        converterPDF.convert();
        /*从Oracle数据库转换txt文件*/
        Converter converterTXT = new ConverterTXT(new DBOracle());
        converterTXT.convert();
    }
}
