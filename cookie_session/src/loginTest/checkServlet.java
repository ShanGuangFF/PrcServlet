package loginTest;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkServlet")
public class checkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1.创建一对象，在内存中图片（验证码图片对象）

        int width = 100;
        int hight = 50;
        BufferedImage imge = new BufferedImage(width,hight,BufferedImage.TYPE_3BYTE_BGR);

        //2.美化图片
        //2.1填充背景色
        Graphics g = imge.getGraphics();//画笔对象
        g.setColor(Color.PINK);
        g.fillRect(0,0,width,hight);


        //2.2画边框
        g.setColor(Color.black);
        g.drawRect(0,0,width-1,hight-1);


        //2.3写验证码
        String str = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm123456789";
        Random random = new Random();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            stringBuilder.append(str.charAt(index));
            g.drawString(str.charAt(index)+"",i*20,25);
        }

        String checkCode = stringBuilder.toString();
        request.getSession().setAttribute("checkCode_session",checkCode);

        //2.4画干扰线
        g.setColor(Color.green);
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(hight);
            int y2 = random.nextInt(hight);
            g.drawLine(x1,y1,x2,y2);
        }

        //3.将图片输出到页面
        ImageIO.write(imge,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
