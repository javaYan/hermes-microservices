package hermes.lottery.util;

import com.sun.javafx.binding.StringFormatter;
import hermes.lottery.entity.Lottery;

import java.util.*;

/**
 * Created by yanyuyu on 2017/1/16.
 * 七乐彩彩票信息容器，模拟数据库存储
 */
public class QiLeCaiContainer {
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
