package cn.yujian95.linkmonitor.agent.track;

import java.util.Date;

/**
 * @author YuJian95  yujian95_cn@163.com
 * @date 2021/7/24
 */
public class Span {
    private String linkId;  //链路ID
    private Date enterTime; //方法进入时间

    public Span() {
    }

    public Span(String linkId) {
        this.linkId = linkId;
        this.enterTime = new Date();
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }
}
