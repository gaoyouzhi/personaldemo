package com.haochang.demo;

import com.haochang.util.DateUtil;
import org.thymeleaf.util.DateUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by gaoyouzhi on 2020/2/9.
 */
public class Prepare {
    private int stackNum = 1;
    public static void main(String[] args) {
//        test();

//        String a = new String("111");
        Prepare prepare = new Prepare();
        prepare.testStackOverFlow();
//        prepare.testOutOfMemory();
//        prepare.outOfMemory();
//        Double a = 3.22;
//        Double b = 5.22;
//        Double c = new BigDecimal(a.toString()).
//                divide(new BigDecimal(b.toString())).
//                setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
//        System.out.println(new BigDecimal(a / b).setScale(2, BigDecimal.ROUND_DOWN).doubleValue());
    }

    /**
     * 方法功能描述：测试堆溢出
     * 设置jvm参数-xms20m -xmx20m -XX:HeapDumpOnOutOfMemoryError
     * @MethodName: testOutOfMemory
     * @param
     * @Return:
     * @Author: yz.gao
     * @Date: 2020-08-11 14:03
     */
    private void testOutOfMemory() {

        List<Prepare> list = new ArrayList<>();
        while (true){
            Prepare prepare = new Prepare();
            list.add(prepare);
        }

    }

    /**
     * 方法功能描述：测试栈溢出
     *
     * @MethodName: testStackOverFlow
     * @param
     * @Return:
     * @Author: yz.gao
     * @Date: 2020-08-11 14:29
     */
    private void testStackOverFlow() {
        stackNum++;
        System.out.println(stackNum);
        testStackOverFlow();
    }

    private static void test() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(DateUtil.toStringNew(calendar.getTime()));
        calendar.add(Calendar.DAY_OF_MONTH, -30);
        System.out.println(DateUtil.toStringNew(calendar.getTime()));
    }

    private static void outOfMemory() {
        List<String> list = new ArrayList<String>();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("totalMemory(-Xms) = "+ (totalMemory/(double)1024/1024) +"MB");
        System.out.println("maxMemory(-Xmx) = "+ (maxMemory/(double)1024/1024) +"MB");
        while(true){
            list.add("test");
        }
    }

}
