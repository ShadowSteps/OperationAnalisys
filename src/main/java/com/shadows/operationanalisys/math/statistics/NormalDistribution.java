/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.operationanalisys.math.statistics;

import java.util.Random;

/**
 *
 * @author John
 */
public class NormalDistribution extends StatisticsDistribution{

    public NormalDistribution(double Min, double Max) {
        super(Min, Max);
    }

    @Override
    public double GetRandomNumber() {
        Random RandomGen = new Random();
        double Num = RandomGen.nextGaussian();              
        return Num;
    }
    
}
