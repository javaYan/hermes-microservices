package hermes.lottery.util;

import hermes.lottery.entity.Lottery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanyuyu on 2017/1/16.
 * 双色球彩票信息容器，模拟数据库存储
 */
public class DoubleBallContainer {
    private static final Map<String,Lottery> map;

    static {
        map = new HashMap<String,Lottery>();
    }

    public static Lottery get(String number) {
        return map.get(number);
    }

    public static void load(List<Lottery> list) {
        if(list != null && list.size() > 0) {
            for(Lottery lottery : list) {
                map.put(lottery.getNumber(), lottery);
            }
        }
    }
}
