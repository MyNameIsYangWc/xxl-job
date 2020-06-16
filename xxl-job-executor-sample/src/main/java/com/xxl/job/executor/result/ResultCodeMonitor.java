package com.xxl.job.executor.result;

import org.apache.log4j.Logger;

/**
 * 请求返回码监控
 */
public class ResultCodeMonitor {

    private static Logger logger= Logger.getLogger(ResultCodeMonitor.class);

    public static void handler(Result result,String msg){

        if(result != null){
                //200成功
            if (result.getCode()==ResultCode.successCode.getCode()){
                logger.info(msg+"-"+ResultCode.successCode.getMsg());
                return;
               //201业务异常
            }else if(result.getCode()==ResultCode.businErrorCode.getCode()){
                logger.info(msg+"-"+ResultCode.businErrorCode.getMsg());
                return;
                //202系统异常
            }else if(result.getCode()==ResultCode.SystemErrorCode.getCode()){
                logger.info(msg+"-"+ResultCode.SystemErrorCode.getMsg());
                return;
                //203超时
            }else if(result.getCode()==ResultCode.SystemTimeOutCode.getCode()){
                logger.info(msg+"-"+ResultCode.SystemTimeOutCode.getMsg());
                return;
            }
        }
        logger.info(msg+"-"+ResultCode.SystemErrorCode.getMsg());
    }
}
