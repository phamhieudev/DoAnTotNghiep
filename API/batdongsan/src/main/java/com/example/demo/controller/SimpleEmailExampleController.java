package com.example.demo.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.MyConstants;

@Controller
public class SimpleEmailExampleController {

	@Autowired
    public JavaMailSender emailSender;
 
    @ResponseBody
    @RequestMapping("/sendSimpleEmail/{email}")
    public String sendSimpleEmail(@PathVariable(value="email") String email) {
 
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
         
        message.setTo(email);
        message.setSubject("Test Simple Email");
        message.setText("Hello, Im testing Simple Email");
 
        // Send Message!
        this.emailSender.send(message);
 
        return "Email Sent!";
    }
    
 
    
    @ResponseBody
    @RequestMapping("/sendHtmlEmail/{email}/{ten}")
    public String sendHtmlEmail(@PathVariable(value="email") String email,
    		@PathVariable(value="ten") String ten) throws MessagingException {
 
        MimeMessage message = emailSender.createMimeMessage();
 
        boolean multipart = true;
         
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "UTF-8");
         
        String htmlMsg = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
        		"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\r\n" + 
        		"\r\n" + 
        		"<head>\r\n" + 
        		"    <meta charset=\"UTF-8\">\r\n" + 
        		"    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\r\n" + 
        		"    <meta name=\"x-apple-disable-message-reformatting\">\r\n" + 
        		"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
        		"    <meta content=\"telephone=no\" name=\"format-detection\">\r\n" + 
        		"    <title></title>\r\n" + 
        		"    <!--[if (mso 16)]>\r\n" + 
        		"    <style type=\"text/css\">\r\n" + 
        		"    a {text-decoration: none;}\r\n" + 
        		"    </style>\r\n" + 
        		"    <![endif]-->\r\n" + 
        		"    <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]-->\r\n" + 
        		"    <!--[if gte mso 9]>\r\n" + 
        		"<xml>\r\n" + 
        		"    <o:OfficeDocumentSettings>\r\n" + 
        		"    <o:AllowPNG></o:AllowPNG>\r\n" + 
        		"    <o:PixelsPerInch>96</o:PixelsPerInch>\r\n" + 
        		"    </o:OfficeDocumentSettings>\r\n" + 
        		"</xml>\r\n" + 
        		"<![endif]-->\r\n" + 
        		"    <!--[if !mso]><!-- -->\r\n" + 
        		"    <link href=\"https://fonts.googleapis.com/css?family=Lato:400,400i,700,700i\" rel=\"stylesheet\">\r\n" + 
        		"    <!--<![endif]-->\r\n" + 
        		"</head>\r\n" + 
        		"\r\n" + 
        		"<body>\r\n" + 
        		"    <div class=\"es-wrapper-color\">\r\n" + 
        		"        <!--[if gte mso 9]>\r\n" + 
        		"			<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\r\n" + 
        		"				<v:fill type=\"tile\" color=\"#f4f4f4\"></v:fill>\r\n" + 
        		"			</v:background>\r\n" + 
        		"		<![endif]-->\r\n" + 
        		"        <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
        		"            <tbody>\r\n" + 
        		"                <tr class=\"gmail-fix\" height=\"0\">\r\n" + 
        		"                    <td>\r\n" + 
        		"                        <table width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\">\r\n" + 
        		"                            <tbody>\r\n" + 
        		"                                <tr>\r\n" + 
        		"                                    <td cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"line-height: 1px; min-width: 600px;\" height=\"0\"><img src=\"https://esputnik.com/repository/applications/images/blank.gif\" style=\"display: block; max-height: 0px; min-height: 0px; min-width: 600px; width: 600px;\" alt width=\"600\" height=\"1\"></td>\r\n" + 
        		"                                </tr>\r\n" + 
        		"                            </tbody>\r\n" + 
        		"                        </table>\r\n" + 
        		"                    </td>\r\n" + 
        		"                </tr>\r\n" + 
        		"                <tr>\r\n" + 
        		"                    <td class=\"esd-email-paddings\" valign=\"top\">\r\n" + 
        		"                        <table class=\"es-header es-visible-simple-html-only esd-header-popover\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
        		"                            <tbody>\r\n" + 
        		"                                <tr>\r\n" + 
        		"                                    <td class=\"esd-stripe es-stripe-html\" esd-custom-block-id=\"6339\" align=\"center\" bgcolor=\"#263A62\" style=\"background-color: #263a62;\">\r\n" + 
        		"                                        <table class=\"es-header-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
        		"                                            <tbody>\r\n" + 
        		"                                                <tr>\r\n" + 
        		"                                                    <td class=\"esd-structure es-p20t es-p10b es-p10r es-p10l\" align=\"left\">\r\n" + 
        		"                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
        		"                                                            <tbody>\r\n" + 
        		"                                                                <tr>\r\n" + 
        		"                                                                    <td class=\"esd-container-frame\" width=\"580\" valign=\"top\" align=\"center\">\r\n" + 
        		"                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
        		"                                                                            <tbody>\r\n" + 
        		"                                                                                <tr>\r\n" + 
        		"                                                                                    <td class=\"esd-block-image es-p25t es-p25b es-p10r es-p10l\" align=\"center\" style=\"font-size: 0px;\"><a href target=\"_blank\"><img src=\"https://iphycz.stripocdn.email/content/guids/efe68e89-60cb-4b20-ad22-0fcd48a7bb09/images/24251593508707667.png\" alt style=\"display: block;\" width=\"220\"></a></td>\r\n" + 
        		"                                                                                </tr>\r\n" + 
        		"                                                                            </tbody>\r\n" + 
        		"                                                                        </table>\r\n" + 
        		"                                                                    </td>\r\n" + 
        		"                                                                </tr>\r\n" + 
        		"                                                            </tbody>\r\n" + 
        		"                                                        </table>\r\n" + 
        		"                                                    </td>\r\n" + 
        		"                                                </tr>\r\n" + 
        		"                                            </tbody>\r\n" + 
        		"                                        </table>\r\n" + 
        		"                                    </td>\r\n" + 
        		"                                </tr>\r\n" + 
        		"                            </tbody>\r\n" + 
        		"                        </table>\r\n" + 
        		"                        <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
        		"                            <tbody>\r\n" + 
        		"                                <tr>\r\n" + 
        		"                                    <td class=\"esd-stripe\" esd-custom-block-id=\"6340\" align=\"center\">\r\n" + 
        		"                                        <table class=\"es-content-body\" style=\"background-color: transparent;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
        		"                                            <tbody>\r\n" + 
        		"                                                <tr>\r\n" + 
        		"                                                    <td class=\"esd-structure\" align=\"left\">\r\n" + 
        		"                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
        		"                                                            <tbody>\r\n" + 
        		"                                                                <tr>\r\n" + 
        		"                                                                    <td class=\"esd-container-frame\" width=\"600\" valign=\"top\" align=\"center\">\r\n" + 
        		"                                                                        <table style=\"background-color: #ffffff; border-radius: 4px; border-collapse: separate;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\">\r\n" + 
        		"                                                                            <tbody>\r\n" + 
        		"                                                                                <tr>\r\n" + 
        		"                                                                                    <td class=\"esd-block-text es-p35t es-p5b es-p30r es-p30l\" align=\"center\">\r\n" + 
        		"                                                                                        <h1 style=\"font-family: arial, 'helvetica neue', helvetica, sans-serif;\">Chào "
        		+ ""+ten+""
        				+ " ,</h1>\r\n" + 
        		"                                                                                    </td>\r\n" + 
        		"                                                                                </tr>\r\n" + 
        		"                                                                                <tr>\r\n" + 
        		"                                                                                    <td class=\"esd-block-spacer es-p5t es-p5b es-p20r es-p20l\" bgcolor=\"#ffffff\" align=\"center\" style=\"font-size:0\">\r\n" + 
        		"                                                                                        <table width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n" + 
        		"                                                                                            <tbody>\r\n" + 
        		"                                                                                                <tr>\r\n" + 
        		"                                                                                                    <td style=\"border-bottom: 1px solid #ffffff; background: rgba(0, 0, 0, 0) none repeat scroll 0% 0%; height: 1px; width: 100%; margin: 0px;\"></td>\r\n" + 
        		"                                                                                                </tr>\r\n" + 
        		"                                                                                            </tbody>\r\n" + 
        		"                                                                                        </table>\r\n" + 
        		"                                                                                    </td>\r\n" + 
        		"                                                                                </tr>\r\n" + 
        		"                                                                            </tbody>\r\n" + 
        		"                                                                        </table>\r\n" + 
        		"                                                                    </td>\r\n" + 
        		"                                                                </tr>\r\n" + 
        		"                                                            </tbody>\r\n" + 
        		"                                                        </table>\r\n" + 
        		"                                                    </td>\r\n" + 
        		"                                                </tr>\r\n" + 
        		"                                            </tbody>\r\n" + 
        		"                                        </table>\r\n" + 
        		"                                    </td>\r\n" + 
        		"                                </tr>\r\n" + 
        		"                            </tbody>\r\n" + 
        		"                        </table>\r\n" + 
        		"                        <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
        		"                            <tbody>\r\n" + 
        		"                                <tr>\r\n" + 
        		"                                    <td class=\"esd-stripe\" align=\"center\">\r\n" + 
        		"                                        <table class=\"es-content-body\" style=\"background-color: transparent;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
        		"                                            <tbody>\r\n" + 
        		"                                                <tr>\r\n" + 
        		"                                                    <td class=\"esd-structure\" align=\"left\">\r\n" + 
        		"                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
        		"                                                            <tbody>\r\n" + 
        		"                                                                <tr>\r\n" + 
        		"                                                                    <td class=\"esd-container-frame\" width=\"600\" valign=\"top\" align=\"center\">\r\n" + 
        		"                                                                        <table style=\"border-radius: 4px; border-collapse: separate; background-color: #ffffff;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\">\r\n" + 
        		"                                                                            <tbody>\r\n" + 
        		"                                                                                <tr>\r\n" + 
        		"                                                                                    <td class=\"esd-block-text es-p20t es-p30r es-p30l es-m-txt-l\" align=\"left\">\r\n" + 
        		"                                                                                        <p style=\"font-family: arial, 'helvetica neue', helvetica, sans-serif;\">\r\n" + 
        		"                                                                                            <font style=\"vertical-align: inherit;\">\r\n" + 
        		"                                                                                                <font style=\"vertical-align: inherit;\">Cảm ơn bạn đã đăng ký tài khoản tại ReaLand.<br>Nếu bạn có bất kỳ câu hỏi nào, chỉ cần trả lời email này, chúng tôi luôn sẵn lòng&nbsp; giúp đỡ.</font>\r\n" + 
        		"                                                                                            </font>\r\n" + 
        		"                                                                                        </p>\r\n" + 
        		"                                                                                    </td>\r\n" + 
        		"                                                                                </tr>\r\n" + 
        		"                                                                            </tbody>\r\n" + 
        		"                                                                        </table>\r\n" + 
        		"                                                                    </td>\r\n" + 
        		"                                                                </tr>\r\n" + 
        		"                                                            </tbody>\r\n" + 
        		"                                                        </table>\r\n" + 
        		"                                                    </td>\r\n" + 
        		"                                                </tr>\r\n" + 
        		"                                            </tbody>\r\n" + 
        		"                                        </table>\r\n" + 
        		"                                    </td>\r\n" + 
        		"                                </tr>\r\n" + 
        		"                            </tbody>\r\n" + 
        		"                        </table>\r\n" + 
        		"                        <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
        		"                            <tbody>\r\n" + 
        		"                                <tr>\r\n" + 
        		"                                    <td class=\"esd-stripe\" align=\"center\">\r\n" + 
        		"                                        <table class=\"es-content-body\" style=\"background-color: transparent;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
        		"                                            <tbody>\r\n" + 
        		"                                                <tr>\r\n" + 
        		"                                                    <td class=\"esd-structure\" align=\"left\">\r\n" + 
        		"                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
        		"                                                            <tbody>\r\n" + 
        		"                                                                <tr>\r\n" + 
        		"                                                                    <td class=\"esd-container-frame\" width=\"600\" valign=\"top\" align=\"center\">\r\n" + 
        		"                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
        		"                                                                            <tbody>\r\n" + 
        		"                                                                                <tr>\r\n" + 
        		"                                                                                    <td class=\"esd-block-spacer es-p10t es-p20b es-p20r es-p20l\" align=\"center\" style=\"font-size:0\">\r\n" + 
        		"                                                                                        <table width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n" + 
        		"                                                                                            <tbody>\r\n" + 
        		"                                                                                                <tr>\r\n" + 
        		"                                                                                                    <td style=\"border-bottom: 1px solid #f4f4f4; background: rgba(0, 0, 0, 0) none repeat scroll 0% 0%; height: 1px; width: 100%; margin: 0px;\"></td>\r\n" + 
        		"                                                                                                </tr>\r\n" + 
        		"                                                                                            </tbody>\r\n" + 
        		"                                                                                        </table>\r\n" + 
        		"                                                                                    </td>\r\n" + 
        		"                                                                                </tr>\r\n" + 
        		"                                                                            </tbody>\r\n" + 
        		"                                                                        </table>\r\n" + 
        		"                                                                    </td>\r\n" + 
        		"                                                                </tr>\r\n" + 
        		"                                                            </tbody>\r\n" + 
        		"                                                        </table>\r\n" + 
        		"                                                    </td>\r\n" + 
        		"                                                </tr>\r\n" + 
        		"                                            </tbody>\r\n" + 
        		"                                        </table>\r\n" + 
        		"                                    </td>\r\n" + 
        		"                                </tr>\r\n" + 
        		"                            </tbody>\r\n" + 
        		"                        </table>\r\n" + 
        		"                        <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
        		"                            <tbody>\r\n" + 
        		"                                <tr>\r\n" + 
        		"                                    <td class=\"esd-stripe\" esd-custom-block-id=\"6341\" align=\"center\">\r\n" + 
        		"                                        <table class=\"es-content-body\" style=\"background-color: transparent;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
        		"                                            <tbody>\r\n" + 
        		"                                                <tr>\r\n" + 
        		"                                                    <td class=\"esd-structure\" align=\"left\">\r\n" + 
        		"                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
        		"                                                            <tbody>\r\n" + 
        		"                                                                <tr>\r\n" + 
        		"                                                                    <td class=\"esd-container-frame\" width=\"600\" valign=\"top\" align=\"center\">\r\n" + 
        		"                                                                        <table style=\"background-color: #ffecd1; border-radius: 4px; border-collapse: separate;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffecd1\">\r\n" + 
        		"                                                                            <tbody>\r\n" + 
        		"                                                                                <tr>\r\n" + 
        		"                                                                                    <td class=\"esd-block-text es-p30t es-p30r es-p30l\" align=\"center\">\r\n" + 
        		"                                                                                        <h3 style=\"color: #111111; font-family: arial, 'helvetica neue', helvetica, sans-serif;\">Tham Quan WebSite</h3>\r\n" + 
        		"                                                                                    </td>\r\n" + 
        		"                                                                                </tr>\r\n" + 
        		"                                                                                <tr>\r\n" + 
        		"                                                                                    <td class=\"esd-block-text es-p30b es-p30r es-p30l\" esdev-links-color=\"#ffa73b\" align=\"center\"><a target=\"_blank\" href=\"http://127.0.0.1:5501/realand/index.html\" style=\"color: #ffa73b; font-family: arial, 'helvetica neue', helvetica, sans-serif;\">Click Vào Đây</a></td>\r\n" + 
        		"                                                                                </tr>\r\n" + 
        		"                                                                            </tbody>\r\n" + 
        		"                                                                        </table>\r\n" + 
        		"                                                                    </td>\r\n" + 
        		"                                                                </tr>\r\n" + 
        		"                                                            </tbody>\r\n" + 
        		"                                                        </table>\r\n" + 
        		"                                                    </td>\r\n" + 
        		"                                                </tr>\r\n" + 
        		"                                            </tbody>\r\n" + 
        		"                                        </table>\r\n" + 
        		"                                    </td>\r\n" + 
        		"                                </tr>\r\n" + 
        		"                            </tbody>\r\n" + 
        		"                        </table>\r\n" + 
        		"                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\">\r\n" + 
        		"                            <tbody>\r\n" + 
        		"                                <tr>\r\n" + 
        		"                                    <td class=\"esd-stripe\" esd-custom-block-id=\"6342\" align=\"center\">\r\n" + 
        		"                                        <table class=\"es-footer-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
        		"                                            <tbody>\r\n" + 
        		"                                                <tr>\r\n" + 
        		"                                                    <td class=\"esd-structure es-p30t es-p30b es-p30r es-p30l\" align=\"left\">\r\n" + 
        		"                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
        		"                                                            <tbody>\r\n" + 
        		"                                                                <tr>\r\n" + 
        		"                                                                    <td class=\"esd-container-frame\" width=\"540\" valign=\"top\" align=\"center\">\r\n" + 
        		"                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
        		"                                                                            <tbody>\r\n" + 
        		"                                                                                <tr>\r\n" + 
        		"                                                                                    <td class=\"esd-block-text es-p25t\" align=\"left\">\r\n" + 
        		"                                                                                        <p style=\"font-family: arial, 'helvetica neue', helvetica, sans-serif; font-size: 16px;\">06, Trần Văn Ơn, Phú Hòa, Thủ Dầu Một, Tỉnh Bình Dương</p>\r\n" + 
        		"                                                                                    </td>\r\n" + 
        		"                                                                                </tr>\r\n" + 
        		"                                                                            </tbody>\r\n" + 
        		"                                                                        </table>\r\n" + 
        		"                                                                    </td>\r\n" + 
        		"                                                                </tr>\r\n" + 
        		"                                                            </tbody>\r\n" + 
        		"                                                        </table>\r\n" + 
        		"                                                    </td>\r\n" + 
        		"                                                </tr>\r\n" + 
        		"                                            </tbody>\r\n" + 
        		"                                        </table>\r\n" + 
        		"                                    </td>\r\n" + 
        		"                                </tr>\r\n" + 
        		"                            </tbody>\r\n" + 
        		"                        </table>\r\n" + 
        		"                        <table class=\"esd-footer-popover es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
        		"                            <tbody>\r\n" + 
        		"                                <tr>\r\n" + 
        		"                                    <td class=\"esd-stripe\" align=\"center\">\r\n" + 
        		"                                        <table class=\"es-content-body\" style=\"background-color: transparent;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
        		"                                            <tbody>\r\n" + 
        		"                                                <tr>\r\n" + 
        		"                                                    <td class=\"esd-structure es-p30t es-p30b es-p20r es-p20l\" align=\"left\">\r\n" + 
        		"                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
        		"                                                            <tbody>\r\n" + 
        		"                                                                <tr>\r\n" + 
        		"                                                                    <td class=\"esd-container-frame\" width=\"560\" valign=\"top\" align=\"center\">\r\n" + 
        		"                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
        		"                                                                            <tbody>\r\n" + 
        		"                                                                                <tr>\r\n" + 
        		"                                                                                    <td class=\"esd-block-image es-infoblock made_with\" align=\"center\" style=\"font-size:0\"><a target=\"_blank\" href=\"https://viewstripo.email/?utm_source=templates&utm_medium=email&utm_campaign=software2&utm_content=trigger_newsletter\"><img src=\"https://iphycz.stripocdn.email/content/guids/CABINET_9df86e5b6c53dd0319931e2447ed854b/images/64951510234941531.png\" alt width=\"125\"></a></td>\r\n" + 
        		"                                                                                </tr>\r\n" + 
        		"                                                                            </tbody>\r\n" + 
        		"                                                                        </table>\r\n" + 
        		"                                                                    </td>\r\n" + 
        		"                                                                </tr>\r\n" + 
        		"                                                            </tbody>\r\n" + 
        		"                                                        </table>\r\n" + 
        		"                                                    </td>\r\n" + 
        		"                                                </tr>\r\n" + 
        		"                                            </tbody>\r\n" + 
        		"                                        </table>\r\n" + 
        		"                                    </td>\r\n" + 
        		"                                </tr>\r\n" + 
        		"                            </tbody>\r\n" + 
        		"                        </table>\r\n" + 
        		"                    </td>\r\n" + 
        		"                </tr>\r\n" + 
        		"            </tbody>\r\n" + 
        		"        </table>\r\n" + 
        		"    </div>\r\n" + 
        		"</body>\r\n" + 
        		"\r\n" + 
        		"</html>";
         
