package com.sgyj.commonservice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RestBaseAnnotation {}
