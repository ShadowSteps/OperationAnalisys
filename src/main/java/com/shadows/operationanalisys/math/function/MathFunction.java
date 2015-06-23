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
    public final double[] StartArguments;
    public MathFunction(double[] StartArgs){
        this.StartArguments = StartArgs;
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
        double GradParametersPowSum = 0;
        for (int i = 0;i<Grad.length;i++){
            GradParametersPowSum += Math.pow(Grad[i],2);
        }
        double GradNorm = Math.sqrt(GradParametersPowSum);
        return GradNorm;
    }
    
}
