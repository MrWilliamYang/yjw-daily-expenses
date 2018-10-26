package com.yjw.interview.interview.huawei;

/**
 * 选择
 * Which instantiates an instance of Inner?
 * A. new Inner(); // At line 3
 * B. new Inner(); // At line 8
 * C. new o.Inner(); // At line 8
 * D. new Outer.Inner(); // At line 8//new Outer().new Inner()
 * 
 * @author 总统
 * @version $Id: Test4.java, v 0.1 2018年5月28日 下午2:26:51 总统 Exp $
 */
public class Test4 {
    
    public void someOuterMethod() {
        // Line 3
        new Inner();//放在这里不出错
     }
     public class Inner {
     }
  
     public static void main(String[] argv) {
//        Outer o= new Outer();
        // Line 8
        //o不能够被解释成为一种类型，出错
        //new o.Inner();
        /**
         *下面两种用法，都报下面的错误：
         *NoenclosinginstanceoftypeOuterisaccessible.
         *Must qualify the allocation with an enclosing instance
         *oftypeOuter(e.g.x.newA()wherexisaninstanceofOuter)
         */   
        //new Outer.Inner();
        //new Inner();      
     }
}
