package com.$32_EasyExcelStudy.WriteData;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.converters.string.StringImageConverter;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

@ContentRowHeight(300)
@ColumnWidth(30)
public class ImageData {
    // 使用抽象文件表示一张图片
    private File file;
    // 使用输入流保存一张图片
    private InputStream inputStream;
    /**
     * 定义字符串保存图片数据, 需要用到StringImageConverter转换器
     */
    @ExcelProperty(converter = StringImageConverter.class)
    private String string;
    // 使用二进制数据保存为一个图片
    private byte[] byteArray;
    // 使用网络连接保存一个图片
    private URL url;

    public ImageData() {
    }

    public ImageData(File file, InputStream inputStream, String string, byte[] byteArray, URL url) {
        this.file = file;
        this.inputStream = inputStream;
        this.string = string;
        this.byteArray = byteArray;
        this.url = url;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public byte[] getByteArray() {
        return byteArray;
    }

    public void setByteArray(byte[] byteArray) {
        this.byteArray = byteArray;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ImageData{" +
                "file=" + file +
                ", inputStream=" + inputStream +
                ", string='" + string + '\'' +
                ", byteArray=" + Arrays.toString(byteArray) +
                ", url=" + url +
                '}';
    }
}
