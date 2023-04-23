package com.japhy.basic.annotation;

import com.google.auto.service.AutoService;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic.Kind;
import lombok.SneakyThrows;

/**
 * @author Japhy
 * @since 2021/1/15 16:17
 */
@AutoService(Process.class)
public class MyAnnotationProcessor extends AbstractProcessor {

    private Messager mMessager;
    private Elements mElementUtils;
    private Filer filer;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mMessager = processingEnv.getMessager();
        mElementUtils = processingEnv.getElementUtils();
        filer = processingEnv.getFiler();
        System.out.println("init===================" + processingEnv.getElementUtils().toString());
    }

    @SneakyThrows
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        mMessager.printMessage(Kind.NOTE, "processing -----------------");
        String s = processingEnv.getOptions().get("custom-param");
        System.out.println("custom-param:" + s);
        Path path = Paths.get("classpath:a.yml");
        Files.write(path, "hello world".getBytes(), StandardOpenOption.APPEND);
        return false;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(MyAnnotation.class.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
