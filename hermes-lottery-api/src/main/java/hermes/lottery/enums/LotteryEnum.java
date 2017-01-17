package hermes.lottery.enums;

/**
 * Created by yanyuyu on 2017/1/16.
 */
public enum LotteryEnum {

    DOUBLE_BALL(1, "双色球"),
    SUPER_LOTTO(2, "大乐透"),
    LECA_PARTICULARI(3, "七乐彩");

    LotteryEnum(Integer type,String name) {
        this.type = type;
        this.name = name;
    }

    public Integer type;
    public String name;

    public static String valueOf(int type) {
        for (LotteryEnum lottery : values()) {
            if (lottery.type == type) {
                return lottery.name;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + type + "]");
    }
}
