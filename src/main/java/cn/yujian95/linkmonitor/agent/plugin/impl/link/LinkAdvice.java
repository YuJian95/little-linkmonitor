package cn.yujian95.linkmonitor.agent.plugin.impl.link;

import cn.yujian95.linkmonitor.agent.track.Span;
import cn.yujian95.linkmonitor.agent.track.TrackContext;
import cn.yujian95.linkmonitor.agent.track.TrackManager;
import net.bytebuddy.asm.Advice;

import java.util.UUID;

/**
 * @author YuJian95  yujian95_cn@163.com
 * @date 2021/7/24
 */
public class LinkAdvice {
    @Advice.OnMethodEnter()
    public static void enter(@Advice.Origin("#t") String className, @Advice.Origin("#m") String methodName) {
        Span currentSpan = TrackManager.getCurrentSpan();
        if (null == currentSpan) {
            String linkId = UUID.randomUUID().toString();
            TrackContext.setLinkId(linkId);
        }
        TrackManager.createEntrySpan();
    }

    @Advice.OnMethodExit()
    public static void exit(@Advice.Origin("#t") String className, @Advice.Origin("#m") String methodName) {
        Span exitSpan = TrackManager.getExitSpan();
        if (null == exitSpan) return;
        System.out.println("链路追踪(MQ)：" + exitSpan.getLinkId() + " " + className + "." + methodName + " 耗时：" + (System.currentTimeMillis() - exitSpan.getEnterTime().getTime()) + "ms");
    }
}
