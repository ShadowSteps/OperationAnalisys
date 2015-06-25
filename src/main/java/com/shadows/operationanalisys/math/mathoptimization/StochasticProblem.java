/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.operationanalisys.math.mathoptimization;

import com.shadows.operationanalisys.math.function.MathFunctionWithRandomValues;
import com.shadows.operationanalisys.math.statistics.StatisticsDistribution;

/**
 *
 * @author John
 */
public class StochasticProblem  extends OperationAnalisysMinimumProblem{
    public StochasticProblem(MathFunctionWithRandomValues ProblemFunction,double Step) {
        super(ProblemFunction,Step);
    }

   

    @Override
    protected Object AfterAlgorithFinish(double[] PastPoint, double[] Point) {
        return null;
    }

    @Override
    protected Object BeforeAlgorithPreparation(double[] Point) {
        ((MathFunctionWithRandomValues)Function).GenRandomValues();
        return null;
    }
    
}
