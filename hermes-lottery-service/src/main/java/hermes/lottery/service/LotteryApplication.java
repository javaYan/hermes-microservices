package hermes.lottery.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Mr_yyy on 2016/12/31.
 */
@SpringBootApplication
@ComponentScan(basePackages={"hermes.lottery.service"}) /*扫描全包*/
public class LotteryApplication {
    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();
        SpringApplication.run(LotteryApplication.class, args);
        long endTime = System.currentTimeMillis();
        long Time = endTime - starTime;
        System.out.println("\n启动时间:" + Time / 1000 + "秒");
        System.out.println("...............................................................");
        System.out.println("..................Service starts successfully..................");
        System.out.println("...............................................................");
    }
}
