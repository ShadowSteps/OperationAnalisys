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
public class MinimumProblemSolveResult {
    public final double[] Point;
    public final int Iterations;
    public final double[] Gradient;
    public final double Minimun;
    public MinimumProblemSolveResult(double[] PointOfSolve,int NumberOfIterations,MathFunction Function){
        this.Point = PointOfSolve;
        this.Iterations = NumberOfIterations;
        this.Gradient = Function.Gradient(Point);
        this.Minimun = Function.Result(Point);
    }
    public void DisplayToConsole(){
        System.out.println("Number of iterations: "+this.Iterations);
        String PointStr = "";
        String GradFuncStr = "Grad(";
        String GradResultStr = "";
        for (int i=0;i<Point.length;i++){
            PointStr+= "x"+i+" = "+Point[i]+"; ";
            GradFuncStr+="x"+i+",";
            GradResultStr+=" "+Gradient[i]+" ,";
        }
        int Length = GradFuncStr.length();
        GradFuncStr = GradFuncStr.substring(0,Length-1);
        int EndLength = GradResultStr.length();
        GradResultStr = GradResultStr.substring(0,EndLength-1);
        GradFuncStr+=")";
        String GradStr = GradFuncStr+" = "+GradResultStr;
        System.out.println(PointStr);
        System.out.println(GradStr);
        System.out.println("F minimum = "+Minimun);
    }
}
