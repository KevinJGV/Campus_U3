Funcion PSePaint ( opera, altura )
	Definir i Como Real
	Definir Resultado Como Caracter
	Resultado = "*"
	Segun opera Hacer
		1:
			Escribir ""
			Escribir "Toma tu triagulo mi compa"
			Escribir ""
			Para i<-1 Hasta altura Con Paso 1 Hacer
				Escribir i,") ", Resultado
				Resultado = Resultado + "*"
			Fin Para
		2:
			Escribir ""
			Escribir "Toma tu cuadrado mi compa"
			Escribir ""
			Para i<-1 Hasta altura Con Paso 1 Hacer
				Resultado = Resultado + "*"
			Fin Para
			Para i<-1 Hasta altura Con Paso 1 Hacer
				Escribir i,") ", Resultado
			Fin Para
		De Otro Modo:
			Escribir "No valido. Bai :)"
	Fin Segun
Fin Funcion

Algoritmo segundoEjercicioKevinGonzalez
	Definir bandera Como Logico
	Definir continue Como Real
	Definir op, h, i Como Entero
	bandera = Verdadero
	Escribir "CubiPaint / TriPaint:"
	Escribir "============================="
	Mientras bandera Hacer
		Escribir "Triangulo o Cuadrado?"
		Escribir "1 - Triangulo"
		Escribir "2 - Cuadrado"
		Leer op
		Escribir "Cuantas lineas de altura desea? (Mayor a 1)"
		Leer h
		Mientras h <= 1 Hacer
			Escribir "Cuantas lineas de altura desea? (Mayor a 1)"
			Leer h
		Fin Mientras
		PSePaint(op, h)
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
