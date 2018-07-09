package hermes.lottery.api.constant;

import hermes.configuration.common.CommonEnum;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by yanyuyu on 2017/1/16.
 */
@Getter
public enum LotteryEnum implements CommonEnum {

    DOUBLE_BALL(1, "双色球"),
    SUPER_LOTTO(2, "大乐透"),
    LECA_PARTICULARI(3, "七乐彩"),

    ;

    LotteryEnum(int id,String desc) {
        this.id = id;
        this.desc = desc;
    }

    public int id;
    public String desc;

    public static String valueOf(int id) {
        for (LotteryEnum lottery : values()) {
            if (lottery.id == id) {
                return lottery.desc;
            }
        }
        return StringUtils.EMPTY;
    }
}
