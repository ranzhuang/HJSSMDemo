package cn.funnyhuang.Tool;

import cn.funnyhuang.exception.HJCustomExceptionEnum;

/**

* @Description:    返回对象工具类

* @Author:         HJ

* @CreateDate:     2018/9/21 下午3:22

* @UpdateUser:     HJ

* @UpdateDate:     2018/9/21 下午3:22

* @UpdateRemark:   修改内容

* @Version:        1.0

*/
public class HJResultTypeTool {
    /**
     * 成功
     * @param object
     * @return 请求返回最外层的对象
     */
    public static HJResult success(Object object) {
        HJResult result = new HJResult();
        result.setCode(200);
        result.setMsg("请求成功");
        result.setData(object);
        return  result;
    }

    /**
     * 成功
     * @return
     */
    public static  HJResult successNoData() {
        return success(null);
    }

    /**
     * 失败
     * @param code 错误编码
     * @param msg 错误信息
     * @return
     */
    public static HJResult error(Integer code, String msg) {
        HJResult result = new HJResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 返回异常信息，在已知的范围内
     * @param hjCustomExceptionEnum
     * @return
     */
    public  static  HJResult errorException(HJCustomExceptionEnum hjCustomExceptionEnum) {
        HJResult result = new HJResult();
        result.setCode(hjCustomExceptionEnum.getCode());
        result.setMsg(hjCustomExceptionEnum.getMessage());
        result.setData(null);
        return result;
    }
}
