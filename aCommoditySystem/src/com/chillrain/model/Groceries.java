package com.chillrain.model;

import java.util.Scanner;

/**
 * @author ChillRain
 * 20211027
 */
public class Groceries extends Item{
    public Groceries(Scanner sc){
        super(sc);
        System.out.print("输入重量：");
        this.weight = sc.next();
    }
    /** 重量 */
    private String weight;

    @Override
    public String getInfo(int i) {
        String info = super.getInfo(i);
        info += '\t' + "重量" + this.weight;
        return info;
    }
}
