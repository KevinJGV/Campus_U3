Funcion res <- cajero ( cop )
	Definir arr, i, contador Como Entero
	Dimensionar arr[4]
	Para i<-0 Hasta 3 Con Paso 1 Hacer
		arr[i] = 0
	Fin Para
	Si cop >= 100000 Entonces
		Para i<-1 Hasta cop Con Paso 100000 Hacer
			Si cop >= 100000 Entonces
				arr[3] = arr[3] + 1
				cop = cop - 100000
			Fin Si
		Fin Para
		Escribir  "Ha recibido ", arr[3], " Billetes de $100.000 COP."
	Fin Si
	Si cop >= 50000 Entonces
		Para i<-1 Hasta cop Con Paso 50000 Hacer
			Si cop >= 50000 Entonces
				arr[2] = arr[2] + 1
				cop = cop - 50000
			Fin Si
		Fin Para	
		Escribir  "Ha recibido ", arr[2], " Billetes de $50.000 COP."
	Fin Si
	Si cop >= 20000 Entonces
		Para i<-1 Hasta cop Con Paso 20000 Hacer
			Si cop >= 20000 Entonces
				arr[1] = arr[1] + 1
				cop = cop - 20000
			Fin Si
		Fin Para	
		Escribir  "Ha recibido ", arr[1], " Billetes de $20.000 COP."
	Fin Si
	Si cop >= 10000 Entonces
		Para i<-1 Hasta cop Con Paso 10000 Hacer
			Si cop >= 10000 Entonces
				arr[0] = arr[0] + 1
				cop = cop - 10000
			Fin Si
		Fin Para	
		Escribir  "Ha recibido ", arr[0], " Billetes de $10.000 COP."
	Fin Si
	Escribir ""
	Escribir "//////// Fin de la transaccion. /////////////"
Fin Funcion

Algoritmo tercerEjercicioKevinGonzalez
	Definir bandera, condicion Como Logico
	Definir continue, res_division Como Real
	Definir op, cop, i, num_trunc Como Entero
	bandera = Verdadero
	Escribir "Cajero Falso:"
	Escribir "============================="
	Mientras bandera Hacer
		Escribir "Monto desde 10.000 COP a retirar? (Debe ser multiplo de 10.000 COP)"
		Leer cop
		res_division = cop / 10000 
		num_trunc = trunc(res_division)
		Si res_division - num_trunc <> 0 o cop < 10000 Entonces
			condicion = Verdadero
		Sino 
			condicion = Falso
		FinSi
		Mientras condicion Hacer
			Escribir "Ingrese un monto que cumpla la condicion"
			Leer cop
			res_division = cop / 10000 
			num_trunc = trunc(res_division)
			Si res_division - num_trunc <> 0 o cop < 10000 Entonces
				condicion = Verdadero
			Sino 
				condicion = Falso
			FinSi
		Fin Mientras
		Escribir ""
		Escribir cajero(cop)
		Escribir ""
		Escribir "Bai"
		Escribir "Deseas continuar?"
		Escribir "1 - Si"
		Leer continue
		Si continue <> 1 Entonces
			bandera = Falso
			Escribir "Bai :)"
		FinSi
	FinMientras
FinAlgoritmo
