package com.wjz.servlet;


import com.wjz.util.EncodingUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * Created by wujiazhi on 15/9/5.
 */
public class EncodingAction extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        OutputStream out = null;
        try {
            /**
             * decode
             */
//            request.setCharacterEncoding("UTF-8");
            String a = request.getParameter("a");
            String a1 = new String(request.getParameter("a").getBytes("ISO-8859-1"), "UTF-8");
            System.out.println("a:" + a);
            System.out.println("a1:" + a1);
            System.out.println("a bytes:" + EncodingUtil.bytes2HexString(a.getBytes("UTF-8")));
            System.out.println("a1 bytes:" + EncodingUtil.bytes2HexString(a1.getBytes("UTF-8")));


            //这个只是告诉web容器以什么样的编码输出结果，但是并没有指明contentType的字符集，所以浏览器也就用自己的编码进行
//            response.setCharacterEncoding("GBK");
            //告诉web容器以什么样的编码输出结果，同时也指明浏览器根据contentType的字符集解析
//            response.setContentType("text/html; charset=GBK");
//            out = response.getOutputStream();
            String body = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
            "<html>\n" +
            "<head>\n" +
            "    <!-- 2、 这是HTML中的meta数据，指示浏览器使用contentType的格式和编码解析返回的html；\n" +
            "    相比服务器设定的contentType，这个指示优先级最低；\n" +
            "    如果即没有设定contentType，也没有设定pageEncoding，浏览器才会用这个编码来解析html文件\n" +
            "    Jetty中这句话没用起作用，Tomcat中起作用吗？-->\n" +
            "    <meta Http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
            "    <title> JSP编程测试</title >\n" +
            "    " +
            "\n" +
            "\n" +
            "</head>\n" +
            "<body>\n" +
            "JSP编程测试\n" +
            "</body>\n" +
            "</html>";
            /**字节输出编码***/
//            out.write(body.getBytes("UTF-8"));
//            System.out.println("Coming......" + System.getProperty("file.encoding"));

           request.getRequestDispatcher("/WEB-INF/encoding.jsp").forward(request, response);

            //此时上述JSP已经给Client写回了ouputStream，所以再对response设置就没用了
//            response.setContentType("text/html; charset=GBK");

        } catch (Exception e) {
            System.out.println("<OUTPUT_STREAM ERROR> " + e);
        }finally {
            try {
                out.close();
            } catch(Exception e) {
                out = null;
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        this.doGet(request, response);
    }

}
