-- *** Exercise 2 - Practice 4 *** 

binDec :: [Int] -> Int
binDec (x:[]) = x
binDec (x:y)  = x + binDec y * 2

-- example:
-- binDec [0,1,1] ==> 6