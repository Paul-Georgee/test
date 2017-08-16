package com.project.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class makeCertPic {
	//验证码图片中可以出现的字符集,可根据需要修�?
    private char mapTable[]={
    'a','b','c','d','e','f',
    'g','h','i','j','k','l',
    'm','n','o','p','q','r',
    's','t','u','v','w','x',
    'y','z','0','1','2','3',
    '4','5','6','7','8','9'};
    /**
     * 功能:生成彩色验证码图�?
     * 参数width为生成的图片的宽�?,参数height为生成的图片的高�?,参数os为页面的输出�?
     */
    public String getCertPic(int width, int height, OutputStream os) {
		if(width<=0)width=60;
		if(height<=0)height=30;
		BufferedImage image = new BufferedImage(width, height,
		BufferedImage.TYPE_INT_RGB);
		// 获取图形上下�?
		Graphics g = image.getGraphics();
		// 设定背景�?
		g.setColor(new Color(0xDCDCDC));
		g.fillRect(0, 0, width, height);
		//画边�?
		g.setColor(Color.black);
		g.drawRect(0,0,width-1,height-1);
		// 取随机产生的认证�?
		String strEnsure = "";
		// 4代表4位验证码,如果要生成更多位的认证码,则加大数�?
		for(int i=0; i<4; ++i) {
		strEnsure += mapTable[(int)(mapTable.length*Math.random())];
		}
		// 将认证码显示到图象中,如果要生成更多位的认证码,增加drawString语句
		g.setColor(Color.black);
		g.setFont(new Font("Atlantic Inline",Font.PLAIN,18));
		String str = strEnsure.substring(0,1);
		g.drawString(str,8,17);
		str = strEnsure.substring(1,2);
		g.drawString(str,20,15);
		str = strEnsure.substring(2,3);
		g.drawString(str,35,18);
		str = strEnsure.substring(3,4);
		g.drawString(str,45,15);
		// 随机产生10个干扰点
		Random rand = new Random();
		for (int i=0;i<100;i++) {
		int x = rand.nextInt(width);
		int y = rand.nextInt(height);
		g.drawOval(x,y,1,1);
		}
		// 释放图形上下�?
		g.dispose();
		try {
		// 输出图象到页面
		ImageIO.write(image, "JPEG", os);
		os.flush(); 
		os.close(); 
		os=null;
		} catch (IOException e) {
		return "";
		}
		return strEnsure;
		}
	} 
