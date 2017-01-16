package hermes.lottery.service;

import hermes.lottery.vo.LotteryVo;

/**
 * Created by Mr_yyy on 2017/1/1.
 */
public interface LotterySpiderService {

    /**
     * 彩票爬虫
     * @param startNumber      限制期号
     * @param endNumber      限制期号
     */
    public Long doPut(String startNumber, String endNumber);

}
