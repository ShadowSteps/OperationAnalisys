/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.operationanalisys.main;

import com.shadows.operationanalisys.math.function.MathFunction;
import com.shadows.operationanalisys.math.mathoptimization.MiniminizationProblem;
import java.util.Scanner;

/**
 *
 * @author John
 */
public class ConsoleClient {
    public static void main( String[] args )
    {
        MathFunction Func = new MathFunction(new double[]{0,0}) {
            
            @Override
            public double Result(double[] parameters) {
                return Math.pow(parameters[0]-1, 2)+Math.pow(parameters[1]-2, 2);
            }
            
            @Override
            public double[] Gradient(double[] parameters) {
                return new double[]{2*(parameters[0]-1),2*(parameters[1]-2)};
            }
        };
        MiniminizationProblem Solve = new MiniminizationProblem(Func);
        Solve.SolveAndDisplayToConsole();
    }
}
