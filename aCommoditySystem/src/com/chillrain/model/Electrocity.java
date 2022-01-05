package com.chillrain.model;

import java.util.Scanner;

/**
 * @author ChillRain
 * 20211027
 */
public class Electrocity extends  Item{

    public Electrocity(Scanner sc){
        super(sc);
        System.out.print("输入功率：");
        this.power = sc.next();
        System.out.print("输入品牌：");
        this.brand = sc.next();
    }
    /** 功率 */
    private String power;
    /** 品牌 */
    private String brand;

    @Override
    public String getInfo(int i) {
        String info = super.getInfo(i);
        info += '\t' + "功率:" + this.power;
        info += '\t' + "品牌:" + this.brand;
        return info;

    }
}
