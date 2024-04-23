# Funciones para Cadenas en PSeInt

## PSeInt

En PSeInt para hacer uso de una función se debe colocar su nombre seguido de los argumentos para la misma encerrados entre paréntesis. Este pseudolenguaje incorpora 7 funciones para cadenas:

- Longitud.
- SubCadena.
- Concatenar.
- ConvertirANúmero.
- ConvertirATexto.
- Mayúsculas.
- Minúsculas.

La función "Longitud" retorna la cantidad de caracteres que posee una cadena, un ejemplo de su uso sería: funcion<- Longitud(txt)

 

La función "SubCadena" opera con la estructura "{cadena, desde, hasta}" y en el pseudcódigo se vería de la siguiente manera:  funcion<- Subcadena(txt,1,7)



La función "Concatenar", retorna una nueva cadena que resulta de unir una cadena 1 con una cadena 2: funcion<- Concatenar(txt1, txt2)



Con la función "ConvertirANúmero" se recibe una cadena de caracteres que contiene un número y devuelve una variable numérica del mismo tipo con la que se podrán realizar operaciones de cualquier tipo, ejemplo: funcion<- ConvertirANumero(num)

 

La función contraria, es decir, "ConvertirATexto", recibe un dato numérico y lo convierte a cadena de texto, un ejemplo básico sería: funcion<- ConvertirATexto(num)



 

Las funciones "Mayusculas" y "Minusculas" toman una cadena de texto y convierten todos sus caracteres a la función especificada, por ejemplo:

funcion<- Mayusculas(txt)

funcion<- Minusculas(txt)