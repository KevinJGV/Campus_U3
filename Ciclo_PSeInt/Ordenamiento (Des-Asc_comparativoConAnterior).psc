Algoritmo Ordenamiento
	Definir asc, arr, nums, acum, i, j, op Como Entero
	Leer nums
	Dimensionar arr[nums]
	asc = 0
	acum = 0
	Escribir "Desorden"
	Para i<-0 Hasta nums-1 Hacer
		arr[i] <- azar(1000)
		Escribir arr[i]
	FinPara
	Escribir "Ascendente = 1"
	Leer asc
	Si asc = 1 Entonces
		Para i<-0 Hasta nums-2 Hacer
			Para j<-i+1 Hasta nums-1 Hacer
					Si arr[j] < arr[i] Entonces
						acum = arr[i]
						arr[i] = arr[j]
						arr[j] = acum
					FinSi
			FinPara
		FinPara
		Escribir "Orden Ascendente:"
		Para i<-0 Hasta nums-1 Hacer
			Escribir i+1,") ",arr[i]
		FinPara
	Sino
		Para i<-0 Hasta nums-2 Hacer
			Para j<-i+1 Hasta nums-1 Hacer
				Si arr[j] > arr[i] Entonces
					acum = arr[i]
					arr[i] = arr[j]
					arr[j] = acum
				FinSi
			FinPara
		FinPara
		Escribir "Orden Descendente:"
		Para i<-0 Hasta nums-1 Hacer
			Escribir i+1,") ",arr[i]
		FinPara
	FinSi
FinAlgoritmo