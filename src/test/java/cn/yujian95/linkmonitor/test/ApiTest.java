package cn.yujian95.linkmonitor.test;

/**
 * @author YuJian95  yujian95_cn@163.com
 * @date 2021/7/24
 */
public class ApiTest {

//    public static void main(String[] args) throws InterruptedException {
//        ApiTest apiTest = new ApiTest();
//        apiTest.echoHi();
//    }
//
//    private void echoHi() throws InterruptedException {
//        System.out.println("hi agent");
//        Thread.sleep((long) (Math.random() * 500));
//    }

//    public static void main(String[] args) {
//        while (true) {
//            List<Object> list = new LinkedList<>();
//            list.add("嗨！JavaAgent");
//            list.add("嗨！JavaAgent");
//            list.add("嗨！JavaAgent");
//        }
//    }

    public static void main(String[] args) {

        //线程一
        new Thread(() -> new ApiTest().http_lt1()).start();

        //线程二
        new Thread(() -> {
            new ApiTest().http_lt1();
        }).start();
    }


    public void http_lt1() {
        System.out.println("测试结果：hi1");
        http_lt2();
    }

    public void http_lt2() {
        System.out.println("测试结果：hi2");
        http_lt3();
    }

    public void http_lt3() {
        System.out.println("测试结果：hi3");
    }

}