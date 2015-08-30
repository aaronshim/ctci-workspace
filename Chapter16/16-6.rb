
# the brute force solution checks every possible pair... so it's O(m*n)
def smallest_difference_brute(l1 = [], l2 = [])
  l1_min = l1.max
  l2_min = l2.min
  l1.each do |i1|
    l2.each do |i2|
      if i1 - i2 >= 0 && i1 - i2 < l1_min - l2_min
        l1_min = i1
        l2_min = i2
      end
    end
  end
  
  [l1_min, l2_min]
end

# if we sort, we bring this down to linearithmic
def smallest_difference(l1 = [], l2 = [])
  l1 = l1.sort
  l2 = l2.sort
  
  # and we take a mergesort-like comparison
end

puts smallest_difference_brute([1,3,15,11,2], [23,127,235,19,8])