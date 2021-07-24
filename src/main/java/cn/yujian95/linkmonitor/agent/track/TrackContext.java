package cn.yujian95.linkmonitor.agent.track;

/**
 * @author YuJian95  yujian95_cn@163.com
 * @date 2021/7/24
 */
public class TrackContext {
    private static final ThreadLocal<String> trackLocal = new ThreadLocal<String>();

    public static void clear() {
        trackLocal.remove();
    }

    public static String getLinkId() {
        return trackLocal.get();
    }

    public static void setLinkId(String linkId) {
        trackLocal.set(linkId);
    }
}
