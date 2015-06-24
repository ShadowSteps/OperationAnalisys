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
    public MinMaxProblem(MathFunction ProblemFunction,MathFunction SecondProblemFunction) {
        super(ProblemFunction);
        this.SecondFunction = SecondProblemFunction;
    }
    @Override
    protected MinimumProblemSolveResult Solve() {
        double[] point = Function.GetStartArguments();               
        for (int i = 0;i<this.MaxIterations;i++){    
            MathFunction Func = Function;
            if (Function.Result(point) < SecondFunction.Result(point)){
                Func = SecondFunction;
            }
            double Rho = this.Step / (i+1);    
            double[] Grad = Func.Gradient(point);
            double Norm = Func.GadientNorm(point);
            if (Norm < espG){
                break;
            }
            double Gama = 1/Norm;
            for (int j=0;j<point.length;j++){
                point[j] -= Rho*Grad[j]*Gama;  
            }        
        }
        return new MinimumProblemSolveResult(point, MaxIterations, Function);
    }
    
}
