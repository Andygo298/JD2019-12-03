package by.it.kuzmichalex.jd2_01;

interface iBuyer {
    void enterToMarket();    //вошел в магазин (мгновенно)
    void chooseGoods();      //выбрал товар (от 0,5 до 2 секунд)
    void goOut();            //отправился на выход(мгновенно)
}
