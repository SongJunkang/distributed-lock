package com.atguigu.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author joakims
 * @create 2022-10-11-20:21
 **/
public class GPDispatcherServlet  extends HttpServlet {

    private Map<String,Object> ioc  = new HashMap<>();

    private Properties contextConfig = new Properties();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doDispatcher();
    }



    @Override
    public void init(ServletConfig config) throws ServletException {
       //1、加载配置文件
        try {
            doLoadConfig("contextConfigLocation");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        doScanner();
        
        doInstance();
        
        doAutoWired();

        doInitHandlerMapping();
        
    }

    private void doInitHandlerMapping() {
    }

    private void doAutoWired() {
    }

    private void doInstance() {
//        if (ClassNames.isEmpty()){return;}
    }

    private void doScanner() {

        URL url =  this.getClass().getClassLoader().getResource("/" );

        File classPath = new File(url.getFile());

        for (File file:classPath.listFiles()){

        }

    }

    private void doLoadConfig(String contextConfigLocation) throws IOException {

        InputStream is = null;
        is = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        contextConfig.load(is);
    }

    private void doDispatcher() {
    }
}
