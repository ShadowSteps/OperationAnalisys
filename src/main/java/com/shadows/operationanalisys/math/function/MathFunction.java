/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.operationanalisys.math.function;

/**
 *
 * @author John
 */
abstract public class MathFunction {   
    private final double[] StartArguments;
    private final FunctionParameterBoundarys[] Boundarys;
    public double[] GetStartArguments(){
        return StartArguments.clone();
    }
    public MathFunction(double[] StartArgs){
        this.StartArguments = StartArgs;
        this.Boundarys = new FunctionParameterBoundarys[StartArgs.length];
    }
    public MathFunction SetBoundaryForParameter(int ParameterIndex,double Min,double Max){
        this.Boundarys[ParameterIndex] = new FunctionParameterBoundarys(Min, Max);
        return this;
    }
    public double[] PointInFunctionOrBoundary(double[] Point){
        for (int j=0;j<Point.length;j++){
            Point[j] = this.ParameterInFunctionOrBoundary(j, Point[j]);
        }
        return Point;
    }
    public double ParameterInFunctionOrBoundary(int Parameter,double Point) throws ArrayIndexOutOfBoundsException{
        if (this.Boundarys[Parameter] == null||!(this.Boundarys[Parameter] instanceof FunctionParameterBoundarys)){
            throw new ArrayIndexOutOfBoundsException("Boundarys for argument "+Parameter+" not set or is invalid!");
        }
        FunctionParameterBoundarys Boundary = this.Boundarys[Parameter];
        if (Point >= Boundary.Maximum)
        {
            Point = Boundary.Maximum;
        } else if (Point <= Boundary.Minimum)
        {
            Point = Boundary.Minimum;
        }            
        return Point;
    }
    public double ResultAtStartArgs(){
        return Result(StartArguments);
    }
    public double[] GradientAtStartArgs(){
        return Gradient(StartArguments);
    }
    public double Result(){
        return ResultAtStartArgs();
    }
    public double[] Gradient(){
        return GradientAtStartArgs();
    }
    public abstract double Result(double[] parameters);    
    public abstract double[] Gradient(double[] parameters); 
    public double GadientNorm(){                
        return GadientNorm(StartArguments);
    }
    public double GadientNorm(double[] parameters){        
        double[] Grad = Gradient(parameters);
        double GradParametersPowSum = 0.0;
        for (int i = 0;i<Grad.length;i++){
            GradParametersPowSum += Math.pow(Grad[i],2);
        }
        double GradNorm = Math.sqrt(GradParametersPowSum);
        return GradNorm;
    }
    
}