        message.setContent(htmlMsg,"text/html; charset=UTF-8");
//        message.setContent(htmlMsg,  "text/plain; charset=UTF-8");

        
        helper.setTo(email);
        helper.setSubject("Chào Mừng Bạn Đến Với ReaLand");
         
     
        this.emailSender.send(message);
 
        return "Email Sent!";
    }
    
    @ResponseBody
    @RequestMapping("/sendEmail/{email}/{md5}/{id}")
    public String sendEmail(@PathVariable(value="email") String email,
    		@PathVariable(value="md5") String md5,
    		@PathVariable(value="id") String id) throws MessagingException {
 
        MimeMessage message = emailSender.createMimeMessage();
 
        boolean multipart = true;
         
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "UTF-8");
         
        String htmlMsg = "<!DOCTYPE html>\r\n" + 
        		"<html>\r\n" + 
        		"\r\n" + 
        		"<head>\r\n" + 
        		"    <title></title>\r\n" + 
        		"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
        		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
        		"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n" + 
        		"    <style type=\"text/css\">\r\n" + 
        		"        @media screen {\r\n" + 
        		"            @font-face {\r\n" + 
        		"                font-family: 'Lato';\r\n" + 
        		"                font-style: normal;\r\n" + 
        		"                font-weight: 400;\r\n" + 
        		"                src: local('Lato Regular'), local('Lato-Regular'), url(https://fonts.gstatic.com/s/lato/v11/qIIYRU-oROkIk8vfvxw6QvesZW2xOQ-xsNqO47m55DA.woff) format('woff');\r\n" + 
        		"            }\r\n" + 
        		"\r\n" + 
        		"            @font-face {\r\n" + 
        		"                font-family: 'Lato';\r\n" + 
        		"                font-style: normal;\r\n" + 
        		"                font-weight: 700;\r\n" + 
        		"                src: local('Lato Bold'), local('Lato-Bold'), url(https://fonts.gstatic.com/s/lato/v11/qdgUG4U09HnJwhYI-uK18wLUuEpTyoUstqEm5AMlJo4.woff) format('woff');\r\n" + 
        		"            }\r\n" + 
        		"\r\n" + 
        		"            @font-face {\r\n" + 
        		"                font-family: 'Lato';\r\n" + 
        		"                font-style: italic;\r\n" + 
        		"                font-weight: 400;\r\n" + 
        		"                src: local('Lato Italic'), local('Lato-Italic'), url(https://fonts.gstatic.com/s/lato/v11/RYyZNoeFgb0l7W3Vu1aSWOvvDin1pK8aKteLpeZ5c0A.woff) format('woff');\r\n" + 
        		"            }\r\n" + 
        		"\r\n" + 
        		"            @font-face {\r\n" + 
        		"                font-family: 'Lato';\r\n" + 
        		"                font-style: italic;\r\n" + 
        		"                font-weight: 700;\r\n" + 
        		"                src: local('Lato Bold Italic'), local('Lato-BoldItalic'), url(https://fonts.gstatic.com/s/lato/v11/HkF_qI1x_noxlxhrhMQYELO3LdcAZYWl9Si6vvxL-qU.woff) format('woff');\r\n" + 
        		"            }\r\n" + 
        		"        }\r\n" + 
        		"\r\n" + 
        		"        /* CLIENT-SPECIFIC STYLES */\r\n" + 
        		"        body,\r\n" + 
        		"        table,\r\n" + 
        		"        td,\r\n" + 
        		"        a {\r\n" + 
        		"            -webkit-text-size-adjust: 100%;\r\n" + 
        		"            -ms-text-size-adjust: 100%;\r\n" + 
        		"        }\r\n" + 
        		"\r\n" + 
        		"        table,\r\n" + 
        		"        td {\r\n" + 
        		"            mso-table-lspace: 0pt;\r\n" + 
        		"            mso-table-rspace: 0pt;\r\n" + 
        		"        }\r\n" + 
        		"\r\n" + 
        		"        img {\r\n" + 
        		"            -ms-interpolation-mode: bicubic;\r\n" + 
        		"        }\r\n" + 
        		"\r\n" + 
        		"        /* RESET STYLES */\r\n" + 
        		"        img {\r\n" + 
        		"            border: 0;\r\n" + 
        		"            height: auto;\r\n" + 
        		"            line-height: 100%;\r\n" + 
        		"            outline: none;\r\n" + 
        		"            text-decoration: none;\r\n" + 
        		"        }\r\n" + 
        		"\r\n" + 
        		"        table {\r\n" + 
        		"            border-collapse: collapse !important;\r\n" + 
        		"        }\r\n" + 
        		"\r\n" + 
        		"        body {\r\n" + 
        		"            height: 100% !important;\r\n" + 
        		"            margin: 0 !important;\r\n" + 
        		"            padding: 0 !important;\r\n" + 
        		"            width: 100% !important;\r\n" + 
        		"        }\r\n" + 
        		"\r\n" + 
        		"        /* iOS BLUE LINKS */\r\n" + 
        		"        a[x-apple-data-detectors] {\r\n" + 
        		"            color: inherit !important;\r\n" + 
        		"            text-decoration: none !important;\r\n" + 
        		"            font-size: inherit !important;\r\n" + 
        		"            font-family: inherit !important;\r\n" + 
        		"            font-weight: inherit !important;\r\n" + 
        		"            line-height: inherit !important;\r\n" + 
        		"        }\r\n" + 
        		"\r\n" + 
        		"        /* MOBILE STYLES */\r\n" + 
        		"        @media screen and (max-width:600px) {\r\n" + 
        		"            h1 {\r\n" + 
        		"                font-size: 32px !important;\r\n" + 
        		"                line-height: 32px !important;\r\n" + 
        		"            }\r\n" + 
        		"        }\r\n" + 
        		"\r\n" + 
        		"        /* ANDROID CENTER FIX */\r\n" + 
        		"        div[style*=\"margin: 16px 0;\"] {\r\n" + 
        		"            margin: 0 !important;\r\n" + 
        		"        }\r\n" + 
        		"    </style>\r\n" + 
        		"</head>\r\n" + 
        		"\r\n" + 
        		"<body style=\"background-color: #f4f4f4; margin: 0 !important; padding: 0 !important;\">\r\n" + 
        		"    <!-- HIDDEN PREHEADER TEXT -->\r\n" + 
        		"    <div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: 'Lato', Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\"> We're thrilled to have you here! Get ready to dive into your new account. </div>\r\n" + 
        		"    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
        		"        <!-- LOGO -->\r\n" + 
        		"        <tr>\r\n" + 
        		"            <td bgcolor=\"#263a62\" align=\"center\">\r\n" + 
        		"                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\r\n" + 
        		"                    <tr>\r\n" + 
        		"                        <td align=\"center\" valign=\"top\" style=\"padding: 40px 10px 40px 10px;\"> </td>\r\n" + 
        		"                    </tr>\r\n" + 
        		"                </table>\r\n" + 
        		"            </td>\r\n" + 
        		"        </tr>\r\n" + 
        		"        <tr>\r\n" + 
        		"            <td bgcolor=\"#263a62\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\r\n" + 
        		"                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\r\n" + 
        		"                    <tr>\r\n" + 
        		"                        <td bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" style=\"padding: 40px 20px 20px 20px; border-radius: 4px 4px 0px 0px; color: #111111; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400; letter-spacing: 4px; line-height: 48px;\">\r\n" + 
        		"                            <h1 style=\"font-size: 48px; font-weight: 400; margin: 2;\">YÊU CẦU ĐẶT LẠI MẬT KHẨU!</h1> <img src=\"https://firebasestorage.googleapis.com/v0/b/doantotnghiep-276412.appspot.com/o/1593533835438-logo_dark.png?alt=media&token=73ef64ba-b21d-4510-a34b-6c56fade2d91\" width=\"150\" height=\"130\" style=\"display: block; border: 0px;\" />\r\n" + 
        		"                        </td>\r\n" + 
        		"                    </tr>\r\n" + 
        		"                </table>\r\n" + 
        		"            </td>\r\n" + 
        		"        </tr>\r\n" + 
        		"        <tr>\r\n" + 
        		"            <td bgcolor=\"#f4f4f4\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\r\n" + 
        		"                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\r\n" + 
        		"                    <tr>\r\n" + 
        		"                        <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 20px 30px 40px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">\r\n" + 
        		"                            <p style=\"margin: 0;\">Để thiết lập lại mật khẩu của bạn, xin vui lòng bấm vào nút bên dưới.</p>\r\n" + 
        		"                        </td>\r\n" + 
        		"                    </tr>\r\n" + 
        		"                    <tr>\r\n" + 
        		"                        <td bgcolor=\"#ffffff\" align=\"left\">\r\n" + 
        		"                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
        		"                                <tr>\r\n" + 
        		"                                    <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 20px 30px 60px 30px;\">\r\n" + 
        		"                                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
        		"                                            <tr>\r\n" + 
        		"                                                <td align=\"center\" style=\"border-radius: 3px;\" bgcolor=\"#FFA73B\"><a href=\"http://127.0.0.1:5501/realand/datlaiatkhau.html?md5="
        		+""+md5+""
        		+"?abz="
        		+""+id+""
        		+ "\" target=\"_blank\" style=\"font-size: 20px; font-family: Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; color: #ffffff; text-decoration: none; padding: 15px 25px; border-radius: 2px; border: 1px solid #FFA73B; display: inline-block;\">ĐẶT LẠI MẬT KHẨU</a></td>\r\n" + 
        		"                                            </tr>\r\n" + 
        		"                                        </table>\r\n" + 
        		"                                    </td>\r\n" + 
        		"                                </tr>\r\n" + 
        		"                            </table>\r\n" + 
        		"                        </td>\r\n" + 
        		"                    </tr> <!-- COPY -->\r\n" + 
        		"                  \r\n" + 
        		"                 \r\n" + 
        		"                </table>\r\n" + 
        		"            </td>\r\n" + 
        		"        </tr>\r\n" + 
        		"        <tr>\r\n" + 
        		"            <td bgcolor=\"#f4f4f4\" align=\"center\" style=\"padding: 30px 10px 0px 10px;\">\r\n" + 
        		"                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\r\n" + 
        		"                    <tr>\r\n" + 
        		"                        <td bgcolor=\"#FFECD1\" align=\"center\" style=\"padding: 30px 30px 30px 30px; border-radius: 4px 4px 4px 4px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">\r\n" + 
        		"                            <h2 style=\"font-size: 20px; font-weight: 400; color: #111111; margin: 0;\">Bạn Cần Sự Trợ Giúp ?</h2>\r\n" + 
        		"                            <p style=\"margin: 0;\"><a href=\"#\" target=\"_blank\" style=\"color: #FFA73B;\">Liên Hệ</a></p>\r\n" + 
        		"                        </td>\r\n" + 
        		"                    </tr>\r\n" + 
        		"                </table>\r\n" + 
        		"            </td>\r\n" + 
        		"        </tr>\r\n" + 
        		"        <tr>\r\n" + 
        		"            <td bgcolor=\"#f4f4f4\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\r\n" + 
        		"                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\r\n" + 
        		"                    <tr>\r\n" + 
        		"                        <td bgcolor=\"#f4f4f4\" align=\"left\" style=\"padding: 0px 30px 30px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 14px; font-weight: 400; line-height: 18px;\"> <br>\r\n" + 
        		"                            <p style=\"margin: 0;\">© 2017 ReaLand Real Estate. All Right Reserved..</p>\r\n" + 
        		"                        </td>\r\n" + 
        		"                    </tr>\r\n" + 
        		"                </table>\r\n" + 
        		"            </td>\r\n" + 
        		"        </tr>\r\n" + 
        		"    </table>\r\n" + 
        		"</body>\r\n" + 
        		"\r\n" + 
        		"</html>";
         
        message.setContent(htmlMsg,"text/html; charset=UTF-8");

        helper.setTo(email);
        helper.setSubject("Yêu cầu cấp lại mật khẩu");
         
     
        this.emailSender.send(message);
 
        return "Email Sent!";
    }
}
