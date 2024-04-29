def es_primo(a):
    counter = 0
    for i in range(1,a+1):
        if a % i == 0:
            counter += 1
    return "Es primo" if counter == 2 else "No es primo"







es_primo(3)