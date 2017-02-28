-- *** Exercise 5 - Practice 4 *** 

isPrime :: Int -> Bool
isPrime x = if ((divisoresRec x) == [1,x] || x == 1) then True 
					   else False

primes :: Int -> [Int]
primes x = take x [y | y <- [1..], isPrime y]

divisoresRec :: Int -> [Int]
divisoresRec x = divisores x [1..x]

divisores :: Int -> [Int] -> [Int]
divisores x [] = []
divisores x (y:xs) = if (x `mod`y == 0) then y : divisores x xs 
				      else divisores x xs 


--examples: 
-- isPrime 2 ==> True
-- primes 5  ==> [1,2,3,5,7]
