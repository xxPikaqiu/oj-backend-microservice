package com.cbh.ojbackendcommon.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限校验
 * @interface AuthCheck：定义了一个自定义注解名为 AuthCheck。
 * @Target(ElementType.METHOD)：指定该注解仅可用于方法上。
 *
 * @Retention 是一个元注解，用于指定注解的保留策略，即注解在代码中的存活时间。Java 支持三种保留策略，分别是 SOURCE、CLASS 和 RUNTIME。
 * RetentionPolicy.SOURCE： 表示注解仅在源代码阶段保留，编译器会丢弃这种类型的注解，不会包含在编译后的 class 文件中。这意味着在运行时无法通过反射获取到这类注解。
 * RetentionPolicy.CLASS： 表示注解在编译时保留，会包含在编译后的 class 文件中，但在运行时无法通过反射获取到这类注解。这是默认的保留策略，如果不指定 @Retention，则默认为 CLASS。
 * RetentionPolicy.RUNTIME： 表示注解在运行时保留，可以通过反射机制在运行时获取到这类注解。这意味着你可以在程序运行时通过反射获取并处理这些注解信息。
 * @Retention(RetentionPolicy.RUNTIME)：指定该注解在运行时保留，因此可以通过反射机制在运行时获取注解信息。
 *
 * @author 小皮卡
 * @from cbh
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthCheck {

    /**
     * 必须有某个角色
     *
     * @return
     */
    String mustRole() default "";

}

