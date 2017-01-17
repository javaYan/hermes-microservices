package hermes.lottery.service;

import hermes.lottery.dao.LotteryDao;
import hermes.lottery.entity.Lottery;
import hermes.lottery.util.DoubleBallContainer;
import hermes.lottery.util.QiLeCaiContainer;
import hermes.lottery.util.SuperLottoContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanyuyu on 2017/1/12.
 */
@RestController
@RequestMapping(value="lotterySpider",method= RequestMethod.PUT)
public class LotterySpiderServiceImpl implements LotterySpiderService {

    private static final Logger log = LoggerFactory.getLogger(LotterySpiderServiceImpl.class);

    @Autowired
    private LotteryDao lotteryDao;


    /**
     * 网络爬取全量彩票信息
     * @return
     */
    @Override
    @RequestMapping(method= RequestMethod.PUT)
    public Map<String,Object> doPut() {
        long startTime = System.currentTimeMillis();
        List<Lottery> doubleBallList = lotteryDao.readDoubleBallOnLine();
        log.info("[双色球]:{}", doubleBallList);
        DoubleBallContainer.load(doubleBallList);
        for(Lottery lottery : doubleBallList) {
            System.out.println("["+lottery.getNumber()+"] : " + lottery.getNormalNumbers() + "," + lottery.getSpecialNumbers());
        }

        List<Lottery> superLottoList = lotteryDao.readSuperLottoOnLine();
        log.info("[大乐透]:{}", superLottoList);
        SuperLottoContainer.load(superLottoList);
        for(Lottery lottery : superLottoList) {
            System.out.println("["+lottery.getNumber()+"] : " + lottery.getNormalNumbers() + "," + lottery.getSpecialNumbers());
        }

        List<Lottery> qiLeCaiList = lotteryDao.readQiLeCaiOnLine();
        log.info("[七乐彩]:{}", qiLeCaiList);
        QiLeCaiContainer.load(qiLeCaiList);
        for(Lottery lottery : qiLeCaiList) {
            System.out.println("["+lottery.getNumber()+"] : " + lottery.getNormalNumbers() + "," + lottery.getSpecialNumbers());
        }

        long endTime = System.currentTimeMillis();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("双色球：", doubleBallList.size() + "期");
        map.put("大乐透：", superLottoList.size() + "期");
        map.put("七乐彩：", qiLeCaiList.size()    + "期");
        map.put("耗时:", (endTime-startTime)/1000 + "秒");
        return map;
    }


}
