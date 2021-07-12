package com.example.heartylivelihood;

public class DetailLose {
    public String title,calorie,right_time,worst_time,best_consume,fat,sodium,carbo,fiber,sugar,protien,benifits;
    public DetailLose(){

    }
    public DetailLose(String title,String calorie,String right_time,String worst_time,String best_consume,String fat,String sodium,String carbo, String fiber,String sugar, String protien, String benifits)
    {
        this.title=title;
        this.calorie=calorie;
        this.right_time=right_time;
        this.worst_time=worst_time;
        this.best_consume=best_consume;
        this.fat=fat;
        this.sodium=sodium;
        this.carbo=carbo;
        this.fiber=fiber;
        this.sugar=sugar;
        this.protien=protien;
        this.benifits=benifits;
    }
    public  String getTitle(){return title;}
    public String getCalorie(){return calorie;}
    public String getRight_time(){return right_time;}
    public String getWorst_time(){return worst_time;}
    public String getBest_consume(){return best_consume;}
    public String getFat(){return fat;}
    public String getSodium(){return sodium;}
    public String getCarbo(){return carbo;}
    public String getFiber(){return fiber;}
    public String getSugar(){return  sugar;}
    public String getProtien(){return protien;}
    public String getBenifits(){return benifits;}
}
