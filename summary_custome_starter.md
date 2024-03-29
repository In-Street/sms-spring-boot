###自定义启动器

1. sms-spring-boot-autoconfigure 模块：

```
    1. 定义被使用时的属性配置及具体业务逻辑方法

    2. SmsProperties:
         a. @ConfigurationProperties(prefix = SmsProperties.pre)
         b. 定义被使用时在yml中的属性配置。
    
    3. SmsSender:
         a. 提供SmsProperties类中包含必要属性的构造方法。
         b. 提供具体业务逻辑实现。 

    4. SmsAutoConfigutation:
         a. @EnableConfigurationProperties(SmsProperties.class): 使SmsProperties 中的@ConfigurationProperties注解生效；
            @Configutation

         b. 依据SmsProperties中属性，创建业务类SmsSender，
             前提：
                @ConditionalOnProperty(prefix = "sms", name = "enable",havingValue = "true")
                @ConditionalOnMissingBean(SmsSender.class) 

    5. 注解EnableSms：
         a. 自定义starter被引用时的生效方式：
             * 主动生效： 用户通过添加 @Enablexxxx 
             * 被动生效： resource下建 META-INF/spring.factories 

                        org.springframework.boot.autoconfigure=\
                               cn.anony.boot.SmsAutoConfiguration,\
                               xxxxxx,\
                               xxxxxx

         b. @interface EnableSms 主要作用是引入创建业务类的配置类
                * @Import(SmsAutoConfiguration.class)
 ```

2. sms-spring-boot-starter 模块：

```
    1. 空jar，主要提供必要的依赖，需直接或间接的引用 spring-boot-starter
    
    2. 引入 sms-spring-boot-autoconfigure 模块；

    3. 若是被动生效方式，没有EnableSms注解类，则需要在resources/META-INF/spring.factories 添加

```

3. 本地仓库生成maven引用包：

```
    1. clean & compile & install
```

4. 自定义starter被使用时，使用方在配置yml/properties时属性提示，做以下配置

     ```
   
        1. 属性类： @ConfigutationProperties ,指定 prefix
   
        2. 配置类开启：@EnableConfigurationProperties ，指定属性类
   
        3. 若属性类中有引入其他类作为成员变量时，添加 @NestedConfigurationProperty 
   
        
        @Data
        public class School {
            private Integer no;
            private String name;
            private String address;
        }
        @Data
        @ConfigurationProperties(prefix = "jiuxian")
        public class JiuxianProperties {
            private String name;
            private String nameCn;
            private String nameEn;
            private String[] hobbies;
            private SexEnum sexEnum;
            private boolean single;

            @NestedConfigurationProperty
            private School school;
   
            private City city;
        
            enum SexEnum {
                MAN, WOMAN
            }
        
            @Data
            static class City {
                private String no;
                private String name;
            }
        }
   ```