## EJ1
'''
passw1 = input(str("Ingrese contraseña: "))
passw2 = input(str("Compruebe contraseña: "))
if passw1.lower() == passw2.lower(): print("Coincidencia :)")
'''

## EJ2
'''num1 = float(input("Dividendo: "))
num2 = float(input("Divisor: "))
if num2 == 0: 
    print("Error.")
else:
    print(int(num1 // num2))'''

## EJ3
""" num = int(input("Numero a evaluar: "))
if num % 2 == 0:
    print(f"Numero {num} es par.")
else:
    print(f"Numero {num} es impar.") """
    
## EJ4
""" user_age = int(input("Edad del usuario: "))
user_salary  = int(input("Ingresos mensuales del usuario: "))
r = "Pague impuestos." if user_age >= 16 and user_salary >= 1000 else "Trabaje vago!"
print(r) """
##EJ5
import re

user_sex = input("Sexo del usuario (M-F): ")
user_name = input("Nombre del usuario (M-F): ")
regexp_f = r"A-L"
regexp_m = r"A-M"
result_f = True if re.search(regexp_f,user_name[0], re.IGNORECASE) else False
result_m = True if re.search(regexp_m,user_name.split()[0], re.IGNORECASE) else False
if result_f and user_sex.lower() == "f":
    print("Perteneces al grupo A")
elif not result_f and user_sex.lower() == "f":
    print("Perteneces al grupo B")
elif result_m and user_sex.lower() == "m":
    print("Perteneces al grupo B")
else:
    print("Perteneces al grupo A")