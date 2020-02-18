package by.it.potapovich.jd02_02;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Buyer extends Thread implements Runnable, IBuyer, IUseBacket {
    private int num;
    private String name;
    private Backet backet;
    private Good good;
    private Map<Good, Integer> goods;
    private Set<Good> backets;



    Buyer(int num, Map<Good, Integer> goods, Backet backet) throws InterruptedException {
        this.num = num;
        this.setName("Покупатель № " + num + " ");
        Dispatcher.buyerEnter();
        this.goods = goods;
        this.backet = backet;
        start();
    }

    public Map<Good, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<Good, Integer> goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goOut();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "вошел в магазин");

    }

    @Override
    public void takeBacket() {
        //  if (name != null) {
        backet = new Backet();
       chooseGoods();


        System.out.println(this + "взял корзину");


        //    }
    }

    @Override
    public void chooseGoods() {
        try {
            int pause = Helper.random(500, 2000);
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            System.err.println(this + "выбрал товар");
        }

    }

    @Override
    public void goToQueue() {
        System.out.println(this + " пошел в очередь");
        QueueBuyer.add(this);
        synchronized (this){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }


    @Override
    public void putGoodsToBacket() {
        // if (goods != null){
        int count = (int) (Math.random() * 4) + 1;
        for (int i = 0; i <= count; i++) {
            int index = (int) (Math.random() * 9);
            // Random random = new Random();
           Good [] goodsArray = goods.keySet().toArray(new Good[0]);

           good = goodsArray[index];
           if (backets == null){
               backets = new HashSet<>();
           }
            if (good != null){
                backets.add(good);
                chooseGoods();
                System.out.println("Покупатель № " + this + "положил " + backets + "в корзину");
            }

        }


            }




        // backet.setBackets();

        // goods = new LinkedHashMap<>();
        //System.out.println(this + "положил товар в корзину");


        //  }


     @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");

    }
}
