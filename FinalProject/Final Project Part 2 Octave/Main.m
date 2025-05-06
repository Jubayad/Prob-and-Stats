clear all;
close all;

% Set 1
% OriginalFormula.quadratic(-10, 10, "quadraticData1.csv");
% Salter.salter(10, "quadraticData1.csv", "quadraticSalted1.csv");
% Smoother.smoother(1, "quadraticSalted1.csv", "quadraticSmoothed1.csv");

% Set 2
% OriginalFormula.quadratic(-25, 25, "quadraticData2.csv");
% Salter.salter(25, "quadraticData2.csv", "quadraticSalted2.csv");
% Smoother.smoother(3, "quadraticSalted2.csv", "quadraticSmoothed2.csv");

% Set 3
% OriginalFormula.quadratic(-50, 50, "quadraticData3.csv");
% Salter.salter(50, "quadraticData3.csv", "quadraticSalted3.csv");
% Smoother.smoother(7, "quadraticSalted3.csv", "quadraticSmoothed3.csv");

% Set 1
% OriginalFormula.sine(-10, 10, "sineData1.csv");
% Salter.salter(10, "sineData1.csv", "sineSalted1.csv");
% Smoother.smoother(1, "sineSalted1.csv", "sineSmoothed1.csv");

% Set 2
% OriginalFormula.sine(-25, 25, "sineData2.csv");
% Salter.salter(25, "sineData2.csv", "sineSalted2.csv");
% Smoother.smoother(3, "sineSalted2.csv", "sineSmoothed2.csv");

% Set 3
% OriginalFormula.sine(-50, 50, "sineData3.csv");
% Salter.salter(50, "sineData3.csv", "sineSalted3.csv");
% Smoother.smoother(7, "sineSalted3.csv", "sineSmoothed3.csv");

% Set 1
OriginalFormula.absolute(-10, 10, "absoluteData1.csv");
Salter.salter(10, "absoluteData1.csv", "absoluteSalted1.csv");
Smoother.smoother(1, "absoluteSalted1.csv", "absoluteSmoothed1.csv");

% Set 2
% OriginalFormula.absolute(-25, 25, "absoluteData2.csv");
%Salter.salter(25, "absoluteData2.csv", "absoluteSalted2.csv");
%Smoother.smoother(3, "absoluteSalted2.csv", "absoluteSmoothed2.csv");

% Set 3
%OriginalFormula.absolute(-50, 50, "absoluteData3.csv");
%Salter.salter(50, "absoluteData3.csv", "absoluteSalted3.csv");
%Smoother.smoother(7, "absoluteSalted3.csv", "absoluteSmoothed3.csv");

pause;
