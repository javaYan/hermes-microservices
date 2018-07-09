package hermes.lottery.api.vo;

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
    private String typeName;
    private String number;
    private List<String> normalNumbers;
    private List<String> specialNumbers;
    private Date effectDate;
    private String effectDateText;
    private String information;
}
