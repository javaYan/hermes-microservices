package hermes.lottery.dao;

import hermes.lottery.entity.Lottery;
import hermes.lottery.enums.LotteryEnum;
import hermes.lottery.util.Constants;
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
     * 期号：4位年份+3位数
     * @return
     */
    public List<Lottery> readDoubleBallOnLine() {
        List<Lottery> list = new ArrayList<Lottery>();
        try {
            for(int i = Constants.DOUBLEBALL_START_YEAR; i <= Constants.DOUBLEBALL_END_YEAR; i ++) { //每年请求一次
                String startPhase = i + Constants.MIN_SUFFIX_NUMBER; //开始期号
                String endPhase =  i + Constants.MAX_SUFFIX_NUMBER; //结束期号
                Document document = Jsoup.connect("http://trend.baidu.lecai.com/ssq/redBaseTrend.action?startPhase="+startPhase+"&endPhase="+endPhase+"&phaseOrder=up&coldHotOrder=number&onlyBody=false").timeout(5000).get();
                Element tableElement = document.getElementById("chartTable");
                if(tableElement != null) {
                    Element tbodyElement = tableElement.child(1);
                    Elements trElements = tbodyElement.children();
                    for(Element tr : trElements) {
                        Lottery lottery = new Lottery();
                        lottery.setType(LotteryEnum.DOUBLE_BALL.type);
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
            for(int i = Constants.SUPERLOTTO_START_YEAR; i < Constants.SUPERLOTTO_END_YEAR; i ++) { //每年请求一次
                String startPhase = null; //开始期号
                String endPhase = null; //结束期号
                if(i < 10) {
                    startPhase = "0" + i + Constants.MIN_SUFFIX_NUMBER;
                    endPhase = "0" + i + Constants.MAX_SUFFIX_NUMBER;
                } else {
                    startPhase = i + Constants.MIN_SUFFIX_NUMBER;
                    endPhase = i + Constants.MAX_SUFFIX_NUMBER;
                }
                Document document = Jsoup.connect("http://trend.baidu.lecai.com/dlt/redBaseTrend.action?startPhase="+startPhase+"&endPhase="+endPhase+"&phaseOrder=up&coldHotOrder=number&onlyBody=false").timeout(5000).get();
                Element tableElement = document.getElementById("chartTable");
                if(tableElement != null) {
                    Element tbodyElement = tableElement.child(1);
                    Elements trElements = tbodyElement.children();
                    for(Element tr : trElements) {
                        String validateNumber = tr.child(0).text();
                        if(validateNumber.compareTo(Constants.SUPERLOTTO_END_YEAR + Constants.MAX_SUFFIX_NUMBER)<=0 && validateNumber.compareTo("0" + Constants.SUPERLOTTO_START_YEAR + Constants.MIN_SUFFIX_NUMBER)>=0) {
                            Lottery lottery = new Lottery();
                            lottery.setType(LotteryEnum.SUPER_LOTTO.type);
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
            for(int i = Constants.QILECAI_START_YEAR; i <= Constants.QILECAI_END_YEAR; i ++) { //每年请求一次
                String startPhase = i + Constants.MIN_SUFFIX_NUMBER; //开始期号
                String endPhase = i + Constants.MAX_SUFFIX_NUMBER; //结束期号
                Document document = Jsoup.connect("http://trend.baidu.lecai.com/qlc/baseTrend.action?startPhase="+startPhase+"&endPhase="+endPhase+"&phaseOrder=up&coldHotOrder=number&onlyBody=false").timeout(5000).get();
                Element tableElement = document.getElementById("chartTable");
                if(tableElement != null) {
                    Element tbodyElement = tableElement.child(1);
                    Elements trElements = tbodyElement.children();
                    for(Element tr : trElements) {
                        String validateNumber = tr.child(0).text();
                        if(validateNumber.compareTo(Constants.QILECAI_END_YEAR + Constants.MAX_SUFFIX_NUMBER)<=0 && validateNumber.compareTo(Constants.QILECAI_START_YEAR + Constants.MIN_SUFFIX_NUMBER)>=0) {
                            Lottery lottery = new Lottery();
                            lottery.setType(LotteryEnum.LECA_PARTICULARI.type);
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
