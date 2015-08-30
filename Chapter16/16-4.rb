class TicTacToeBoard
  def initialize(n=3)
    # initialize array of zeroes
    n = n.to_i
    @board = Array.new(n) { Array.new(n, 0) }
  end
  
  def set!(x=0,y=0,player=1)
    @board[x][y] = player
  end
  
  def show_board
    @board.each do |inner|
      inner.each do |square|
        print "#{square}\t"
      end
      print "\n"
    end
  end
  
  # 0 for no one, other integer for player number
  def won?
    #diagonals first
    has_left_diagonal = true
    has_right_diagonal = true
    (1..@board.length-1).each do |i|
      has_left_diagonal = false unless @board[i][i] == @board[0][0]
      has_right_diagonal = false unless @board[i][-1-i] == @board[0][-1]
    end
    return @board[0][0] if has_left_diagonal
    return @board[-1][0] if has_right_diagonal
    
    #check rows
    (0..@board.length-1).each do |i|
      #slightly more concise but costly ( O(n^2) per uniq ) than a manual check
      return @board[i][0] if @board[i].uniq.length == 1
    end
    
    #check columns
    (0..@board.length-1).each do |i|
      player = @board[0][i]
      has_column = true
      (1..@board.length-1).each do |j|
        has_column = false unless @board[j][i] == player
      end
      return player if has_column
    end
    
    return 0
  end
end

board = TicTacToeBoard.new(3)
board.set!(0,0,1)
board.set!(1,1,2)
board.set!(2,2,1)
board.set!(0,1,2)
board.set!(2,1,2)

board.show_board
puts "player #{board.won?} won the game!"