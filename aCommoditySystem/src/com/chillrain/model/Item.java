package com.chillrain.model;

import java.io.Serializable;
import java.util.Scanner;

public class Item implements Serializable {
    private static final long serialVersionUID = -5584600115673938142L;
    /**
     * 商品名
     */
    private String name;
    /**
     * 库存
     */
    private String stock;
    /**
     * 价格
     */
    private double price;

    /**
     *
     * @param i 商品编号
     * @return 商品信息
     */
    public String getInfo(int i){
        String info = (i + 1)
                + "\t商品名：" + this.name
                + "\t价格：" + this.price
                + "\t库存：" + this.stock;
        return info;
    }

    /**
     *  初始化商品信息
     * @param sc 输入信息
     */
    public Item(Scanner sc){
        System.out.print("输入商品名:");
        this.name = sc.next();
        System.out.print("输入价格:");
        this.price = sc.nextDouble();
        System.out.print("输入库存：");
        this.stock = sc.next();
    }
}
