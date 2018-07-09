package hermes.lottery.api.service;

import hermes.lottery.api.vo.LotteryVo;

import java.util.List;

/**
 * Created by Mr_yyy on 2017/1/1.
 */
public interface LotteriesService {

    /**
     * 分页查询彩票中间列表
     * @param type
     * @param number    查询起始期号（精确分页用）
     * @param pageNum   每页数据量
     * @return
     */
    List<LotteryVo> doGet(Integer type, String number, Integer pageNum);

}
