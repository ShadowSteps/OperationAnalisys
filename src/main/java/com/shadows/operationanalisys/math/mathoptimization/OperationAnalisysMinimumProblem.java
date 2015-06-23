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
public abstract class OperationAnalisysMinimumProblem {
    protected MathFunction Function;
    protected int MaxIterations = 20000;
    protected int c = 10;
    protected double espG = 0.001;
    protected double espj = 0.001;    
    public void SolveAndDisplayToConsole(){
        MinimumProblemSolveResult Result = Solve();
        DisplayToConsole(Result);
    } 

    protected abstract MinimumProblemSolveResult Solve();    

    protected void DisplayToConsole(MinimumProblemSolveResult Result){
        Result.DisplayToConsole();
    }
    
    public OperationAnalisysMinimumProblem(MathFunction ProblemFunction){
        this.Function = ProblemFunction;
    }
}
