package hermes.lottery.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Mr_yyy on 2017/1/1.
 */
@Getter @Setter @ToString
public class LotteryVo implements Serializable{
    private Integer type;
    private String number;
    private List<Integer> normalNumbers;
    private List<Integer> specialNumbers;
    private Date effectDate;
    private String information;
}
