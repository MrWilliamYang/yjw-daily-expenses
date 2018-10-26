package com.yjw.interview.interview.huawei;

/**
 * 看题选择
 * 
 * Which two are valid in a class that extends class A? (Choose two)
 * A. public int method1(int a, int b) { return 0; }
 * B. private int method1(int a, int b) { return 0; }
 * C. private int method1(int a, long b) { return 0; }
 * D. public short method1(int a, int b) { return 0; }
 * E. static protected int method1(int a, int b) { return 0; }
 * 
 * @author 总统
 * @version $Id: Test3.java, v 0.1 2018年5月28日 下午2:13:40 总统 Exp $
 */
public class Test3 {
    
    public class A {
        protected int method1(int a, int b) { return 0; }
    }
    
    public class B extends A{
        /**
         *@paramargs
         */
       
        //can not reduce the visibility of the inherited method from A
        //即不能够使从类A中继续来的方法的可见性降低  
        //private int method1(int a, int b) { return 0; }
       
        //This static method cannot hide the instance method from A
        //静态方法不能够隐藏继承于A的实例
        //static protected int method1(int a, int b) { return 0; }
       
        //返回类型与A中的该方法不一致
        //public short method1(int a, int b) { return 0; }
       
        /**
         *总结：类的继承中，如果要想重载父类的方法，必须要和父类中的返回类型、可见性等等都要操作一致
         *否则，程序就会报错。一定遵守子类要遵从于父类的原则
         *而我选择的答案居然是private int method1和static protected int
         *我选择第一个的错误理由是：因为原来为保护的，如果我这里设为public，那么就扩展了其原来的可见性
         *本来原来就是对包外不可见的，现在变成对包外可见的了，所以就选择的是private
         *选择第二个的错误理由是：都是保护的，这里只是变成了静态的而已
         */
       
        //这里是写了一个重载方法，因为参数类型不一致，不会报错
        @SuppressWarnings("unused")
        private int method1(int a, long b) { return 0; }
       
        //可见性可以增大，但是不能够缩小，正确
        public int method1(int a, int b) { return 0; }
       
        public void main(String[] args) {
           // TODO Auto-generated method stub
     
        }
    }
}
