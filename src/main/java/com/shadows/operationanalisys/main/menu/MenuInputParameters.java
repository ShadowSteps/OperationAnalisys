/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.operationanalisys.main.menu;

import com.shadows.operationanalisys.math.function.FunctionParameterBoundarys;
import com.shadows.operationanalisys.math.statistics.NormalDistribution;
import com.shadows.operationanalisys.math.statistics.StatisticsDistribution;
import com.shadows.operationanalisys.math.statistics.UniformDestribution;
import java.util.Scanner;

/**
 *
 * @author John
 */
public class MenuInputParameters {
    private double[] InitialValues;

    public double[] getInitialValues() {
        return InitialValues;
    }

    public double getStep() {
        return Step;
    }

    public double getMinimumFunctionDifference() {
        return MinimumFunctionDifference;
    }

    public double getMinimumArgumentDifference() {
        return MinimumArgumentDifference;
    }

    public double getMinimumGradientNorm() {
        return MinimumGradientNorm;
    }
    private double Step;
    private double MinimumFunctionDifference;
    private double MinimumArgumentDifference;
    private double MinimumGradientNorm;    
    private FunctionParameterBoundarys[] Boudnarys;
    private StatisticsDistribution Distrib;

    public StatisticsDistribution getDistrib() {
        return Distrib;
    }
    public void ReadInitialValues(int ValuesNum){
        this.InitialValues = new double[ValuesNum];
        Scanner Scan = new Scanner(System.in);
        for (int i = 0;i<ValuesNum;i++){
            System.out.print("Enter initial value for x"+i+": ");
            InitialValues[i] = Scan.nextDouble();
        }
    }
    public void ReadBoundarysValues(int ValuesNum){
        this.Boudnarys = new FunctionParameterBoundarys[ValuesNum];
        Scanner Scan = new Scanner(System.in);
        for (int i = 0;i<ValuesNum;i++){
            System.out.print("Enter min value for x"+i+": ");
            double Min = Scan.nextDouble();
            System.out.print("Enter max value for x"+i+": ");
            double Max = Scan.nextDouble();
            Boudnarys[i] = new FunctionParameterBoundarys(Min, Max);
        }
    }

    public FunctionParameterBoundarys[] getBoudnarys() {
        return Boudnarys;
    }
    public void ReadStep(){
        Scanner Scan = new Scanner(System.in);
        System.out.print("Enter value for step: ");
        Step = Scan.nextDouble();
    }
    public void ReadMinimumFunctionDifference(){
        Scanner Scan = new Scanner(System.in);
        System.out.print("Enter value for minimum function difference: ");
        MinimumFunctionDifference = Scan.nextDouble();
    }
    public void ReadMinimumArgumentDifference(){
        Scanner Scan = new Scanner(System.in);
        System.out.print("Enter value for minimum argument difference: ");
        MinimumArgumentDifference = Scan.nextDouble();
    }
    public void ReadMinimumGradientNorm(){
        Scanner Scan = new Scanner(System.in);
        System.out.print("Enter value for minimim gradient norm: ");
        MinimumGradientNorm = Scan.nextDouble();
        System.out.println();
    }
     public void ReadDistrivution(){
        Scanner Scan = new Scanner(System.in);
        System.out.println("Select type of distribution.");
        System.out.println("1 - Uniform.");
        System.out.println("2 - Normal.");
        int Type  = Scan.nextInt();        
        System.out.print("Enter first parameter of destribution: ");
        double First = Scan.nextDouble();
        System.out.print("Enter second parameter of destribution: ");
        double Second = Scan.nextDouble();
        switch (Type){
            case 1:
                Distrib = new UniformDestribution(First,Second);
                break;
            case 2:
                Distrib = new NormalDistribution(First, Second);
                break;
        }
        System.out.println();
    }
    public void ReadGradient(int ValuesNum){
        this.ReadInitialValues(ValuesNum);
        this.ReadStep();
        this.ReadMinimumArgumentDifference();
        this.ReadMinimumFunctionDifference();
        this.ReadMinimumGradientNorm();        
    }
    public void ReadProjection(int ValuesNum){
        this.ReadInitialValues(ValuesNum);
        this.ReadStep();
        this.ReadMinimumArgumentDifference();
        this.ReadMinimumFunctionDifference();
        this.ReadMinimumGradientNorm(); 
        this.ReadBoundarysValues(ValuesNum);
    }
    public void ReadStochastic(int ValuesNum){
        this.ReadInitialValues(ValuesNum);
        this.ReadStep();
        this.ReadMinimumArgumentDifference();
        this.ReadMinimumFunctionDifference();
        this.ReadMinimumGradientNorm(); 
        this.ReadDistrivution();
    }
}
