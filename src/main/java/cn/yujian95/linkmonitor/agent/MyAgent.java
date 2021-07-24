package cn.yujian95.linkmonitor.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author YuJian95  yujian95_cn@163.com
 * @date 2021/7/19
 */
public class MyAgent {
    //JVM 首先尝试在代理类上调用以下方法
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("this is my agent：" + agentArgs);
        MyMonitorTransformer monitor = new MyMonitorTransformer();
        inst.addTransformer(monitor);
    }

    //如果代理类没有实现上面的方法，那么 JVM 将尝试调用该方法
    public static void premain(String agentArgs) {
    }
}
