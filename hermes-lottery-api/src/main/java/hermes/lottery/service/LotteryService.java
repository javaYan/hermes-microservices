package hermes.lottery.service;

import hermes.lottery.vo.LotteryVo;

/**
 * Created by Mr_yyy on 2017/1/1.
 */
public interface LotteryService {

    /**
     * 查询彩票信息
     * @param type      彩票类型
     * @param number    期号
     */
    public LotteryVo doGet(Integer type, String number);

}
