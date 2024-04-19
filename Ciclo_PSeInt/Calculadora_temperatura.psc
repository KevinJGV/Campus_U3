Funcion Resultado <- Operacion ( num,opera )
	Definir Resultado Como Real
	Segun opera Hacer
		1:
			Resultado <- (num - 32) * 5/9
		2:
			Resultado <- (num * 9/5) + 32
		De Otro Modo:
			Escribir "No valido. Bai :)"
	Fin Segun
Fin Funcion

Algoritmo Calculadora_temperatura
	Definir bandera Como Logico
	Definir num,continue Como Real
	Definir op Como Entero
	bandera = Verdadero
	Escribir "Calculadora de temperatura (ºC <-> ºF):"
	Escribir "============================="
	Mientras bandera Hacer
		Escribir "La temperatura esta en celsius (ºC) o farenheit (ºF)?"
		Escribir "1 - Celsius"
		Escribir "2 - Farenheit"
		Leer op
		Escribir "Temperatura a convertir?"
		Leer num
		Escribir Operacion(num,op)
		Escribir ""
		Escribir "Que crack ;)"
		Escribir "Deseas continuar?"
		Escribir "1 - Si"
		Leer continue
		Si continue <> 1 Entonces
			bandera = Falso
			Escribir "Bai :)"
		FinSi
	FinMientras
FinAlgoritmo
