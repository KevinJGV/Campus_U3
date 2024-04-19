Funcion Resultado <- Operacion ( obj, nums, opera )
	Definir Resultado, i Como Real
	Segun opera Hacer
		1:
			Resultado <- obj[0]
			Para i<-0 Hasta nums-1 Con Paso 1 Hacer
				Resultado <- Resultado + obj[i]
			Fin Para
		2:
			Resultado <- obj[0]
			Para i<-1 Hasta nums-1 Con Paso 1 Hacer
				Resultado <- Resultado - obj[i]
			Fin Para
		3:
			Resultado <- obj[0]
			Para i<-0 Hasta nums-1 Con Paso 1 Hacer
				Resultado <- Resultado * obj[i]
			Fin Para
		4:
			Resultado <- obj[0]
			Para i<-1 Hasta nums-1 Con Paso 1 Hacer
				Resultado <- Resultado / obj[i]
			Fin Para
		5:
			Resultado <- obj[0]
			Para i<-1 Hasta nums-1 Con Paso 1 Hacer
				Resultado <- Resultado % obj[i]
			Fin Para
		De Otro Modo:
			Escribir "No valido. Bai :)"
	Fin Segun
Fin Funcion

Algoritmo Calculadora
	Definir bandera Como Logico
	Definir arr, nums, continue Como Real
	Definir op, i, es_redimensionar Como Entero
	bandera = Verdadero
	es_redimensionar = 0
	Escribir "Calculadora de multiples entradas:"
	Escribir "============================="
	Mientras bandera Hacer
		Escribir "Cuantos valores va a operar?"
		Leer nums
		Si es_redimensionar = 1 Entonces
			Redimensionar arr[nums]
		SiNo
			Dimensionar arr[nums]
		FinSi
		Escribir "Ingrese los ", nums, " valores va a operar?"
		Para i<-0 Hasta nums-1 Con Paso 1 Hacer
			Leer arr[i]
		Fin Para
		Escribir "Operación?"
		Escribir "1 - Suma"
		Escribir "2 - Resta"
		Escribir "3 - Multiplicación"
		Escribir "4 - División"
		Escribir "5 - Modulo"
		Leer op
		Escribir Operacion(arr, nums, op)
		Escribir ""
		Escribir "Que crack ;)"
		Escribir "Deseas continuar?"
		Escribir "1 - Si"
		Leer continue
		Si continue <> 1 Entonces
			bandera = Falso
			Escribir "Bai :)"
		FinSi
		es_redimensionar = 1
	FinMientras
FinAlgoritmo
