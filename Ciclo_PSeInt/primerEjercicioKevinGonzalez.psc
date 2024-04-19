Funcion Operacion ( obj, nums)
	Definir operar, i, k, validador, arr Como Real
	Dimensionar arr[nums]
	validador = 0
	Para k<-0 Hasta 1 Con Paso 1 Hacer
		Para i<-1 Hasta obj[k] Con Paso 1 Hacer
			Si obj[k] % i Es 0 Entonces
				validador = validador + 1
			FinSi
		Fin Para
		Si validador = 2 Entonces
			arr[k] = validador
			validador = 0
		FinSi
	FinPara	
	Si obj[0] > obj[1] Entonces
		validador = obj[0]
		obj[0] = obj[1]
		obj[1] = validador
	FinSi
	Si arr[0] = arr[1] Y obj[0] + 2 = obj[1] Entonces
		Escribir "Ambos numeros (", obj[0], ") (", obj[1], ") son primos Y gemelos"
	FinSi
Fin Funcion
Algoritmo primerEjercicioKevinGonzalez
	Definir bandera Como Logico
	Definir arr, nums, continue Como Real
	nums = 2
	Dimensionar arr[nums]
	Definir op, i Como Entero
	bandera = Verdadero
	Escribir "Comprobador de numeros primos gemelos:"
	Escribir "============================="
	Mientras bandera Hacer
		Escribir "Ingrese los valores a evaluar: "
		Para i<-0 Hasta nums-1 Con Paso 1 Hacer
			Leer arr[i]
		Fin Para
		Operacion(arr, nums)
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
