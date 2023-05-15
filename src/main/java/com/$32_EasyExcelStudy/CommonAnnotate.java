package com.$32_EasyExcelStudy;

/*
    设置样式注解:
        @ExcelProperty:
            必要的一个注解, 注解中有三个参数value, index, converter分别代表字段名, 列序号, 数据转换方式
            value ==> 用来设置表头字段名
            index ==> 控制写入字段顺序, 0为第一列, 1为第二列, 依次类推
            converter ==> 转换器, 通常入库和出库转换使用, 如性别入库0和1, 出库男和女
        @ColumnWith:
            设置列宽, 只有一个参数value, 单位是字符长度, 最大可以设置255个字符, 因为一个excel单元格最大可以写入的字符个数就是255个字符
        @ContentRowHeight:
            用于设置内容行高, 参数 ==> value, 为数字, -1代表自动行高
        @HeadRowHeight:
            用于设置表头行高, 参数 ==> value, 为数字, -1代表自动行高
        @ContentFontStyle:
            用于设置单元格内容字体格式的注解
            参数:
                fontName 字体名称
                fontHeightInPoints 字体高度
                italic 是否斜体
                strikeout 是否设置删除水平线
                color 字体颜色
                typeOffset 偏移量
                underline 下划线
                bold 是否加粗
                charset 编码格式
        @ContentLoopMerge:
            用于设置合并单元格的注解
            参数:
                eachRow: 设置合并行数, 每多少行合并为一个单元格
                columnExtend: 设置合并列数, 每多少列合并为一个单元格
        @ContentStyle:
            设置字段内容格式注解
            参数:
                dataFormat 日期格式
                hidden 设置单元格使用此样式隐藏
                locked 设置单元格使用此样式锁定
                quotePrefix 在单元格前面增加`符号，数字或公式将以字符串形式展示
                horizontalAlignment 设置是否水平居中
                wrapped 设置文本是否应换行, 将此标志设置为true通过在多行上显示使单元格中的所有内容可见
                verticalAlignment 设置是否垂直居中
                rotation 设置单元格中文本旋转角度, 03版本的Excel旋转角度区间为-90°90°, 07版本的Excel旋转角度区间为0°180°
                indent 设置单元格中缩进文本的空格数
                borderLeft 设置左边框的样式
                borderRight 设置右边框样式
                borderTop 设置上边框样式
                borderBottom 设置下边框样式
                leftBorderColor 设置左边框颜色
                rightBorderColor 设置右边框颜色
                topBorderColor 设置上边框颜色
                bottomBorderColor 设置下边框颜色
                fillPatternType 设置填充类型
                fillBackgroundColor 设置背景色
                fillForegroundColor 设置前景色
                shrinkToFit 设置自动单元格自动大小
        @HeadFontStyle:
            用于设置标题字体格式
            参数:
                fontName 设置字体名称
                fontHeightInPoints 设置字体高度
                italic 设置字体是否斜体
                strikeout 是否设置删除线
                color 设置字体颜色
                typeOffset 设置偏移量
                underline 设置下划线
                charset 设置字体编码
                bold 设置字体是否加粗
        @HeadStyle:
            设置表头样式
            参数:
                dataFormat 日期格式
                hidden 设置单元格使用此样式隐藏
                locked 设置单元格使用此样式锁定
                quotePrefix 在单元格前面增加`符号，数字或公式将以字符串形式展示
                horizontalAlignment 设置是否水平居中
                wrapped 设置文本是否应换行, 将此标志设置为true通过在多行上显示使单元格中的所有内容可见
                verticalAlignment 设置是否垂直居中
                rotation 设置单元格中文本旋转角度, 03版本的Excel旋转角度区间为-90°90°, 07版本的Excel旋转角度区间为0°180°
                indent 设置单元格中缩进文本的空格数
                borderLeft 设置左边框的样式
                borderRight 设置右边框样式
                borderTop 设置上边框样式
                borderBottom 设置下边框样式
                leftBorderColor 设置左边框颜色
                rightBorderColor 设置右边框颜色
                topBorderColor 设置上边框颜色
                bottomBorderColor 设置下边框颜色
                fillPatternType 设置填充类型
                fillBackgroundColor 设置背景色
                fillForegroundColor 设置前景色
                shrinkToFit 设置自动单元格自动大小
        @ExcelIgnore:
            不将被标注该注解字段转换成Excel
        @ExcelIgnoreUnannotated:
            没有注解的字段都不转换
        @DateTimeFormat ==> 日期格式化注解
        @NumberFormat ==> 数字格式化注解(小数或者百分数)
 */

public class CommonAnnotate {
}
