package com.sjy.it.authority.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

public class VerifyCodeUtil {
    public static int ctrat(OutputStream out){
        int s=0;
        try {
            BufferedImage img = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = img.createGraphics();
            g.setColor(Color.getColor("4b6a8f"));
            g.fillRect(0,0,200,100);

            g.setColor(Color.BLACK);
            g.setFont(new Font("宋体",Font.PLAIN,34));

            s = new Random().nextInt(9000)+1000;

            g.drawString(s+"",50,80);

            ImageIO.write(img,"png",out);
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }
}
