
# DEFINICION DE LISTA PREDEFINIDA
palabras = ["amazijo", "aluminio", "algebra", "animal", "anaconda", "astal", "oler", "ostra", "langosta",
            "rata", "terraza", "terremoto", "limon", "litro", "loco", "raton", "remolino", "ruin", "rima", "tetra", "timbo", "tubo", "transexual", "ocre", "orca", "oblea", "orto", "natal", "nacar", "nacer", "negro", "esperanza", "estado", "estilo", "estrato", "emporio"]
palabras.sort()

# MENSAJE DE BIENVENIDA
print("\nBienvenid@ a este juego del diablo >:) " + "*" * 20 +
      f"\n\nA continuacion se le dara una palabra de una lista de 60 palabras ya predefinidas, cada jugador de forma alterna ingresara una nueva palabra que exista en la lista predefinida, debe tener en cuenta que la palabra nueva debe iniciar coincidiendo con la ultima letra de la palabra ingresada anterior de forma que se forme una cadena de palabras.\n\n Ejemplo: casA[palabra anterior] => Astro[nueva palabra]\n\n Para iniciar Jugador 1 ingrese un valor entre 0 y {len(palabras)} (Para salir del programa ingresar -1):\n")

# DECLARACION DE VARIABLES
op = int(input("> "))
print("Lista de palabras predefinidas:")
for word in palabras:
    print(f"{palabras.index(word)+1}) {word.title()}")
palabra_anterior = palabras[op]
palabra_actual = palabras[op]
player = 2
cadena_final = palabra_actual

# CUERPO PRINCIPAL DEL ALGORITMO
while op != "-1" or palabra_actual != "-1":
    palabra_actual = input(
        f"La palabra actual es : {palabra_actual}\nUltima letra: {palabra_actual[-1]}\nSiguiente jugador: Jugador {player}\n Siguiente palabra: >").lower()
    if palabra_actual[0] == palabra_anterior[-1] and palabras.count(palabra_actual) != 0:
        if player == 1:
            player = 2
        else:
            player = 1
        palabra_anterior = palabra_actual
        cadena_final += palabra_actual
    elif palabra_actual == "-1":
        print(f"Cadena formada:{cadena_final}\n> Salir")
        break
    else:
        print(
            f"'{palabra_actual}' NO COINCIDE con las reglas iniciales, intente nuevamente.\n(Enter - retry)")
        input()
        palabra_actual = palabra_anterior
