package io.rdk.leetlab.yuanquan.p4;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
/**
 * 输出的数据
 * java.util.Map<java.lang.String, Person>
 * class java.lang.String
 * class Person
 * java.util.List<Person>
 * class Person
 * class java.lang.Integer
 * class Person
 * */
public class ReflectionTest {
    public void methodTest01(Map<String, Person> map, List<Person> list) {
        System.out.println("ReflectionTest.methodTest01()");
    }
    public Map<Integer, Person> methodTest02() {
        System.out.println("ReflectionTest.methodTest02()");
        return null;
    }
    /**
     * 获得methodTest01方法参数泛型信息
     */
    public void getParameterInfo() {
        try {
            Method method = ReflectionTest.class.getMethod("methodTest01", Map.class, List.class);
            //No.1
            //开始写代码，请在这个方法中获得methodTest01方法参数泛型信息，并打印出来。
            Type[] t = method.getGenericParameterTypes();
            // java.util.Map<java.lang.String, Person>
            // class java.lang.String
            // class Person
            // java.util.List<Person>
            // class Person
            for(Type type : t){
                System.out.println(type); //java.util.Map<java.lang.String, Person>
                if(type instanceof ParameterizedType){
                    Type[] t1 = ((ParameterizedType)type).getActualTypeArguments();
                    for(Type t2:t1){
                        System.out.println(t2);//class java.lang.String
                    }
                }
            }
            //end_code
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获得methodTest02方法返回值泛型信息
     */
    public void getReturnValueInfo(){
        try {
            Method method = ReflectionTest.class.getMethod("methodTest02", null);
            //No.2
            Type returnType = method.getGenericReturnType();
            // class java.lang.Integer
            // class Person
            System.out.println(returnType);
            if(returnType instanceof ParameterizedType){
                Type[] t1 = ((ParameterizedType)returnType).getActualTypeArguments();
                for(Type t2: t1){
                    System.out.println(t2);//class java.lang.Integer
                }
            }
            //end_code
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ReflectionTest reflectionTest = new ReflectionTest();
        reflectionTest.getParameterInfo();
        reflectionTest.getReturnValueInfo();
    }
}
class Person {
}
