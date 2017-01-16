package hermes.lottery.util;

import com.sun.javafx.binding.StringFormatter;
import hermes.lottery.entity.Lottery;

import java.util.*;

/**
 * Created by yanyuyu on 2017/1/16.
 */
public class QiLeCaiContainer {
    private static final Map<String,Lottery> map;

    static {
        map = new HashMap<String,Lottery>();
    }

    public Lottery get(String number) {
        return map.get(number);
    }

    public List<Lottery> get(Integer year) {
        List<Lottery> list = new ArrayList<Lottery>();
        for(int i = 1; i <= Constants.MAX_SUFFIX_NUMBER_INTEGER; i ++) {
            Lottery lottery = map.get(year + String.format("%03d",i));
            if(lottery != null) {
                list.add(lottery);
            }
        }
        return list;
    }


}
