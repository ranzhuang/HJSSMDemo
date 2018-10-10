package cn.funnyhuang.exception;

import cn.funnyhuang.Tool.HJResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect //声明这是一个切面
@Component
public class HJCustomExceptionAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(HJCustomExceptionAspect.class);
    @Autowired
    private HJCustomExceptionHandle hjCustomExceptionHandle;

    /**
     * 定义切入的位置
     */
    @Pointcut("execution(public * cn.funnyhuang.controller..*.*(..))")
    public void log() {
        System.out.println("--------log------");
    }

    /**
     * 记录了调用的接口URL等参数
     * @param joinPoint
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        LOGGER.info("url={}",request.getRequestURL());
        LOGGER.info("method={}",request.getMethod());
        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        LOGGER.info("args={}",joinPoint.getArgs());
    }

    /**
     * 在整个接口代码运作期间，我们使用@Around来捕获异常信息
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            //执行被通知的方法
            proceedingJoinPoint.proceed();
        } catch (Exception e) {
            return hjCustomExceptionHandle.execptionGet(e);
        }
        return proceedingJoinPoint.proceed();
    }

    /**
     * 使用@AfterReturning来记录我们的出參
     * @param object
     */
    @AfterReturning(pointcut = "log()", returning = "object")//打印输出结果
    public void doAfterReturning(Object object) {
        LOGGER.info("response={}",object.toString());
    }


}
