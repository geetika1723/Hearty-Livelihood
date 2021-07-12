package com.example.heartylivelihood;

public class DetailHeatlhyRecipe {
    String title,time,difficulty,about,integredients,baking;

    public DetailHeatlhyRecipe(){

    }
    public DetailHeatlhyRecipe(String title,String time,String difficulty,String about,String integredients,String baking)
    {
        this.title=title;
        this.time=time;
        this.difficulty=difficulty;
        this.about=about;
        this.integredients=integredients;
        this.baking=baking;
    }
    public String getTitle(){return title;}
    public String getTime(){return time;}
    public String getDifficulty(){return difficulty;}
    public String getAbout(){return about;}
    public String getIntegredients(){return integredients;}
    public String getBaking(){return baking;}
}
