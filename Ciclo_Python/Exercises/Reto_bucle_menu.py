def es_primo():
    counter = 0
    a = int(input("> Comprobador de numero primo\n Número a evaluar?\n> "))
    for i in range(1, a+1):
        if a % i == 0:
            counter += 1
    return f"'{a}' Es primo" if counter == 2 else f"'{a}' No es primo"


def es_par():
    a = int(input("> Comprobador de numero par\n Número a evaluar?\n> "))
    if a % 2 == 0:
        return f"Numero {a} es par."
    else:
        return f"Numero {a} es impar."


def media():
    lista = []
    list_len = 0
    print("> Calculador de media\n")
    while True:
        a = int(input("Números a evaluar? (-1 para terminar)\n> "))
        if a == -1:
            list_len = len(lista)
            break
        else:
            lista.append(a)
    return sum(lista) / list_len


def es_xz():
    a = input("> Finder de xz\n Texto a evaluar?\n> ")
    letters = ["x", "z"]
    flag = False
    for letter in letters:
        for e in a:
            if letter == e:
                flag = True
    return f"'{a}' contiente la letra {letters[0]} o {letters[1]}" if flag else f"'{a}' NO contiente la letra {letters[0]} o {letters[1]}"


menu = es_primo, es_par, media, es_xz

while True:
    op = int(input("=" * 6 + " Menu multiproposito " + "=" * 6 +
             "\n\n1 - Comprobador de numero primo\n2 - Comprobador de numero par\n3 - Calculador de media\n4 - Finder de xz\n5 - Salir\n> "))
    if op != 5:
        print(menu[op-1]())
    else:
        print("> Saliendo...")
        break
