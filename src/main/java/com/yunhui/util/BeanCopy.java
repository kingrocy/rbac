package com.yunhui.util;

import org.springframework.cglib.beans.BeanCopier;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
public class BeanCopy {

    public static <T,S> List<T> copyTo(List<S> sourceList, Class<T> targetClazz){
        List<T> result = new ArrayList<>();
        for(S s : sourceList){
            result.add(copyTo(s, targetClazz));
        }
        return result;
    }

    public static <T,S> T copyTo(S source, Class<T> targetClazz){
        BeanCopier beanCopier = BeanCopier.create(source.getClass(), targetClazz, false);
        T target = newObject(targetClazz);
        beanCopier.copy(source, target, null);
        return target;
    }

    private static <T> T newObject(Class<T> targetClazz){
        try {
            Constructor<T> constructor = targetClazz.getConstructor(new Class[0]);
            return (T)constructor.newInstance(new Object[0]);
        }catch (Exception e){
            throw new RuntimeException("no constructor without any parameter" + targetClazz);
        }
    }
}
