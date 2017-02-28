module NumCbetw2 where
import Data.Char
numCbetw2 :: Char -> Char -> Int -- (Char, Char) -> Int
numCbetw2  x y --(x , y)
  | x > y = ((ord x) - (ord y) -1)
  | x < y = ((ord y) - (ord x) -1)
  | x == y = 0