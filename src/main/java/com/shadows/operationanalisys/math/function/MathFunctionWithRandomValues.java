/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.operationanalisys.math.function;

import com.shadows.operationanalisys.math.statistics.StatisticsDistribution;

/**
 *
 * @author John
 */
public abstract class MathFunctionWithRandomValues extends MathFunction{

    protected final StatisticsDistribution Destributin;
    private double[] RandomVals;
    public MathFunctionWithRandomValues(double[] StartArgs,StatisticsDistribution Destrib) {
        super(StartArgs);
        this.Destributin = Destrib;
        RandomVals = new double[StartArgs.length];       
        this.GenRandomValues();
    }
    public abstract double Result(double[] parameters,double[] RandomValues);
    public abstract double[] Gradient(double[] parameters,double[] RandomValues);
    public final void GenRandomValues(){
        for (int i = 0;i<RandomVals.length;i++){
            RandomVals[i] = Destributin.GetRandomNumberInBoundarys();
        }
    }
    @Override
    public double Result(double[] parameters) {
       return this.Result(parameters, RandomVals);
    }

    @Override
    public double[] Gradient(double[] parameters) {
        return Gradient(parameters, RandomVals);
    }
    
}
