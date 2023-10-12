package edu.bjtu.quartz.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应体封装对象  YJ_20220920
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {
    private static final int SUCCESS = 0;
    private static final int FAILURE = 1;
    private int code; // 0代表成功, 1代表失败

    private Object data;    //用于向前台传递对象

    private String msg;    //提示信息

    public static ResultVO success(Object data){
        return new ResultVO(SUCCESS, data, null);
    }

    public static  ResultVO success(String msg){
        return new ResultVO(SUCCESS, null, msg);
    }

    public static ResultVO success(Object data, String msg){
        return new ResultVO(SUCCESS, data, msg);
    }

    public static ResultVO failure (String msg) {
        return new ResultVO(FAILURE, null, msg);
    }

    public static ResultVO failure(Object data) {
        return new ResultVO(FAILURE, data, null);
    }

    public static ResultVO failure(Object data, String msg) {
        return new ResultVO(FAILURE, data, msg);
    }

    public boolean isSuccess(){
        return code == SUCCESS;
    }
}


