package cn.funnyhuang.exception;
import cn.funnyhuang.Tool.HJResult;
import cn.funnyhuang.Tool.HJResultTypeTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**

* @Description:    java类作用描述

* @Author:         HJ

* @CreateDate:     2018/9/25 下午3:33

* @UpdateUser:     HJ

* @UpdateDate:     2018/9/25 下午3:33

* @UpdateRemark:   修改内容

* @Version:        1.0

*/

/**
 * @ControllerAdvice ，使Spring能加载该类
 */
@ControllerAdvice
public class HJCustomExceptionHandle  {

    private final static Logger LOGGER = LoggerFactory.getLogger(HJCustomExceptionHandle.class);

    /**
     * 将所有捕获的异常统一返回结果Result这个实体
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HJResult execptionGet(Exception e) {
        HJCustomException hjCustomException = null;
        if (e instanceof HJCustomException) {
            hjCustomException = (HJCustomException) e;
            return HJResultTypeTool.error(hjCustomException.getCode(),hjCustomException.getMessage());
        } else  {
            LOGGER.error("【系统异常】{}",e);
            return  HJResultTypeTool.errorException(HJCustomExceptionEnum.UNKNOWN_ERROR);
        }
    }
}
