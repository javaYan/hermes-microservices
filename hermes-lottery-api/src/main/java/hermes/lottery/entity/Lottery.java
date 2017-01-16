package hermes.lottery.entity;

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
public class Lottery implements Serializable{
    private Integer type;
    private String number;
    private List<String> normalNumbers;
    private List<String> specialNumbers;
    private Date effectDate;
    private String information;
}
