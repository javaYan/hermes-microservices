package hermes.lottery.service.impl;

import hermes.lottery.api.service.LotteriesService;
import hermes.lottery.api.vo.LotteryVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mr_yyy on 2017/1/1.
 */
@RestController
@RequestMapping("lotteries")
public class LotteriesServiceImpl implements LotteriesService {

    @Override
    public List<LotteryVo> doGet(@RequestParam(name="type") Integer type,@RequestParam(name="number",required=false) String number,@RequestParam(name="pageNum",required=false,defaultValue="10") Integer pageNum) {
        return null;
    }
}
