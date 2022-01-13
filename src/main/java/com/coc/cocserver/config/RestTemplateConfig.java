package com.coc.cocserver.config;

import com.coc.cocserver.service.CocApi;
import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class RestTemplateConfig {

    @Autowired
    CocAuthorizationInterceptor cocAuthorizationInterceptor;

    @Autowired
    CocRequestInterceptor cocRequestInterceptor;

    // 配置 RestTemplate
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(simpleClientHttpRequestFactory());
        restTemplate.setInterceptors(Collections.singletonList(cocAuthorizationInterceptor));
        return restTemplate;
    }

    @Bean
    public CocApi goldPassApi() {
        /**
         * // 使用spring4规范
         *                 .contract(new SpringContract())
         *                 // 使用jackson编解码
         *                 .encoder(new JacksonEncoder())
         *                 .decoder(new JacksonDecoder())
         *                 // okhttp客户端
         *                 .client(new OkHttpClient())
         *                 // 请求失败重试，默认最大5次
         *                 .retryer(new Retryer.Default())
         *                 // 请求超时配置
         *                 .options(new Request.Options(10, TimeUnit.SECONDS, 60, TimeUnit.SECONDS, true))
         *                 // 日志配置，将在请求前后打印日志
         *                 .logger(new Slf4jLogger())
         *                 // 日志等级配置，BASIC:只打印请求路径和响应状态码基本信息
         *                 .logLevel(Logger.Level.BASIC)
         */
        CocApi goldPassApi = Feign.builder()
                .requestInterceptor(cocRequestInterceptor)
                .target(CocApi.class, "https://api.clashofclans.com/v1");
        return goldPassApi;
    }

    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        // 创建一个 httpCilent 简单工厂
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        // 设置连接超时
        factory.setConnectTimeout(15000);
        // 设置读取超时
        factory.setReadTimeout(5000);
        return factory;
    }
}
