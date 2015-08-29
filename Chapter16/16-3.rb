class Point
  include Comparable
  attr_accessor :x, :y
  
  def initialize(x=0.0,y=0.0)
    # we can use Kernel#Float instead if we want noisy failure
    @x = x.to_f
    @y = y.to_f
  end
  
  #x and then y for ordering
  def <=>(point)
    raise "Must compare to another point" unless point.is_a? Point
    if self.x < point.x
      -1
    elsif self.x > point.x
      1
    else
      if self.y < point.y
        -1
      elsif self.y > point.y
        1
      else
        0
      end
    end
  end
  
  # override
  def to_s
    "(#{self.x},#{self.y})"
  end
end

class Line
  include Comparable
  attr_accessor :start_point, :end_point, :slope, :intercept
  
  def initialize(start_point=Point.new(1.0,0.0),end_point=Point.new(0.0,0.0))
    raise "Must input two points to define a line" unless start_point.is_a? Point and end_point.is_a? Point
    @start_point = start_point
    @end_point = end_point
    raise "Cannot compute slope of a line with same point as endpoints" if start_point == end_point
    # force NaN by forcing instance of float
    @slope = (end_point.y - start_point.y + 0.0) / (end_point.x - start_point.x)
    @intercept = end_point.y - @slope * end_point.x
  end
  
  #sort by slope first
  def <=>(line)
    if self.slope > line.slope
      1
    elsif self.slope < line.slope
      -1
    else
      if self.intercept > line.intercept
        1
      elsif self.intercept < line.intercept
        -1
      else
        0
      end
    end
  end
  
  # override
  def to_s
    if self.intercept >= 0
      "y = #{self.slope} x + #{self.intercept}"
    else
      "y = #{self.slope} x #{self.intercept}"
    end
  end
  
end

def intersect(line1=Line.new, line2=Line.new)
  # case dealing with verticals
  # (finite? is not nan? and not infinite?)
  unless line1.slope.finite? and line2.slope.finite?
    if not (line1.slope.finite? or line2.slope.finite?)
      raise "Does not intersect" unless line1.start_point.x == line2.start_point.x
      return line1.start_point
    elsif not line1.slope.finite?
      x = line1.start_point.x
      return Point.new(x, line2.slope*x + line2.intercept)
    else
      x = line2.start_point.x
      return Point.new(x, line1.slope*x + line1.intercept)
    end
  end
  
  if line1.slope == line2.slope
    raise "Does not intersect" unless line1 == line2
    return line1.start_point #just any point that fits the bill
  end
  
  # set order of subtraction now
  if line1 > line2
    big_line = line1
    small_line = line2
  else
    big_line = line2
    small_line = line1
  end
  
  x = (small_line.intercept - big_line.intercept) / (big_line.slope - small_line.slope)
  y = big_line.slope * x + big_line.intercept
  
  return Point.new(x,y)
end

# test code

p1 = Point.new(1,0)
p2 = Point.new(1,3)

p3 = Point.new(0,0)
p4 = Point.new(5,5)

puts intersect(Line.new(p1,p2), Line.new(p3,p4))