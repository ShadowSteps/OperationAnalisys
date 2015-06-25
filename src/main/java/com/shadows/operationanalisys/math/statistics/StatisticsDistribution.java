/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.operationanalisys.math.statistics;

/**
 *
 * @author John
 */
public abstract class StatisticsDistribution {
    abstract public double GetRandomNumber();
    protected double MinValue,MaxValue;
    public StatisticsDistribution(double Min,double Max){
        this.MinValue = Min;
        this.MaxValue = Max;
    }
    protected double ResizeAndMoveNumberInBoundarys(double Num,double Min,double Max){
        double IntervalLength = Math.abs(Max - Min);
        if (IntervalLength > 1){
            Num*= IntervalLength;
        }
        if (Min != 0){
            Num += Min;
        }
        return Num;
    }
    public double GetRandomNumberInBoundarys(){
        double Num = GetRandomNumber();
        return ResizeAndMoveNumberInBoundarys(Num, MinValue, MaxValue);
    }
}
