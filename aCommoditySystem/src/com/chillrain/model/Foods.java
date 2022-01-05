package com.chillrain.model;

import java.util.Scanner;

/**
 * @author ChillRain
 * 20211027
 */
public class Foods extends Item{
    public Foods(Scanner sc) {
        super(sc);
        System.out.print("输入生产日期：");
        this.prodectDate = sc.next();
        System.out.print("输入保质期：");
        this.effetiveDate = sc.next();
    }

    /** 生产日期 */
    private String prodectDate;
    /** 保质期 */
    private String effetiveDate;

    @Override
    public String getInfo(int i) {
        String info = super.getInfo(i);
        info += '\t' + "生产日期:" + this.prodectDate;
        info += '\t' + "保质期:" + this.effetiveDate;
        return info;
    }
}
