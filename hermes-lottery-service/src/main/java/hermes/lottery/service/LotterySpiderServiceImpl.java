package hermes.lottery.service;

import hermes.lottery.dao.LotteryDao;
import hermes.lottery.entity.Lottery;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yanyuyu on 2017/1/12.
 */
@RestController
public class LotterySpiderServiceImpl implements LotterySpiderService {

    private static final Logger log = LoggerFactory.getLogger(LotterySpiderServiceImpl.class);

    @Autowired
    private LotteryDao lotteryDao;

    @Override
    @RequestMapping(value="lotterySpider",method= RequestMethod.PUT)
    public Long doPut(String startNumber, String endNumber) {
        List<Lottery> doubleBallList = lotteryDao.readDoubleBallOnLine();
        log.info("[双色球]:{}", doubleBallList);
        for(Lottery lottery : doubleBallList) {
            System.out.println("["+lottery.getNumber()+"] : " + lottery.getNormalNumbers() + "," + lottery.getSpecialNumbers());
        }

        List<Lottery> superLottoList = lotteryDao.readSuperLottoOnLine();
        log.info("[大乐透]:{}", superLottoList);
        for(Lottery lottery : superLottoList) {
            System.out.println("["+lottery.getNumber()+"] : " + lottery.getNormalNumbers() + "," + lottery.getSpecialNumbers());
        }

        List<Lottery> qiLeCaiList = lotteryDao.readQiLeCaiOnLine();
        log.info("[七乐彩]:{}", qiLeCaiList);
        for(Lottery lottery : qiLeCaiList) {
            System.out.println("["+lottery.getNumber()+"] : " + lottery.getNormalNumbers() + "," + lottery.getSpecialNumbers());
        }

        return null;
    }


}
