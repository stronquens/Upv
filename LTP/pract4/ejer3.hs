-- *** Exercise 3 - Practice 4 *** 

divisoresRec :: Int -> [Int]
divisoresRec x = divisores x [1..x]

divisores :: Int -> [Int] -> [Int]
divisores x [] = []
divisores x (y:xs) = if (x `mod`y == 0) then y : divisores x xs 
				      else divisores x xs 
-- example: 
-- divisors 24 ==> [1,2,3,4,6,8,12,24]