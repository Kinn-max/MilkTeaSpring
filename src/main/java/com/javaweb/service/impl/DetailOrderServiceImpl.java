package com.javaweb.service.impl;

import com.javaweb.Security.utils.SecurityUtils;
import com.javaweb.converter.DetailOrderConverter;
import com.javaweb.dto.DetailOrderDTO;
import com.javaweb.entity.DetailOrder;
import com.javaweb.entity.Order;
import com.javaweb.repository.DetailOrderRepository;
import com.javaweb.repository.OrderRepository;
import com.javaweb.service.DetailOrderService;
import com.javaweb.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DetailOrderServiceImpl implements DetailOrderService {
    @Autowired
    private DetailOrderRepository detailOrderRepository;

    @Autowired
    private DetailOrderConverter detailOrderConverter;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EmailService emailService;
    @Override
    public void addDetailOrder(DetailOrderDTO detailOrderDTO) {
        DetailOrder detailOrder = detailOrderConverter.convertToDetailOrder(detailOrderDTO);
        detailOrderRepository.save(detailOrder);
        List<Order> listOrder = orderRepository.getAllOrderByUserId(SecurityUtils.getMyUser().getId(), false);
        for (Order order : listOrder) {
            order.setStatus(true);
            order.setDetailOrder(detailOrder);
            orderRepository.save(order);
        }
        detailOrderRepository.save(detailOrder);
        sendEmail("kienmax200418@gmail.com", activationCodeRanDom());
    }



    private  String activationCodeRanDom(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }

        String randomSixDigitString = sb.toString();
        return randomSixDigitString;
    }

    private  void sendEmail(String email, String activationCode){
        String subject = "Thông báo kích hoạt tài khoản của bạn tại Cửa Hàng Kinn";
        String url = "http://localhost:3000/activate/"+email+"/" +activationCode;
        String text = "<html><body> <h3>Cửa h&agrave;ng Kinn xin tr&acirc;n trọng th&ocirc;ng b&aacute;o về việc gửi m&atilde; k&iacute;ch hoạt t&agrave;i khoản đến qu&yacute; kh&aacute;ch h&agrave;ng.</h3>\n" +
                "<p>Sau khi qu&yacute; kh&aacute;ch ho&agrave;n tất việc đăng k&yacute; t&agrave;i khoản tr&ecirc;n trang web của ch&uacute;ng t&ocirc;i, email n&agrave;y sẽ chứa một m&atilde; k&iacute;ch hoạt duy nhất để bảo đảm an to&agrave;n v&agrave; x&aacute;c minh t&agrave;i khoản.</p>\n" +
                "<p>H&atilde;y nhập m&atilde; v&agrave;o trang website Cửa h&agrave;ng Kinn để được k&iacute;ch hoạt t&agrave;i khoản:</p>\n" +
                "<p><strong>M&atilde; code:</strong>&nbsp; <strong>"+activationCode+"</strong></p>\n" +
                "<p><strong>Hoặc click v&agrave;o đường link n&agrave;y:<a href=\""+url+"\">Tại đ&acirc;y</a></strong></p>\n" +
                "<div class=\"\\&quot;flex\">\n" +
                "<div class=\"\\&quot;min-h-[20px]\" dir=\"\\&quot;auto\\&quot;\" data-message-author-role=\"\\&quot;assistant\\&quot;\" data-message-id=\"\\&quot;4289b4b5-78ab-4c76-b48b-dbf63a220f09\\&quot;\">\n" +
                "<div class=\"\\&quot;flex\">\n" +
                "<div class=\"\\&quot;markdown\">\n" +
                "<p>Nếu c&oacute; bất kỳ vấn đề g&igrave; trong qu&aacute; tr&igrave;nh nhận m&atilde; k&iacute;ch hoạt, qu&yacute; kh&aacute;ch vui l&ograve;ng li&ecirc;n hệ với bộ phận hỗ trợ kh&aacute;ch h&agrave;ng của ch&uacute;ng t&ocirc;i để được trợ gi&uacute;p kịp thời.</p>\n" +
                "<br />\n" +
                "<p>Xin ch&acirc;n th&agrave;nh cảm ơn sự tin tưởng của qu&yacute; kh&aacute;ch!</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div> </body> </html>";
        emailService.sendMessage("kienhien200418@gmail.com",email,subject,text);
    }
}
