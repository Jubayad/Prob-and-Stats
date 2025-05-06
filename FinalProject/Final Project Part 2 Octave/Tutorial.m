npts = 8;

x = [1:npts]' / npts;
y = x + 0.2 * cos(12 .* x);


plot(x, y, '.', 'markersize', 20)

S = zeros(npts, npts);
for i = 1:npts
  for j = 1:npts
    S(i,j) = x(i)^(j - 1);
  end
end

S
Sinv = inv(S)
c = Sinv * y

np2 = 50;
x2 = [1:np2]' / np2;
y2 = x2;
fj = c;
for j = 1:np2
  for i = 1:npts
    fj(i) = x2(j)^(i - 1);
  end
  y2(j) = c' * fj;
end

hold on
plot(x2, y2)
