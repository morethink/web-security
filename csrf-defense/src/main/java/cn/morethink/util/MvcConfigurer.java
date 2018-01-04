package cn.morethink.util;

import cn.morethink.interceptor.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 李文浩
 * @date 2018/1/3
 */
@Configuration
public class MvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/error").setViewName("error.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
        configurer.setUseSuffixPatternMatch(false);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/post/**");
        super.addInterceptors(registry);
    }

    @Bean
    public HiddenHttpMethodFilter getHiddenHttpMethodFilter() {
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        return hiddenHttpMethodFilter;
    }

    @Bean
    public CharacterEncodingFilter getCharacterEncodingFilter() {
        return new CharacterEncodingFilter("UTF-8", true);
    }
}
