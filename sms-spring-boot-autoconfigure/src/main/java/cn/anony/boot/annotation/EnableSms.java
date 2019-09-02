package cn.anony.boot.annotation;

import cn.anony.boot.SmsAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chengyufei
 *
 * starter 启动器集成方式：
 *  1. 主动集成：应用方主动声明使用starter，通常通过@Enablexxxx 来启动，Configuration类有@Import
 *
 *  2.被动集成：starter 集成到springboot工程时已经生效。 需在 AutoConfiguration所在module 的 resource 下建 META-INF/spring.factories , 写入：
 *    【多个配置类逗号隔开，换行使用反斜杠】
 *      org.springframework.boot.autoconfigure=\
 *      cn.anony.boot.SmsAutoConfiguration,\
 *      xxxxxx,\
 *      xxxxxx
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(SmsAutoConfiguration.class)
public @interface EnableSms {
}
