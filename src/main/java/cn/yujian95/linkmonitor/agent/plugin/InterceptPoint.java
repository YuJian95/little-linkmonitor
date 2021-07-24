package cn.yujian95.linkmonitor.agent.plugin;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;

/**
 * 拦截点
 *
 * @author YuJian95  yujian95_cn@163.com
 * @date 2021/7/24
 */
public interface InterceptPoint {
    //类匹配规则
    ElementMatcher<TypeDescription> buildTypesMatcher();

    //方法匹配规则
    ElementMatcher<MethodDescription> buildMethodsMatcher();
}
