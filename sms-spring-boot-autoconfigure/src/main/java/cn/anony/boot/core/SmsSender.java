package cn.anony.boot.core;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author Cheng Yufei
 * @create 2019-09-01 5:36 下午
 **/
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Slf4j
public class SmsSender {

    String key;

    String secret;

    public String send() {
        log.info(">>>>>>发送 开始:key - {},secret - {}", key, secret);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info(">>>>>>发送结束");
        return "success";
    }
}
