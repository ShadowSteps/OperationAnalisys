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
public class ProjectionProblem extends OperationAnalisysMinimumProblem{

    public ProjectionProblem(MathFunction ProblemFunction,double Step) {
        super(ProblemFunction,Step);
    }

    @Override
    protected Object AfterAlgorithFinish(double[] PastPoint, double[] Point) {
       return Function.PointInFunctionOrBoundary(Point);
    }

    @Override
    protected Object BeforeAlgorithPreparation(double[] Point) {
      return null;
    }

}
