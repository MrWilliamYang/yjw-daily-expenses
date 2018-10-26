package com.yjw.interview.interview.继承;

/**
 * 继承 - 父类与子类关系(子类)
 * 
 * @description ChildClass.java, 
 * @author YangJianWei
 * @date 2018年9月3日 上午9:48:21 
 * @version $Id: v 0.1 
 */
public class ChildClass extends FatherClass {

    public ChildClass() {
        System.out.println("ChildClass Create");
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        FatherClass fc = new FatherClass();
        @SuppressWarnings("unused")
        ChildClass cc = new ChildClass();
    }

}
