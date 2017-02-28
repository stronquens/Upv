-- *** Exercise 1 - Practice 4 *** 

decBin :: Int -> [Int]
decBin x = if x < 2 then [x]
           else (x `mod` 2) : decBin (x `div` 2)

-- example:
-- decBin 4 ==> [0,0,1]