# EJ1
# Escribir un programa que almacene las asignaturas de un curso (por ejemplo Matemáticas, Física, Química, Historia y Lengua) en una lista y la muestre por pantalla.

""" lista = []

while True:
    inp = input("Ingrese materia (valor numerico para cerrar): ")
    try:
        if type(int(inp)) == int:
            break
    except ValueError:
        lista.append(inp)
result = [f"{lista.index(i)+1}) {i}" for i in lista] if len(lista) > 0 else "No hay materias :("
print("Materias almacenadas:\n", result) """

# EJ2
# Escribir un programa que almacene las asignaturas de un curso (por ejemplo Matemáticas, Física, Química, Historia y Lengua) en una lista y la muestre por pantalla el mensaje Yo estudio <asignatura>, donde <asignatura> es cada una de las asignaturas de la lista.

""" lista = []

while True:
    inp = input("Ingrese materia (valor numerico para cerrar): ")
    try:
        if type(int(inp)) == int:
            break
    except ValueError:
        lista.append(inp)
result = [f"Yo estudio {i}" for i in lista] if len(lista) > 0 else "No hay materias :("
print("Materias almacenadas:\n", result) """

# EJ3
# Escribir un programa que almacene las asignaturas de un curso (por ejemplo Matemáticas, Física, Química, Historia y Lengua) en una lista, pregunte al usuario la nota que ha sacado en cada asignatura, y después las muestre por pantalla con el mensaje En <asignatura> has sacado <nota> donde <asignatura> es cada una des las asignaturas de la lista y <nota> cada una de las correspondientes notas introducidas por el usuario.

""" def es_entero(arg):
    try:
        int(arg)
        return True
    except:
        return False

def append_lista(arg, lista):
    verify = es_entero(arg)
    if verify:
        arg = int(arg)
        if arg == 0:
            return 0
        else:
            lista.append(arg)
            return lista
    else:
        lista.append(arg)
        return lista

lista_a = []
lista_n = []

while True:
    input_a = append_lista(input("Ingrese materia (0 = salir): "), lista_a)
    if input_a == 0:
        break
    input_n = append_lista(input("Cual es la nota para dicha materia (0 = salir): "), lista_n)
    if input_n == 0:
        break

for elem_a, elem_n in zip(lista_a, lista_n):
    print(f"En {elem_a} has sacado {elem_n}") """

# EJ4
# Escribir un programa que almacene en una lista los números del 1 al 10 y los muestre por pantalla en orden inverso separados por comas.

""" lista = [1,2,3,4,5,6,7,8,9,10]
lista = [str(elem) for elem in lista]
lista.reverse()
string = ", ".join(lista)
print(string) """


# EJ5
# Escribir un programa que almacene las asignaturas de un curso (por ejemplo Matemáticas, Física, Química, Historia y Lengua) en una lista, pregunte al usuario la nota que ha sacado en cada asignatura y elimine de la lista las asignaturas aprobadas. Al final el programa debe mostrar por pantalla las asignaturas que el usuario tiene que repetir.

""" def es_entero(arg):
    try:
        int(arg)
        return True
    except:
        return False

def append_lista(arg, lista):
    verify = es_entero(arg)
    if verify:
        arg = int(arg)
        if arg == 0:
            return 0
        elif arg >= 60:
            return None
        else:
            lista.append(arg)
            return lista
    else:
        lista.append(arg)
        return lista

lista_a = []
lista_n = []

while True:
    input_a = append_lista(input("Ingrese materia (0 = salir): "), lista_a)
    if input_a == 0:
        break
    input_n = append_lista(input("Cual es la nota para dicha materia (0 = salir): "), lista_n)
    if input_n == None:
        input_a.pop()
    elif input_n == 0:
        break

for elem_a, elem_n in zip(lista_a, lista_n):
    print(f"Debe recuperar la asignatura de {elem_a}. Su nota fue de {elem_n}.") """

# EJ6
# Escribir un programa que almacene el abecedario en una lista, elimine de la lista las letras que ocupen posiciones múltiplos de 3, y muestre por pantalla la lista resultante.

""" import string
abecedario = list(string.ascii_lowercase)
res = [abecedario[i] for i in range(len(abecedario)) if (i+1) % 3 != 0]
print(res) """

# EJ7
# Escribir un programa que pida al usuario una palabra y muestre por pantalla si es un palíndromo

# EJ8
# Escribir un programa que pida al usuario una palabra y muestre por pantalla el número de veces que contiene cada vocal.

# EJ9
# Escribir un programa que almacene en una lista los siguientes precios, 50, 75, 46, 22, 80, 65, 8, y muestre por pantalla el menor y el mayor de los precios.

# EJ10
# Escribir un programa que pregunte por una muestra de números, separados por comas, los guarde en una lista y muestre por pantalla su media.
