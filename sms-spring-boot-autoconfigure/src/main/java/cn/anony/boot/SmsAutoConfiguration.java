package cn.anony.boot;

import cn.anony.boot.core.SmsProperties;
import cn.anony.boot.core.SmsSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Cheng Yufei
 * @create 2019-09-01 5:29 下午
 *
 * 根据配置初始化功能类【发送类】
 **/
@Configuration
/**
 * 使SmsProperties 中@ConfigurationProperties 注解生效
 */
@EnableConfigurationProperties(SmsProperties.class)
public class SmsAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "sms.ali")
    public SmsSender getSmsSender(SmsProperties smsProperties) {

        SmsProperties.Ali ali = smsProperties.getAli();
        return new SmsSender(ali.getKey(), ali.getSecret());
    }
}
