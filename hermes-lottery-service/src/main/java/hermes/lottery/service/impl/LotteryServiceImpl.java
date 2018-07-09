package hermes.lottery.service.impl;

import hermes.configuration.constant.RestCodeMessage;
import hermes.configuration.exception.BaseException;
import hermes.lottery.api.constant.LotteryEnum;
import hermes.lottery.api.entity.Lottery;
import hermes.lottery.api.service.LotteryService;
import hermes.lottery.api.vo.LotteryVo;
import hermes.lottery.service.manager.DoubleBallManager;
import hermes.lottery.service.manager.QiLeCaiManager;
import hermes.lottery.service.manager.SuperLottoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mr_yyy on 2017/1/1.
 */
@RestController
@RequestMapping("lottery")
public class LotteryServiceImpl implements LotteryService {

    private static Logger log = LoggerFactory.getLogger(LotteryServiceImpl.class);

    @RequestMapping(method = RequestMethod.GET)
    @Override
    public LotteryVo doGet(@RequestParam(name="type") Integer type, @RequestParam(name="number") String number) {
        log.info("LotteryServiceImpl doGet : type-[{}], number-[{}]", type, number);

        LotteryVo vo = new LotteryVo();
        Lottery lottery = null;
        if(type == LotteryEnum.DOUBLE_BALL.id) {
            lottery = DoubleBallManager.get(number);
        } else if(type == LotteryEnum.SUPER_LOTTO.id) {
            lottery = SuperLottoManager.get(number);
        } else if(type == LotteryEnum.LECA_PARTICULARI.id) {
            lottery = QiLeCaiManager.get(number);
        } else {
            Map<String,Object> errorMap = new HashMap<String,Object>();
            errorMap.put("code",1);
            throw new BaseException(RestCodeMessage.Code.BAD_REQUEST, RestCodeMessage.Message.BAD_REQUEST).debug("type值不正确").error(errorMap);
        }

        if(lottery != null) {
            BeanUtils.copyProperties(lottery, vo);
            vo.setTypeName(LotteryEnum.valueOf(type));
        } else {
            throw new BaseException(RestCodeMessage.Code.RESOURCE_NOT_FOUND, RestCodeMessage.Message.RESOURCE_NOT_FOUND).debug("彩票信息不存在！");
        }

        return vo;
    }
}
