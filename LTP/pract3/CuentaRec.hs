module CuentaRec where

cuentaRec :: Int -> Int -> Int
cuentaRec x y
  | x > y = 0
  | x <= y =  x+(cuentaRec (x+1) y)