import com.chillrain.model.Electrocity;
import com.chillrain.model.Foods;
import com.chillrain.model.Groceries;
import com.chillrain.model.Item;

import java.io.*;
import java.util.Scanner;

/**
 * @author ChillRain
 */
public class Main {
    /**
     * 主方法 系统从此开始运行
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /** 序列化文件 */
        File seriaFile = new File("goodsID.mp4");
        /** 商品数组 */
        Item[] array = null;
        /** 数组下标 */
        int arrIndex = 0;
        //region 判断序列化文件serizFile是否存在并读取
        if (seriaFile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(seriaFile)))) {
                Object o = ois.readObject();
                if (o instanceof Item[]) {
                    array = (Item[]) o;
                }
                arrIndex = ois.readInt();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            array = new Item[200];
        }
        //endregion
        Item newGoods;
        a:
        while(true){
            System.out.println("===================================================================================");
            System.out.println("                           欢迎使用233商品管理系统");
            System.out.println("===================================================================================");
            System.out.println("[1.添加新商品 2.展示已有信息 3.删除商品信息 5.退出]");
            System.out.println("请输入-->");
            /** 截取用户输入 */
            int inputNum = sc.nextInt();
            switch(inputNum){
                case 1:
                    System.out.println("请选择要添加的商品类别[1.食品 2.生活用品 3.电器]：");
                    int inputNum2 = sc.nextInt();
                    newGoods = null;
                    switch(inputNum2){
                        case 1:
                            newGoods = new Foods(sc);
                            break;
                        case 2:
                            newGoods = new Groceries(sc);
                            break;
                        case 3:
                            newGoods = new Electrocity(sc);
                            break;
                    }
                    array[arrIndex] = newGoods;
                    arrIndex ++;
                    System.out.println("商品已写入！");
                    break;
                case 2:
                    for (int i = 0; i < arrIndex; i++) {
                        Item cache = array[i];
                        String info = cache.getInfo(i);
                        System.out.println(info);
                    }
                    break;
                case 3:
                    System.out.println("输入删除的商品序号：");
                    int del = sc.nextInt();
                    for(int i = del - 1; i < arrIndex; i++){
                        array[i] = array[i + 1];
                    }
                    arrIndex --;
                    System.out.println("删除成功!");
                    break;
                case 5:
                    try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(seriaFile)))){
                        oos.writeObject(array);
                        oos.writeInt(arrIndex);
                        oos.flush();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("感谢使用");
                    break a;
                default:
                    System.out.println("输入字符不合法！");
                    break;
            }
        }
    }
}
