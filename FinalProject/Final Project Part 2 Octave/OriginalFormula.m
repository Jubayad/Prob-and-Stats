classdef OriginalFormula
    methods (Static)
        function quadratic(lowerBound, upperBound, outputFile)   
            x = lowerBound:1:upperBound;                         % x starts from lower bound and goes to upper bound by increments of 1
            y = x.^2 - 4 * x + 3;                                % Making the quadratic formula

            DataHandler(x, y, outputFile);       % Saves the data to a CSV file

            figure;
            plot(x, y, 'b-', 'LineWidth', 1);                  % Plot in blue with a line width of 1
            title('Quadratic', 'FontSize', 20);  % Title of the graph along with font size
            xlabel('x'); 
            ylabel('y'); 
            grid on;
        end

        function sine(lowerBound, upperBound, outputFile)
            x = lowerBound:1:upperBound;                         % x starts from lower bound and goes to upper bound by increments of 1
            y = -2 * sin(x) + 1;                                 % Making the sine formula

            DataHandler(x, y, outputFile);       % Saves the data to a CSV file

            figure;
            plot(x, y, 'b-', 'LineWidth', 1);                 % Plot in blue with a line width of 1
            title('Sine', 'FontSize', 20);  % Title of the graph along with font size
            xlabel('x');
            ylabel('y');
            grid on;
        end

        function absolute(lowerBound, upperBound, outputFile)
            x = lowerBound:1:upperBound;                         % x starts from lower bound and goes to upper bound by increments of 1
            y = abs(x) - 2;                                      % Making the absolute formula

            DataHandler(x, y, outputFile);       % Saves the data to a CSV file

            figure;
            plot(x, y, 'b-', 'LineWidth', 1);                    % Plot in blue with a line width of 1
            title('Absolute', 'FontSize', 20);                   % Title of the graph along with font size
            xlabel('x');
            ylabel('y');
            grid on;
        end
    end
end