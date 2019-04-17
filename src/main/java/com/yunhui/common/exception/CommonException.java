package com.yunhui.common.exception;

import com.yunhui.common.result.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Title: CommonException.java <br>
 * Description: <br>
 * Copyright (c) 聚阿网络科技版权所有 2019 <br>
 * Create DateTime: 2019年03月11日 19:55 <br>
 *
 * @author yun
 */
@Data
@NoArgsConstructor
public class CommonException extends RuntimeException {

    protected ResultCode resultCode;

    protected String appendMsg;

    public CommonException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public CommonException(ResultCode resultCode, String apendMsg) {
        this.resultCode = resultCode;
        this.appendMsg = apendMsg;
    }


}
