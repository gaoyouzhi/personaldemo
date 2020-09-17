package com.haochang.se;

import io.swagger.models.auth.In;
import org.junit.Test;

import java.util.*;

/**
 * @description: 描述：arraylist测试
 * @author: youzhi.gao
 * @date: 2020-09-04 09:17
 */
public class ArrayListTest {

    /**
     * 方法功能描述：基本类型不持支泛型化
     * @MethodName: testType
     * @param
     * @Return:
     * @Author: yz.gao
     * @Date: 2020-09-04 9:19
     */
    @Test
    public void testType() {

        List list = Arrays.asList(new int[]{1,2,3});
        List integers = Arrays.asList(new Integer[]{1,2,3});


        System.out.println(list.size());
        System.out.println(integers.size());
    }
    
    /**
     * 方法功能描述：测试不可变list
     * @MethodName: testModify
     * @param 
     * @Return: 
     * @Author: yz.gao
     * @Date: 2020-09-04 9:22
     */
    @Test
    public void testModify(){
        //错误初始化list
        int[] a = new int[]{1,2,3,4};
        List in = Arrays.asList(a);

        System.out.println(in.size());

        //正确初始化list
        List list = new ArrayList<Integer>(Arrays.asList(1,2,3,4));

        System.out.println(list.size());
        List mod = Collections.unmodifiableList(list);//只读

//        mod.set(0, 5);
//        mod.add(0, 5);
        System.out.println(mod.size());
        System.out.println(mod.get(0));

    }

    /**
     * 方法功能描述：测试字符串常量池
     * @MethodName: testString
     * @param
     * @Return:
     * @Author: yz.gao
     * @Date: 2020-09-04 9:27
     */
    @Test
    public void testString(){
        String a = new String("aaa");
        String b = a;
        System.out.println(b);
        b = "ccc";

        System.out.println(a);
        System.out.println(b);
    }


    /**
     * 方法功能描述：测试迭代器
     * @MethodName: testItr
     * @param
     * @Return:
     * @Author: yz.gao
     * @Date: 2020-09-04 9:42
     */
    @Test
    public void testItr(){
        List list = new ArrayList(Arrays.asList(12,13,14,15,13));

        Iterator iterator = list.iterator();
        //迭代器remove的时候  在next的时候会进行检查modCount是否有变化
        //如果数据存在修改则快速失败
        while (iterator.hasNext()){
            Object a = iterator.next();
            System.out.println(a);
            //错误的删除方式
            list.remove(2);
            //正确的删除方式
//            iterator.remove();
        }


    }

    /**
     * 方法功能描述：测试删除元素
     * @MethodName: test2
     * @param
     * @Return:
     * @Author: yz.gao
     * @Date: 2020-09-14 20:09
     */
    @Test
    public void test2(){
        List list = new ArrayList(Arrays.asList(12,13,14,15,13));

        Iterator iterator = list.iterator();
        //迭代器remove的时候  在next的时候会进行检查modCount是否有变化
        //如果数据存在修改则快速失败
        while (iterator.hasNext()){
            Object a = iterator.next();
            System.out.println(a);
            //正确的删除方式
            iterator.remove();
        }

    }


    /**
     * 方法功能描述：错误的新增
     * @MethodName: test1
     * @param
     * @Return:
     * @Author: yz.gao
     * @Date: 2020-09-14 20:06
     */
    @Test
    public void test1(){
        List list = new ArrayList(Arrays.asList(12,13,14,15,13));

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Object a = iterator.next();
            System.out.println(a);
            // 不断新增  会导致内存溢出
            list.add(200);
        }
        System.out.println(list.size());
    }



    /**
     * 方法功能描述：测试foreach
     * @MethodName: testForEach
     * @param
     * @Return:
     * @Author: yz.gao
     * @Date: 2020-09-04 9:49
     */
    @Test
    public void testForEach(){
        List<String> list = new ArrayList(Arrays.asList("abc","ade","ddd","sss","aba"));
        for (int i = 0; i < list.size(); i++){
            String s = list.get(i);
            if(s.contains("a")){
                list.remove(i);
                //移除元素后需要回退 否则会有遗漏
                //相当于需要重新遍历后面的元素
                i--;
            }
        }

        System.out.println(Arrays.toString(list.toArray()));
    }


    /**
     * 方法功能描述：测试foreach
     * @MethodName: testForEach2
     * @param
     * @Return:N
     * @Author: yz.gao
     * @Date: 2020-09-04 9:49
     */
    @Test
    public void testForEach2(){
        List<Integer> list = new ArrayList(Arrays.asList(12,13,13,14,15,16,13,13,19));
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).equals(13)){
                list.remove(i);
                //移除元素后需要回退 否则会有遗漏
                //相当于需要重新遍历后面的元素
//                i--;
            }
        }

        System.out.println(Arrays.toString(list.toArray()));
    }


}
