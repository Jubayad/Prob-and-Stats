function dataHandler(x, y, filename)
    fid = fopen(filename, 'w');                         % Opens the file and writes into it
    fprintf(fid, 'x,y\n');                              % Writes the header as x,y
    fprintf(fid, '%f,%f\n', [x(:) y(:)]');              % Writes the x,y coordinates pairs
    fclose(fid);                                        % Closes the file
    fprintf("Saved to: %s\n", filename);                % Prints the file name after successful saving to file
end