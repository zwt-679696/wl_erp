package com.weiling.wl_erp.util;

import com.itextpdf.text.pdf.BaseFont;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
@Controller
public class FileTypeConvertUtil {
    /**
     * 文件格式转换工具类
     *
     * 作者: 左文统
     * 日期:2019/6/20
     *
     *
     */
        /**
         * 将HTML转成PD格式的文件。html文件的格式比较严格
         * @param htmlFile
         * @param pdfFile
         * @throws Exception
         */
        public static void html2pdf(String htmlFile, String pdfFile) throws Exception {
            // step 1
            String url = new File(htmlFile).toString();
            System.out.println(url);
            // step 2
            OutputStream os = new FileOutputStream(pdfFile);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(url);

            // step 3 解决中文支持
            ITextFontResolver fontResolver = renderer.getFontResolver();
            if("linux".equals(getCurrentOperatingSystem())){
                fontResolver.addFont("/usr/share/fonts/chiness/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            }else{
                fontResolver.addFont("c:/Windows/Fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            }

            renderer.layout();
            renderer.createPDF(os);
            os.close();

            System.out.println("create pdf done!!");

        }

        public static String getCurrentOperatingSystem(){
            String os = System.getProperty("os.name").toLowerCase();
            System.out.println("---------当前操作系统是-----------" + os);
            return os;
        }

    @RequestMapping("qqqq")
    public static void qqqq(HttpServletRequest request) {
            //        String htmlFile = "/home/lbj/sign.jsp";
            //        String pdfFile = "/home/lbj/sign.pdf";
            String htmlFile = "tuhuoList.html";
            File ff = new File(htmlFile);
            System.out.println(ff.exists() +","+ff.isDirectory());
            String pdfFile = "d:/tuhuo.pdf";
            try {
                FileTypeConvertUtil.html2pdf(htmlFile, pdfFile);
                PrintUtils.print2(pdfFile,"192.168.1.6");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


