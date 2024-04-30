def es_primo(a):
    counter = 0
    for i in range(1, a+1):
        if a % i == 0:
            counter += 1
    return f"'{a}' Es primo" if counter == 2 else f"'{a}' No es primo"


def es_par(a):
    if a % 2 == 0:
        return f"Numero {a} es par."
    else:
        return f"Numero {a} es impar."


def media(a):
    return sum(a) / len(a)


def es_xz(a):
    letters = ["x", "z"]
    flag = False
    for letter in letters:
        for e in a:
            if letter == e:
                flag = True
    return f"'{a}' contiente la letra {letters[0]} o {letters[1]}" if flag else f"'{a}' NO contiente la letra {letters[0]} o {letters[1]}"


lista = []

while True:
    op = input("=" * 6 + " Menu multiproposito " + "=" * 6 +
               "\n\n1 - Comprobador de numero primo\n2 - Comprobador de numero par\n3 - Calculador de media\n4 - Finder de xz\n5 - Salir\n> ")
    if op == "1":
        prompt = int(
            input("> Comprobador de numero primo\n Número a evaluar?\n> "))
        print(es_primo(prompt))
        input()
    elif op == "2":
        prompt = int(
            input("> Comprobador de numero par\n Número a evaluar?\n> "))
        print(es_par(prompt))
        input()
    elif op == "3":
        print("> Calculador de media\n")
        while True:
            prompt = int(input("Números a evaluar? (-1 para terminar)\n> "))
            if prompt == -1:
                break
            else:
                lista.append(prompt)
        print(media(lista))
        input()
    elif op == "4":
        prompt = input("> Finder de xz\n Texto a evaluar?\n> ")
        print(es_xz(prompt))
        input()
    elif op == "5":
        print("> Salir")
        break
    else:
        print("Opcion Erronea.\n\n")
        input()
