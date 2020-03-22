package com.xnyc.blog;

import com.xnyc.blog.domain.mail.MailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author : 郑杜
 * @date : 2020/03/15
 */
public class MailTest extends BlogApplicationTests {

    private String receptionMailAddr = "976007468@qq.com";

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 测试 文本邮件
     */
    //@Test
    public void testSimpleMail() throws Exception {
        mailService.sendTextMail(receptionMailAddr, "测试文本邮箱发送", "你好你好！");
    }

    /**
     * 测试 html 邮箱
     */
    //@Test
    public void testHtmlMail() throws Exception {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail(receptionMailAddr, "test simple mail", content);
    }

    //@Test
    public void sendAttachmentsMail() {
        String filePath = "C:\\\\Users\\\\Administrator\\\\Desktop\\\\java并发学习.txt";
        mailService.sendAttachmentsMail(receptionMailAddr, "主题：带附件的邮件", "有附件，请查收！", filePath);
    }


    //@Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content = "<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\\\Users\\\\Administrator\\\\Desktop\\\\testMail.png";

        mailService.sendInlineResourceMail(receptionMailAddr, "主题：这是有图片的邮件", content, imgPath, rscId);
    }


    //@Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("name", "I am zd.");

        // 传递 emailTemplate.html 模板需要的值，并将模板转换为 String
        String emailContent = templateEngine.process("email", context);

        mailService.sendHtmlMail(receptionMailAddr, "主题：这是模板邮件", emailContent);
    }

}
