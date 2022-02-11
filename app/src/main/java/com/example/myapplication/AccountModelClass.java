package com.example.myapplication;

public class AccountModelClass {

    private int image;
    private String text;

    //public String[] arr;

    public AccountModelClass(String text , int image) {
        this.text = text;
        this.image=image;
        //arr = new String[]{"A", "B"};
    }


    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String  getText() {
        return text ;
    }
}







