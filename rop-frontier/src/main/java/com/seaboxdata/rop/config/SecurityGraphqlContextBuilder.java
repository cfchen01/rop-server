//package com.seaboxdata.rop.config;
//
//import com.seaboxdata.commons.graphql.AutoscanBatchLoaderContextBuilder;
//import org.dataloader.BatchLoaderContextProvider;
//import org.dataloader.BatchLoaderEnvironment;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class SecurityGraphqlContextBuilder extends AutoscanBatchLoaderContextBuilder {
//    public static String SEC_CONTEXT = "SEC_CONTEXT";
//    public static String REQ_ATTRS = "REQ_ATTRIBUTES";
//
//    @Override
//    protected BatchLoaderContextProvider buildBatchLoaderContextProvider() {
//        return new BatchLoaderContextProvider() {
//            private SecurityContext securityContext = SecurityContextHolder.getContext();
//            private ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//            @Override
//            public Object getContext() {
//                Map<String, Object> context = new HashMap<>(2);
//                context.put(SEC_CONTEXT, securityContext);
//                context.put(REQ_ATTRS, requestAttributes);
//                return context;
//            }
//        };
//    }
//
//    /**
//     * 配置 context
//     * @param env
//     */
//    public static void setSecurityContext(BatchLoaderEnvironment env) {
//        Map<String ,Object> context = env.getContext();
//        SecurityContext securityContext = (SecurityContext) context.get(SecurityGraphqlContextBuilder.SEC_CONTEXT);
//        SecurityContextHolder.setContext(securityContext);
//
//        RequestAttributes requestAttributes = (RequestAttributes) context.get(SecurityGraphqlContextBuilder.REQ_ATTRS);
//        RequestContextHolder.setRequestAttributes(requestAttributes);
//    }
//}
