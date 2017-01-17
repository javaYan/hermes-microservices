package hermes.lottery.service;

import hermes.configuration.exception.BaseException;
import hermes.lottery.entity.Lottery;
import hermes.lottery.enums.LotteryEnum;
import hermes.lottery.util.DoubleBallContainer;
import hermes.lottery.util.QiLeCaiContainer;
import hermes.lottery.util.SuperLottoContainer;
import hermes.lottery.vo.LotteryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mr_yyy on 2017/1/1.
 */
@RestController
@RequestMapping("lottery")
public class LotteryServiceImpl implements  LotteryService{

    private static Logger log = LoggerFactory.getLogger(LotteryServiceImpl.class);

    @RequestMapping(method = RequestMethod.GET)
    @Override
    public LotteryVo doGet(@RequestParam(name="type") Integer type, @RequestParam(name="number") String number) {
        log.info("LotteryServiceImpl doGet : type-[{}], number-[{}]", type, number);

        LotteryVo vo = new LotteryVo();
        Lottery lottery = null;
        if(type == LotteryEnum.DOUBLE_BALL.type) {
            lottery = DoubleBallContainer.get(number);
        } else if(type == LotteryEnum.SUPER_LOTTO.type) {
            lottery = SuperLottoContainer.get(number);
        } else if(type == LotteryEnum.LECA_PARTICULARI.type) {
            lottery = QiLeCaiContainer.get(number);
        } else {
            Map<String,Object> errorMap = new HashMap<String,Object>();
            errorMap.put("code",1);
            throw new BaseException(422,"参数不正确！").debug("type值不正确").error(errorMap);
        }

        if(lottery != null) {
            BeanUtils.copyProperties(lottery, vo);
            vo.setTypeName(LotteryEnum.valueOf(type));
        } else {
            throw new BaseException(404,"彩票信息不存在！");
        }

        return vo;
    }
}
