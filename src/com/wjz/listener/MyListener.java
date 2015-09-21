package com.wjz.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

/**
 * Created by wujiazhi on 15/9/16.
 */
public class MyListener extends HttpServlet implements ServletContextListener {
//    private static final Log logger = LogFactory.getLog(SysListener.class);
    public void contextDestroyed(ServletContextEvent sce) {
        //用于在容器关闭时,操作
    }

    //用于在容器开启时,操作
    public void contextInitialized(ServletContextEvent sce) {
        String rootpath = sce.getServletContext().getRealPath("/");
        System.out.println("-------------rootPath:"+rootpath);
        if (rootpath != null) {
            rootpath = rootpath.replaceAll("\\\\", "/");
        } else {
            rootpath = "/";
        }
        if (!rootpath.endsWith("/")) {
            rootpath = rootpath + "/";
        }
//        Constant.ROOTPATH = rootpath;
//        logger.info("Application Run Path:" + rootpath);
        String urlrewrtie = sce.getServletContext().getInitParameter("urlrewrite");
        boolean burlrewrtie = false;
        if (urlrewrtie != null) {
            burlrewrtie = Boolean.parseBoolean(urlrewrtie);
        }
//        Constant.USE_URL_REWRITE = burlrewrtie;
//        logger.info("Use Urlrewrite:" + burlrewrtie);
//        其它略之....
    }
}
