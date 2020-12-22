package com.eryi.util;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;

import java.io.File;

/**
 * @author ZouJiaNan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月22日 14:16:00
 */
public class test {
    public static void main(String[] args) {
        String attr=dicomeUtil.resetAttributes(new File("D:/shuju/IM0")).toString();
        String[] attributes=attr.split("\n");
        for (String attribute:attributes) {
            System.out.println(attribute);
        }

        System.out.println(dicomeUtil.resetAttributes(new File("D:/shuju/IM0")).getString(Tag.StudyDescription));
    }
}
