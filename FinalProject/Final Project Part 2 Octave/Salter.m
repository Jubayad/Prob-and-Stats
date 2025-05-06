classdef Salter
    methods (Static)
        function salter(saltRange, inputFile, outputFile)
            data = csvread(inputFile, 1, 0);                     % Load CSV and skips the header or first row
            x = data(:, 1);                                      % Reads the first column of the data as x values
            y = data(:, 2);                                      % Reads the second column of the data as y values

            salt = (rand(size(y)) * 2 - 1) * saltRange;          % A random number between the negative saltRange and positive saltRange
            ySalted = y + salt;                                  % Adds the salted value to the y-value

            DataHandler(x, ySalted, outputFile);                 % Saves the salted data to a CSV file

            figure;
            plot(x, ySalted, 'r-', 'LineWidth', 1);             % Plots the salted data in red with a line width of 1
            title('Salted', 'FontSize', 20);                    % Title of the graph along with the font size
            xlabel('x');                                        % Label for the x-axis
            ylabel('y');                                        % Label for the y-axis
            grid on;                                            % Turns on the grid lines
        end
    end
end