package cn.yujian95.linkmonitor.agent.plugin.impl.jvm;

import net.bytebuddy.asm.Advice;

/**
 * @author YuJian95  yujian95_cn@163.com
 * @date 2021/7/24
 */
public class JvmAdvice {
    @Advice.OnMethodExit()
    public static void exit() {
        JvmStack.printMemoryInfo();
        JvmStack.printGCInfo();
    }
}
