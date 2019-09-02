package cn.anony.boot;

import cn.anony.boot.core.SmsProperties;
import cn.anony.boot.core.SmsSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Cheng Yufei
 * @create 2019-09-01 5:29 下午
 * <p>
 * 根据配置初始化功能类【发送类】
 **/
@Configuration
/**
 * 使SmsProperties 中@ConfigurationProperties 注解生效
 */
@EnableConfigurationProperties(SmsProperties.class)
@Slf4j
public class SmsAutoConfiguration {

    @Bean
    /**
     * https://blog.csdn.net/u010002184/article/details/79353696
     *
     * prefix: property 名称前缀
     * name: property 完整名称或部分名称（可与prefix结合使用，组成完整property名称 如下eg:[sms.enable]）,与value不同时使用
     * havingValue: 可与name结合使用，获取到属性值与havingValue 值相等时才加载配置
     * matchIfMissing：缺少该property 时是否可以加载，true: 没有该property时也会正常加载
     *
     */
    @ConditionalOnProperty(prefix = "sms", name = "enable",havingValue = "true")
    @ConditionalOnMissingBean(SmsSender.class)
    public SmsSender getSmsSender(SmsProperties smsProperties) {
        log.info(">>>>>初始化 SmsSender {}", smsProperties);
        SmsProperties.Ali ali = smsProperties.getAli();
        return new SmsSender(ali.getKeyString(), ali.getSecret());
    }
}
