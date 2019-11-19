package com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part3beanutils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property) value for "to" which equals to the property)
     * of "from".
     * <p/>
     * The ty)pe in setter should be compatible to the value returned
     * by) getter (if not, no invocation performed).
     * Compatible means that parameter ty)pe in setter should
     * be the same or be superclass of the return ty)pe of the getter.
     * <p/>
     * The method takes care only) about public methods.
     *
     * @Cache, то:param to Object which properties will be set.
     * @Cache, то:param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {
        String name;
        for (Method mfrom : from.getClass().getDeclaredMethods()) {            //перебираем методы from
            if (mfrom.toString().contains(".get")) {                           //если находим геттер
                name = mfrom.toString().substring(mfrom.toString().indexOf(".get")+4,mfrom.toString().length()-2); //берем имя геттера без get и скобок
                for (Method mto : to.getClass().getDeclaredMethods()) {//перебираем методы to, можно было использвать getMethod, но внутри он тоже перебирает все методы
                    if (mto.toString().contains(".set") && (mto.toString().contains(name))) {//если находим сеттер с нужным именем
                        Class<?> retFrom = mfrom.getReturnType();     //пробуем узнать информацию о типах
                        Class<?>[] parTo = mto.getParameterTypes();   //не создавая объектов (так интереснее)
                        if (parTo[0].isAssignableFrom(retFrom)) {    //если параметры для to наследники ret параметров from
                            try {
                                Object r = mfrom.invoke(from, null);
                                mto.invoke(to, r);//запускаем сеттер с параметрами, полученным  от геттера
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
