package com.jhlc.record.core.aop;

import com.jhlc.record.controller.resp.Result;
import com.jhlc.record.controller.resp.ResultEnum;
import com.jhlc.record.controller.resp.ResultUtils;
import com.jhlc.record.core.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;


/**
 * @author 10096
 */
@Aspect
@Component
@Slf4j
public class ControlAccessInterceptor {

    /**
     * 过期时间
     */
    public static long exptime = 300;

    @Autowired
    RedisService redisService;

    /**
     * 控制该方法同时访问
     * @param proceedingJoinPoint
     * @return
     */
    @Around("@annotation(com.jhlc.record.core.annotation.ControlAccess)")
    public Result around(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] parms = proceedingJoinPoint.getArgs();
        String methodName = proceedingJoinPoint.getSignature().getName();
        StringBuilder redisKey = new StringBuilder(methodName);
        Stream.of(parms).forEach(o -> redisKey.append(o));
        Result result;
        try {
            if (redisService.setIfAbsent(redisKey.toString(),true,exptime)) {
                result = (Result) proceedingJoinPoint.proceed();
                redisService.del(redisKey.toString());
            } else {
                result = ResultUtils.success(ResultEnum.MAS_REQUEST_CODE);
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            result = ResultUtils.error(ResultEnum.EXCEPTION);
        }finally {
            redisService.del(redisKey.toString());
        }
        return result;
    }
}
