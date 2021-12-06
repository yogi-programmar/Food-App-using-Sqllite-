package com.example.yyy;

public class Food {

        int image;
        String Foodname,price, Number;

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getFoodname() {
            return Foodname;
        }

        public void setFoodname(String foodname) {
            Foodname = foodname;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getNumber() {
            return Number;
        }

        public void setNumber(String number) {
            this.Number = number;
        }

        public Food(int image, String Foodname, String price, String orderNumber) {
            this.image = image;
           this.Foodname = Foodname;
            this.price = price;
            this.Number = orderNumber;
        }



}
