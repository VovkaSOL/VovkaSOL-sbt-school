package com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part3beanutils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BeanUtilsTest {

   class mytestclass1{
           public int val=0;
           int getVal() {
               return val;
           }
           void setVal(int v){
               val=v;
          }
   }
    class mytestclass2{
        public Number val=0;
        Number getVal() {
            return val;
        }
        void setVal(int v){
            val=v;
        }
    }

    @Test
    void testAssign() {
        System.out.println("BeanUtilsTest method Assign testing start");
        mytestclass1 o1=new mytestclass1();
        o1.val=123;//тип int
        mytestclass2 o2=new mytestclass2();
        o2.val=0;//тип Number
        BeanUtils.assign( o2, o1);//int в Number лезет
        Assertions.assertEquals(o1.val, o2.val);
        o2.val=0;//тип Number
        BeanUtils.assign( o1, o2);//Number в int не лезет
        Assertions.assertNotEquals(o1.val, o2.val);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme