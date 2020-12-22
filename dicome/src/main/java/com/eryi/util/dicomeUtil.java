package com.eryi.util;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.data.VR;
import org.dcm4che3.io.DicomInputStream;
import org.dcm4che3.util.StringUtils;

import java.io.EOFException;
import java.io.File;

/**
 * @author ZouJiaNan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月22日 14:10:00
 */
public class dicomeUtil {
    public static Attributes resetAttributes(File file) {
        Attributes attr;
        try (DicomInputStream dis = new DicomInputStream(file)) {
            try {
                attr = dis.readDataset(-1, -1);
            } catch (EOFException eof) {
                dis.setIncludeBulkData(DicomInputStream.IncludeBulkData.URI);
                attr = dis.readDataset(-1, -1);
            }
        } catch (Exception e) {
            System.out.println("获取 Attributes 失败！");
            return null;
        }
        String defCharacter = attr.getString(Tag.SpecificCharacterSet);

        //设置编码格式，否则可能或出现乱码
        attr.setString(Tag.SpecificCharacterSet, VR.PN, "GB18030");
        attr.setString(Tag.SpecificCharacterSet, VR.CS, "GB18030");

        return attr;
    }
}
