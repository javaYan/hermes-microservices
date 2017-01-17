package hermes.lottery.service;

import hermes.lottery.vo.LotteryVo;

import java.util.Map;

/**
 * Created by Mr_yyy on 2017/1/1.
 */
public interface LotterySpiderService {

    /**
     * 彩票爬虫
     */
    public Map<String,Object> doPut();

}
