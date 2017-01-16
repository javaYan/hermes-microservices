package hermes.lottery.service;

import hermes.lottery.vo.LotteryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mr_yyy on 2017/1/1.
 */
@RestController
public class LotteryServiceImpl implements  LotteryService{

    private static Logger log = LoggerFactory.getLogger(LotteryServiceImpl.class);

    @RequestMapping(value = "lottery",method = RequestMethod.GET)
    @Override
    public LotteryVo doGet(Integer type, String number) {
        log.info("LotteryServiceImpl doGet : type-[{}], number-[{}]", type, number);
        return null;
    }
}
