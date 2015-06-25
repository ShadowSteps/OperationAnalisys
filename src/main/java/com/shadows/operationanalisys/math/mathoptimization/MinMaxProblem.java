/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.operationanalisys.math.mathoptimization;

import com.shadows.operationanalisys.math.function.MathFunction;

/**
 *
 * @author John
 */
public class MinMaxProblem extends OperationAnalisysMinimumProblem{
    protected MathFunction SecondFunction;
    public MinMaxProblem(MathFunction ProblemFunction,MathFunction SecondProblemFunction,double Step) {
        super(ProblemFunction,Step);
        this.SecondFunction = SecondProblemFunction;
    }
   
    @Override
    protected Object AfterAlgorithFinish(double[] PastPoint, double[] Point) {
        return null;
    }

    @Override
    protected Object BeforeAlgorithPreparation(double[] Point) {
        if (Function.Result(Point) < SecondFunction.Result(Point)){
            MathFunction Func = Function;
            Function = SecondFunction;
            SecondFunction = Func;
        }
        return null;
    }
    
}
