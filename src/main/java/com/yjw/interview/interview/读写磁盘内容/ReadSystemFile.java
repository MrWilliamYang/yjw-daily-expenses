/**
 * hxgy Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yjw.interview.interview.读写磁盘内容;

import java.io.File;

/**
 * 读取指定盘符的所有文件夹名
 * 
 * @description ReadSystemFile.java, 
 * @author YangJianWei
 * @date 2018年9月4日 上午9:16:44 
 * @version $Id: v 0.1 
 */
public class ReadSystemFile {

    /**
     * 判断目录是否为空
     * 
     * @param file2
     * @return
     */
    @SuppressWarnings("unused")
    private static boolean isEntity(String file2) {
        File file = new File(file2);
        if (file.isDirectory()) {
            String files[] = file.list();
            if (files.length > 0) {
                return false;
            }
        }
        return true;
    }

    
    
    public static void main(String[] args) {
        File file = new File("C:\\");
        System.out.println(file.getPath());
    }

}
