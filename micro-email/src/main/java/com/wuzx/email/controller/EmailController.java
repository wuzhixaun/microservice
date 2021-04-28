package com.wuzx.email.controller;


import com.wuzx.common.model.user.UserInfo;
import com.wuzx.email.model.EmailInfo;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName EmailController.java
 * @Description TODO
 * @createTime 2021年04月22日 11:49:00
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String userName;

    @Autowired
    private Configuration freemarkerConfiguration;



    /**
     * 发送普通邮件
     * @param info
     * @return
     */
    @PostMapping("/send")
    public String sendMail(@RequestBody EmailInfo info) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(userName);
        mailMessage.setTo(info.getTo());
        mailMessage.setSubject(info.getSubject());
        mailMessage.setText(info.getText());
        javaMailSender.send(mailMessage);
        return "success";
    }

    /**
     * 发送html格式文档
     * @param info
     * @throws MessagingException
     */
    @PostMapping("/send/html")
    public String sendHtmlMail(@RequestBody EmailInfo info) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mailMessage = new MimeMessageHelper(mimeMessage);
        mailMessage.setFrom(userName);
        mailMessage.setTo(info.getTo());
        mailMessage.setSubject(info.getSubject());
        // 第二个参数表示是否html，设为true
        mailMessage.setText(String.format("<h1>%s</h1>",info.getText()), true);

        this.javaMailSender.send(mimeMessage);
        return "success";
    }


    /**
     * 发送html格式文档
     * @param info
     * @throws MessagingException
     */
    @PostMapping("/send/freemarker")
    public String sendFreemarkerMail(@RequestBody EmailInfo info) throws Exception {
        MimeMessage message = this.javaMailSender.createMimeMessage();
        // 第二个参数表示是否开启multipart模式
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setFrom(userName);
        messageHelper.setTo(info.getTo());
        messageHelper.setSubject("基于freemarker模板的邮件测试");

        Map<String, Object> model = new HashMap<>();
        model.put("username", "itmuch");
        model.put("event", "IT牧场大事件");

        String content = FreeMarkerTemplateUtils.processTemplateIntoString(
                this.freemarkerConfiguration.getTemplate("mail.ftl"), model);

        // 第二个参数表示是否html，设为true
        messageHelper.setText(content, true);

        this.javaMailSender.send(message);

        return "success";

    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public UserInfo findById(@PathVariable Long id) {
        // 这里用到了RestTemplate的占位符能力
        UserInfo user = this.restTemplate.getForObject("http://localhost:8000/user/{id}", UserInfo.class, id);
        // ...电影微服务的业务...
        return user;
    }
}
