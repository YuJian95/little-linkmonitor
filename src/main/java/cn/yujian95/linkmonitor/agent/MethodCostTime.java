package cn.yujian95.linkmonitor.agent;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @author YuJian95  yujian95_cn@163.com
 * @date 2021/7/24
 */
public class MethodCostTime {

    @RuntimeType
    public static Object intercept(@Origin Method method, @SuperCall Callable<?> callable) throws Exception {
        long start = System.currentTimeMillis();
        try {
            // 原函数执行
            return callable.call();
        } finally {
            System.out.println(method + " 方法耗时： " + (System.currentTimeMillis() - start) + "ms");
        }
    }
}
