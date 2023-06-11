//Not using it right now


package com.bfb.emprepository.customKey;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

@Component
public class CustomKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params){
        return target.getClass().getSimpleName() + "_" +method.getName() + "_" + StringUtils.arrayToDelimitedString(params, "_");
    }
}
