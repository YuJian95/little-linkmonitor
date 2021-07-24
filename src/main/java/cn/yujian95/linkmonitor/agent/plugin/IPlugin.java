package cn.yujian95.linkmonitor.agent.plugin;

/**
 * 监控组件
 *
 * @author YuJian95  yujian95_cn@163.com
 * @date 2021/7/24
 */
public interface IPlugin {
    // 名称
    String name();

    // 监控点
    InterceptPoint[] buildInterceptPoint();

    // 拦截器类
    Class adviceClass();
}
