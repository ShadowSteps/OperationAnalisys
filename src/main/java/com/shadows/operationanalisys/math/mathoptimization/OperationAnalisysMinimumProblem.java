/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.operationanalisys.math.mathoptimization;

import com.shadows.operationanalisys.math.function.FunctionParameterBoundarys;
import com.shadows.operationanalisys.math.function.MathFunction;

/**
 *
 * @author John
 */
public abstract class OperationAnalisysMinimumProblem {
    protected MathFunction Function;
    protected int MaxIterations = 100000;
    protected double Step = 0.03;
    protected double MinimumGradientNorm = 0.000000001;
    protected double MinimumFunctionDifference = 0.000000001;
    protected double MinimumArgumentDifference = 0.000000001;
    public void SolveAndDisplayToConsole(){
        MinimumProblemSolveResult Result = Solve();
        DisplayToConsole(Result);
    } 
    private double CalculateVectorNorm(double[] Vector){
        double Norm = 0;
        for (int i =0;i< Vector.length;i++){
            Norm+=  Math.pow(Vector[i], 2);
        }
        Norm = Math.sqrt(Norm);
        return Norm;
    }
    private Boolean CheckCriteriasForBreak(double[] PastPoint,double[] Point,double GradientNorm){
        if (Math.abs(CalculateVectorNorm(PastPoint)-CalculateVectorNorm(Point))<MinimumArgumentDifference){
            return true;
        }
        if (Math.abs(Function.Result(PastPoint)-Function.Result(Point))<MinimumFunctionDifference){
            return true;
        }
        if (GradientNorm < MinimumGradientNorm){
            return true;
        }
        return false;
    }
    protected MinimumProblemSolveResult Solve(){
        int Iteration = 0;
        double[] point = Function.GetStartArguments();
        for (int i = 0;i<this.MaxIterations;i++){
            this.BeforeAlgorithPreparation(point);
            double Rho = this.Step / (i+1);    
            double[] Grad = Function.Gradient(point);
            double Norm = Function.GadientNorm(point);            
            double[] PastPoint = point.clone();
            for (int j=0;j<point.length;j++){
                point[j] -= Rho*Grad[j]*Norm;
            }
            this.AfterAlgorithFinish(PastPoint,point);
            Iteration = i;
            if (CheckCriteriasForBreak(PastPoint, point, Norm)){
                break;
            }
        }
        return new MinimumProblemSolveResult(point, Iteration+1, Function);
    }  

    protected void DisplayToConsole(MinimumProblemSolveResult Result){
        Result.DisplayToConsole();
    }
    
    public OperationAnalisysMinimumProblem(MathFunction ProblemFunction,double Step){
        this.Function = ProblemFunction;
        this.Step = Step;
    }

    abstract protected Object AfterAlgorithFinish(double[] PastPoint,double[] Point);
    abstract protected Object BeforeAlgorithPreparation(double[] Point);
}
