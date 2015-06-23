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
public class MiniminizationProblem extends OperationAnalisysMinimumProblem{

    public MiniminizationProblem(MathFunction ProblemFunction) {
        super(ProblemFunction);
    }

    @Override
    protected MinimumProblemSolveResult Solve() {
        double[] point = Function.StartArguments;
        for (int i = 0;i<this.MaxIterations;i++){
            double Rho = this.c / (i+1);    
            double[] Grad = Function.Gradient(point);
            double Norm = Function.GadientNorm(point);
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
