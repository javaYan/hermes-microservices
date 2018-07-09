package hermes.lottery.service.dao;

import hermes.lottery.api.entity.Lottery;
import hermes.lottery.api.constant.LotteryEnum;
import hermes.lottery.service.constant.LotteryConstants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanyuyu on 2017/1/16.
 */
@Repository
public class LotteryDao {

    private static final Logger log = LoggerFactory.getLogger(LotteryDao.class);

    /**
     * 在线爬取双色球信息
     * 期号：2位年份+3位数
     * @return
     */
    public List<Lottery> readDoubleBallOnLine() {
        List<Lottery> list = new ArrayList<Lottery>();
        try {
            for(int i = LotteryConstants.DOUBLEBALL_START_YEAR; i <= LotteryConstants.DOUBLEBALL_END_YEAR; i ++) { //每年请求一次
                String startPhase = i + LotteryConstants.MIN_SUFFIX_NUMBER; //开始期号
                String endPhase =  i + LotteryConstants.MAX_SUFFIX_NUMBER; //结束期号
                Document document = Jsoup.connect("http://trend.baidu.lecai.com/ssq/redBaseTrend.action?startPhase="+startPhase+"&endPhase="+endPhase+"&phaseOrder=up&coldHotOrder=number&onlyBody=false").timeout(5000).get();
                Element tableElement = document.getElementById("chartTable");
                if(tableElement != null) {
                    Element tbodyElement = tableElement.child(1);
                    Elements trElements = tbodyElement.children();
                    for(Element tr : trElements) {
                        Lottery lottery = new Lottery();
                        lottery.setType(LotteryEnum.DOUBLE_BALL.id);
                        lottery.setNumber(tr.child(0).text());
                        Elements redBallElements = tr.getElementsByClass("red_ball");
                        Elements blueBallElements = tr.getElementsByClass("blue_ball");
                        List<String> normalNumbers = new ArrayList<String>();
                        List<String> specialNumbers = new ArrayList<String>();
                        for(Element redBall : redBallElements) {
                            normalNumbers.add(redBall.text());
                        }
                        for(Element blueBall : blueBallElements) {
                            specialNumbers.add(blueBall.text());
                        }
                        lottery.setNormalNumbers(normalNumbers);
                        lottery.setSpecialNumbers(specialNumbers);
                        list.add(lottery);
                    }
                }
            }

        } catch(Exception e) {
            log.error("failed readDoubleBallOnLine !", e);
        }

        return list;
    }

    /**
     * 在线爬取大乐透信息
     * 期号：2位年份+3位数
     * @return
     */
    public List<Lottery> readSuperLottoOnLine() {
        List<Lottery> list = new ArrayList<Lottery>();
        try {
            for(int i = LotteryConstants.SUPERLOTTO_START_YEAR; i < LotteryConstants.SUPERLOTTO_END_YEAR; i ++) { //每年请求一次
                String startPhase = null; //开始期号
                String endPhase = null; //结束期号
                if(i < 10) {
                    startPhase = "0" + i + LotteryConstants.MIN_SUFFIX_NUMBER;
                    endPhase = "0" + i + LotteryConstants.MAX_SUFFIX_NUMBER;
                } else {
                    startPhase = i + LotteryConstants.MIN_SUFFIX_NUMBER;
                    endPhase = i + LotteryConstants.MAX_SUFFIX_NUMBER;
                }
                Document document = Jsoup.connect("http://trend.baidu.lecai.com/dlt/redBaseTrend.action?startPhase="+startPhase+"&endPhase="+endPhase+"&phaseOrder=up&coldHotOrder=number&onlyBody=false").timeout(5000).get();
                Element tableElement = document.getElementById("chartTable");
                if(tableElement != null) {
                    Element tbodyElement = tableElement.child(1);
                    Elements trElements = tbodyElement.children();
                    for(Element tr : trElements) {
                        String validateNumber = tr.child(0).text();
                        if(validateNumber.compareTo(LotteryConstants.SUPERLOTTO_END_YEAR + LotteryConstants.MAX_SUFFIX_NUMBER)<=0 && validateNumber.compareTo("0" + LotteryConstants.SUPERLOTTO_START_YEAR + LotteryConstants.MIN_SUFFIX_NUMBER)>=0) {
                            Lottery lottery = new Lottery();
                            lottery.setType(LotteryEnum.SUPER_LOTTO.id);
                            lottery.setNumber(validateNumber);
                            Elements redBallElements = tr.getElementsByClass("red_ball");
                            Elements blueBallElements = tr.getElementsByClass("blue_ball");
                            List<String> normalNumbers = new ArrayList<String>();
                            List<String> specialNumbers = new ArrayList<String>();
                            for(Element redBall : redBallElements) {
                                normalNumbers.add(redBall.text());
                            }
                            for(Element blueBall : blueBallElements) {
                                specialNumbers.add(blueBall.text());
                            }
                            lottery.setNormalNumbers(normalNumbers);
                            lottery.setSpecialNumbers(specialNumbers);
                            list.add(lottery);
                        }
                    }
                }
            }

        } catch(Exception e) {
            log.error("failed readDoubleBallOnLine !", e);
        }

        return list;
    }

    /**
     * 在线爬取七乐彩信息
     * 期号：4位年份+3位数
     * @return
     */
    public List<Lottery> readQiLeCaiOnLine() {
        List<Lottery> list = new ArrayList<Lottery>();
        try {
            for(int i = LotteryConstants.QILECAI_START_YEAR; i <= LotteryConstants.QILECAI_END_YEAR; i ++) { //每年请求一次
                String startPhase = i + LotteryConstants.MIN_SUFFIX_NUMBER; //开始期号
                String endPhase = i + LotteryConstants.MAX_SUFFIX_NUMBER; //结束期号
                Document document = Jsoup.connect("http://trend.baidu.lecai.com/qlc/baseTrend.action?startPhase="+startPhase+"&endPhase="+endPhase+"&phaseOrder=up&coldHotOrder=number&onlyBody=false").timeout(5000).get();
                Element tableElement = document.getElementById("chartTable");
                if(tableElement != null) {
                    Element tbodyElement = tableElement.child(1);
                    Elements trElements = tbodyElement.children();
                    for(Element tr : trElements) {
                        String validateNumber = tr.child(0).text();
                        if(validateNumber.compareTo(LotteryConstants.QILECAI_END_YEAR + LotteryConstants.MAX_SUFFIX_NUMBER)<=0 && validateNumber.compareTo(LotteryConstants.QILECAI_START_YEAR + LotteryConstants.MIN_SUFFIX_NUMBER)>=0) {
                            Lottery lottery = new Lottery();
                            lottery.setType(LotteryEnum.LECA_PARTICULARI.id);
                            lottery.setNumber(validateNumber);
                            Elements redBallElements = tr.getElementsByClass("red_ball");
                            Elements blueBallElements = tr.getElementsByClass("qlc_te");
                            List<String> normalNumbers = new ArrayList<String>();
                            List<String> specialNumbers = new ArrayList<String>();
                            for(Element redBall : redBallElements) {
                                normalNumbers.add(redBall.text());
                            }
                            for(Element blueBall : blueBallElements) {
                                specialNumbers.add(blueBall.text());
                            }
                            lottery.setNormalNumbers(normalNumbers);
                            lottery.setSpecialNumbers(specialNumbers);
                            list.add(lottery);
                        }
                    }
                }
            }

        } catch(Exception e) {
            log.error("failed readDoubleBallOnLine !", e);
        }

        return list;
    }
}
