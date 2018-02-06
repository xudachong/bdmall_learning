package com.bigdragonmall.task;

import com.bigdragonmall.util.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: XuJuLong<5 7 4 4 0 8 5 7 8 @ qq.com>
 * @Description:
 * @Date: Created in 17:03 2018/2/6
 * @
 */
@Component
@Slf4j
public class CloseOrderTask {

	    @Scheduled(cron="0 */1 * * * ?")//每1分钟(每个1分钟的整数倍)
	public void closeOrderTaskV1(){
		log.info("关闭订单定时任务启动");
		int hour = Integer.parseInt(PropertiesUtil.getProperty("close.order.task.time.hour","2"));
//        iOrderService.closeOrder(hour);
		log.info("关闭订单定时任务结束");
	}

}
