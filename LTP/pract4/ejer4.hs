-- *** Exercise 4 - Practice 4 *** 

member :: Int -> [Int] -> Bool
member x [] = False
member x (y:xs) = if x == y then True 
			    else member x xs

member2 :: Int -> [Int] -> Bool
member2 x (y:xs)
  | x == y = True
  | xs == [] = False
  | otherwise = member2 x xs
			    
			    
-- examples: 
-- member 1 [1,2,3,4,8,9] ==> True
-- member 0 [1,2,3,4,8,9] ==> False
