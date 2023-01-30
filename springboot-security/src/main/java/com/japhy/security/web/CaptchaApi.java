package com.japhy.security.web;

import com.google.code.kaptcha.Producer;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2021/1/27 16:43
 */
@RestController
@RequestMapping("/captcha")
@RequiredArgsConstructor
public class CaptchaApi {

    private final Producer captchaProducer;

    @GetMapping("/captcha.jpg")
    public void captcha(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        response.setContentType("image/jpeg");
        String text = captchaProducer.createText();
        request.getSession().setAttribute("captcha", text);
        BufferedImage image = captchaProducer.createImage(text);
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            ImageIO.write(image, "jpg", outputStream);
        }

    }
}
