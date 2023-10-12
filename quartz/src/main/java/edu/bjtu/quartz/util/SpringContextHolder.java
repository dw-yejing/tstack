package edu.bjtu.quartz.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring上下文工具包  YJ_20200724
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {
    /**
     * 静态持有spring上下文对象（bean工厂对象）
     */
    private static ApplicationContext factory = null;

    /**
     * Spring初始化时，会通过该方法将ApplicationContext对象注入。
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.factory = applicationContext;
    }

    /**
     * 获取spring的bean对象，如果spring上下文加载失败则返回null
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName) {
        return (T) (null == factory ? null : factory.getBean(beanName));
    }

    /**
     * 获取spring的bean对象，如果spring上下文加载失败则返回null
     */
    public static <T> T getBean(Class<T> clazz) {
        return (null == factory ? null : factory.getBean(clazz));
    }

    /**
     * 获取spring的bean对象，如果spring上下文加载失败则返回null
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return (null == factory ? null : factory.getBean(name, clazz));
    }

    /**
     * 获取Spring环境属性值  YJ_20200724
     */
    public static String getValue(String key){
        return null == factory ? null : factory.getEnvironment().getProperty(key);
    }
}
