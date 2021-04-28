package com.wuzx.common.model.email;

import lombok.Data;
import lombok.ToString;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName EmailInfo.java
 * @Description TODO
 * @createTime 2021年04月22日 11:56:00
 */
@Data
@ToString
public class EmailInfo {
    private String[] to; // 发送给
    private String subject; // 邮件主题
    private String text; // 邮件内容
}
