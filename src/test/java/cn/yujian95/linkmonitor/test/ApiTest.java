package cn.yujian95.linkmonitor.test;

/**
 * @author YuJian95  yujian95_cn@163.com
 * @date 2021/7/24
 */
public class ApiTest {

    public static void main(String[] args) throws InterruptedException {
        ApiTest apiTest = new ApiTest();
        apiTest.echoHi();
    }

    private void echoHi() throws InterruptedException {
        System.out.println("hi agent");
        Thread.sleep((long) (Math.random() * 500));
    }
}