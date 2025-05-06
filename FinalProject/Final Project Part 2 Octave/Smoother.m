classdef Smoother
    methods (Static)
        function smoother(windowSize, inputFile, outputFile)
            data = csvread(inputFile, 1, 0);                     % Load CSV and skips the header or first row
            x = data(:, 1);                                      % Reads the first column of the data as x values
            y = data(:, 2);                                      % Reads the second column of the data as y values

            if windowSize < 1
                error('Window size must be at least 1');
            end

            if windowSize == 1
                ySmoothed = y;  % If window size is 1, return original data
            else
                ySmoothed = movmean(y, windowSize);              % Applies the moving average to the y values with the specified window size
            end

            DataHandler(x, ySmoothed, outputFile);               % Saves the smoothed data to a CSV file

            figure;
            plot(x, ySmoothed, 'g-', 'LineWidth', 1);           % Plots the smoothed data in green with a line width of 1
            title('Smoothed', 'FontSize', 20);                  % Title of the graph along with the font size
            xlabel('x');                                        % Label for the x-axis
            ylabel('y');                                        % Label for the y-axis
            grid on;                                            % Turns on the grid lines
        end
    end
end