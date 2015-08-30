
# given an integer n, find the biggest power of a given factor that fits into n
def biggest_factor(n = 0, factor = 2)
  n = n.to_i
  factor = factor.to_i
  if n % factor == 0
    return 1 + biggest_factor(n / factor, factor)
  else
    return 0
  end
end

# count trailing zeroes (find the number of 2 and 5 factors)
def factorial_zeroes(n)
  two_power = 0
  five_power = 0

  (1..n).each do |i|
    two_power += biggest_factor(i, 2)
    five_power += biggest_factor(i, 5)
  end

  [two_power, five_power].min
end

def factorial(n)
  return 1 if n < 1
  n * factorial(n - 1)
end

def test_factorial_zeroes(n)
  puts "#{n}! = #{factorial(n)}, #{factorial_zeroes(n)} zeroes trailing"
end

test_factorial_zeroes(0)
test_factorial_zeroes(1)
test_factorial_zeroes(2)
test_factorial_zeroes(10)
test_factorial_zeroes(32)
test_factorial_zeroes(500)
