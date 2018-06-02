package com.sinosoft.common;

import lombok.Data;

/**
 * @author xushuyi 18/05/20
 */
@Data
public class ResMsg {

    /**
     * 返回消息状态码（200 成功；400 失败）
     */
    private String resCode;

    /**
     * 返回消息内容
     */
    private String resMsg;

}
