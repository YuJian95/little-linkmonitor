package cn.yujian95.linkmonitor.test;

/**
 * @author YuJian95  yujian95_cn@163.com
 * @date 2021/7/24
 */
public class ApiTest {
    public static void main(String[] args) {

        //线程一
        new Thread(() -> new ApiTest().http_lt1("哪咤")).start();

        //线程二
        new Thread(() -> {
            new ApiTest().http_lt2("悟空");
        }).start();

    }

    public void http_lt1(String name) {
        try {
            Thread.sleep((long) (Math.random() * 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("测试结果：hi1 " + name);
        http_lt2(name);
    }

    public void http_lt2(String name) {
        try {
            Thread.sleep((long) (Math.random() * 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("测试结果：hi2 " + name);
        http_lt3(name);
    }

    public void http_lt3(String name) {
        try {
            Thread.sleep((long) (Math.random() * 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("测试结果：hi3 " + name);
    }

}
