package com.sgyj.commonservice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Target( ElementType.TYPE )
@Retention( RetentionPolicy.RUNTIME )
public @interface BaseServiceAnnotation {}
