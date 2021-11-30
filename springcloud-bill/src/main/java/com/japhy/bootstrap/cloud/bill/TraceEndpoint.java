package com.japhy.bootstrap.cloud.bill;

import com.google.common.collect.Sets;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Japhy
 * @since 2021/11/3 16:15
 */
@Component
@Endpoint(id = "traces")
public class TraceEndpoint {

    private static final Set<TraceUnit> trace = Sets.newHashSet();

    @ReadOperation
    public Set<TraceUnit> traces() {
        return trace;
    }

    @Component
    @Slf4j
    static class TraceHandler {

        @EventListener
        public void onApplicationReadyEvent(ApplicationReadyEvent applicationReadyEvent) {

            log.info("Application context start to init trace information");

            Map<String, Object> beansWithAnnotation = applicationReadyEvent.getApplicationContext()
                    .getBeansWithAnnotation(FeignClient.class);
            beansWithAnnotation.forEach((s, o) -> {
                Class<?> aClass = null;
                try {
                    aClass = Class.forName(s);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                FeignClient annotation = aClass.getAnnotation(FeignClient.class);

                Set<ApiUnit> apiUnits = Sets.newHashSet();
                Method[] declaredMethods = aClass.getDeclaredMethods();
                for (Method declaredMethod : declaredMethods) {
                    RequestMapping annotation1 = declaredMethod.getAnnotation(RequestMapping.class);
                    if (annotation1 == null) {
                        continue;
                    }
                    ApiUnit build = ApiUnit.builder().methodName(annotation1.value())
                            .requestMethod(annotation1.method()).build();
                    apiUnits.add(build);
                }

                TraceUnit build =
                        TraceUnit.builder().service(annotation.value()).url(annotation.url())
                                .apis(apiUnits)
                                .build();
                trace.add(build);
            });
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class TraceUnit {

        private String service;

        private String url;

        private Set<ApiUnit> apis;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class ApiUnit {

        private String[] methodName;

        private RequestMethod[] requestMethod;
    }

}
