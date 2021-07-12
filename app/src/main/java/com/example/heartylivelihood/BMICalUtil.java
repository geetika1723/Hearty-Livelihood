package com.example.heartylivelihood;

public class BMICalUtil {
    public static final BMICalUtil instance =new BMICalUtil();
    public static BMICalUtil getInstance()
    {
        return instance;
    }
    public double calculateBMIMetric(double heightcm,double weightkg)
    {
        return (weightkg/((heightcm/100)*(heightcm/100)));
    }
    public double calculateBMIImperial(double heightFeet,double heightInches,double weightlbs)
    {
        double totalheightInches=(12*heightFeet)+heightInches;
        return ((703*weightlbs)/(totalheightInches*totalheightInches));
    }
    public String classifyBMI(double bmi)
    {
        if(bmi<18.5)
            return "Underweight";
        else if (bmi >= 18.5 && bmi < 25)
            return  "Healthy Weight Range";
        else if (bmi >= 25 && bmi < 30)
            return "OverWeight";
        else
            return "Obese";
    }
}
