/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.operationanalisys.main.menu;

import com.shadows.operationanalisys.math.function.FunctionParameterBoundarys;
import com.shadows.operationanalisys.math.function.MathFunction;
import com.shadows.operationanalisys.math.function.MathFunctionWithRandomValues;
import com.shadows.operationanalisys.math.mathoptimization.MinMaxProblem;
import com.shadows.operationanalisys.math.mathoptimization.MiniminizationProblem;
import com.shadows.operationanalisys.math.mathoptimization.ProjectionProblem;
import com.shadows.operationanalisys.math.mathoptimization.StochasticProblem;
import com.shadows.operationanalisys.math.statistics.NormalDistribution;
import java.util.Scanner;

/**
 *
 * @author John
 */
public class ConsoleMenuReader {    
    public void ShowMenu(){
        Boolean Exit = false;
        while (!Exit){
            System.out.println("Select operation type from menu.");
            System.out.println("1 - Gradient descent for single function.");
            System.out.println("2 - Projected gradient descent.");
            System.out.println("3 - MinMax Gradient descent for two function.");
            System.out.println("4 - Stochastic gradient descent.");
            Scanner Scan = new Scanner(System.in);
            int MenuSelected = Scan.nextInt();
            switch (MenuSelected){
                case 1:
                    this.GradientAlgoritm();
                    break;
                case 2:
                    this.ProjectionAlgoritm();
                    break;
                case 3:
                    this.MinMaxAlgoritm();
                    break;
                case 4:
                    this.StochasticAlgoritm();
                    break;
            }
            System.out.print("Exit[y/n]: ");
            String ExitResponse = Scan.next();
            Exit = ExitResponse.equalsIgnoreCase("y");
        }
        
    }

    private void GradientAlgoritm() {
        MenuInputParameters Params = new MenuInputParameters();
        Params.ReadGradient(2);
        MathFunction Func = new MathFunction(new double[]{1,1}) {
            
            @Override
            public double Result(double[] parameters) {
                return Math.pow(parameters[0], 2)+Math.pow(parameters[1], 2);
            }
            
            @Override
            public double[] Gradient(double[] parameters) {
                return new double[]{2*(parameters[0]),2*(parameters[1])};
            }
        };
        MiniminizationProblem Solve = new MiniminizationProblem(Func,Params.getStep());
        Solve.SolveAndDisplayToConsole();
    }

    private void ProjectionAlgoritm() {
        MenuInputParameters Params = new MenuInputParameters();
        Params.ReadProjection(2);
         MathFunction Func = new MathFunction(Params.getInitialValues()) {
            
            @Override
            public double Result(double[] parameters) {
                return Math.pow(parameters[0], 2)+Math.pow(parameters[1], 2);
            }
            
            @Override
            public double[] Gradient(double[] parameters) {
                return new double[]{2*(parameters[0]),2*(parameters[1])};
            }
        };
        FunctionParameterBoundarys[] Boundarys = Params.getBoudnarys();
        for (int i = 0;i<2;i++){
            FunctionParameterBoundarys Boundary = Boundarys[i];
            Func.SetBoundaryForParameter(i, Boundary.Minimum, Boundary.Maximum);
        }
        ProjectionProblem SecondSolve = new ProjectionProblem(Func,Params.getStep());
        SecondSolve.SolveAndDisplayToConsole();
    }

    private void MinMaxAlgoritm() {
        MenuInputParameters Params = new MenuInputParameters();
        Params.ReadGradient(2);
        MathFunction Func = new MathFunction(Params.getInitialValues()) {
            
            @Override
            public double Result(double[] parameters) {
                return Math.pow(parameters[0], 2)+Math.pow(parameters[1], 2);
            }
            
            @Override
            public double[] Gradient(double[] parameters) {
                return new double[]{2*(parameters[0]),2*(parameters[1])};
            }
        };
        MathFunction SecondFunc = new MathFunction(Params.getInitialValues()) {            
            @Override
            public double Result(double[] parameters) {
                return Math.pow(parameters[0]-1, 2)+Math.pow(parameters[1]-2, 2);
            }
            
            @Override
            public double[] Gradient(double[] parameters) {
                return new double[]{2*(parameters[0]-1),2*(parameters[1]-2)};
            }
        };
        MinMaxProblem MinMax = new MinMaxProblem(Func, SecondFunc,Params.getStep());
        MinMax.SolveAndDisplayToConsole();
    }

    private void StochasticAlgoritm() {
        MenuInputParameters Params = new MenuInputParameters();
        Params.ReadStochastic(2);
        
         MathFunctionWithRandomValues StochasticFunc = new MathFunctionWithRandomValues(Params.getInitialValues(), Params.getDistrib()) {
            
            @Override
            public double Result(double[] parameters, double[] RandomValues) {
                return Math.pow(parameters[0] - RandomValues[0], 2)+Math.pow(parameters[0] - RandomValues[0], 2);//To change body of generated methods, choose Tools | Templates.
            }
            
            @Override
            public double[] Gradient(double[] parameters, double[] RandomValues) {
                return new double[]{2*(parameters[0] - RandomValues[0]),2*(parameters[1] - RandomValues[1])}; //To change body of generated methods, choose Tools | Templates.
            }
        };
        StochasticProblem SSolve = new StochasticProblem(StochasticFunc,Params.getStep());
        SSolve.SolveAndDisplayToConsole();
    }
}
