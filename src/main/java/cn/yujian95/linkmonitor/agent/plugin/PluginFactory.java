package cn.yujian95.linkmonitor.agent.plugin;

import cn.yujian95.linkmonitor.agent.plugin.impl.jvm.JvmPlugin;
import cn.yujian95.linkmonitor.agent.plugin.impl.link.LinkPlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YuJian95  yujian95_cn@163.com
 * @date 2021/7/24
 */
public class PluginFactory {
    public static List<IPlugin> pluginGroup = new ArrayList<>();

    static {
        // 链路监控
        pluginGroup.add(new LinkPlugin());
        // Jvm监控
        pluginGroup.add(new JvmPlugin());
    }
}
