package by.it.academy.shopS.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Slf4j
@Aspect
@Component
public class ControllerAspect {
    private final String REQUEST_LOG_PATTERN = "{} -> {}: {}";
    private final String RESPONSE_LOG_PATTERN = "{} -> {}: {}, response: {}";

    @Pointcut("execution(* by.it.academy.shopS.controllers..*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void logRequest(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes()).getRequest();
        log.info(REQUEST_LOG_PATTERN,
                request.getMethod(),
                joinPoint.getSignature().toShortString(),
                request.getRequestURI());
    }

    @AfterReturning(pointcut = "pointCut()", returning = "response")
    public void logResponse(JoinPoint joinPoint, Object response) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes()).getRequest();
        log.info(RESPONSE_LOG_PATTERN,
                request.getMethod(),
                joinPoint.getSignature().toShortString(),
                request.getRequestURI(),
                Optional.ofNullable(response).orElse(""));
    }
}
