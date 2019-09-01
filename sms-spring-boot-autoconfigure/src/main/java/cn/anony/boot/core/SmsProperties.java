package cn.anony.boot.core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Cheng Yufei
 * @create 2019-09-01 5:00 下午
 *
 * 功能：引用方在application.yml 中 配置参数
 **/
@Data
@ConfigurationProperties(prefix = SmsProperties.pre)
public class SmsProperties {

    public static final String pre = "sms";

    private boolean enable;

    private Ali ali;

    @Data
    public static class Ali {

        private String key;

        private String secret;
    }


}
