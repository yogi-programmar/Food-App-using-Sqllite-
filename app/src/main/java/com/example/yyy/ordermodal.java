package com.example.yyy;

public class ordermodal {

    int id ;
    int orderimage;
    String soliditems,priceorder,ordeernumber;
    public ordermodal(){}

    public int getOrderimage() {
        return orderimage;
    }

    public void setOrderimage(int orderimage) {
        this.orderimage = orderimage;
    }

    public String getSoliditems() {
        return soliditems;
    }

    public void setSoliditems(String soliditems) {
        this.soliditems = soliditems;
    }

    public String getPriceorder() {
        return priceorder;
    }

    public void setPriceorder(String priceorder) {
        this.priceorder = priceorder;
    }

    public String getOrdeernumber() {
        return ordeernumber;
    }

    public void setOrdeernumber(String ordeernumber) {
        this.ordeernumber = ordeernumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ordermodal(int orderimage, String soliditems, String priceorder, String ordeernumber, int id) {
        this.orderimage = orderimage;
        this.soliditems = soliditems;
        this.priceorder = priceorder;
        this.ordeernumber = ordeernumber;
        this.id=id;
    }


}
