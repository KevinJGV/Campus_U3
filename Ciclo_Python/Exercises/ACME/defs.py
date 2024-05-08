import csv
import json


def leer_csv(ruta):
    just_open = open(ruta, "r")
    res = csv.reader(just_open, delimiter=";")
    return res


def csv_to_dict(ruta):
    item = csv.DictReader(ruta, delimiter=";")
    for i in item:
        print(i)


def menu(*opcs, **func_param):
    print("=" * 6 + " CENTRAL DE OBSERVATORIOS ACME " + "=" * 6 +
          "\n\n1 - Ver listado de observatorios (Ascendentemente por códigos)\n2 - Ver listado de observatorios (Ascendentemente por nombre)\n3 - Ver listado de observaciones sobre observatorio en particular (Ingresando su código)\n4 - Ver datos recopilados generales de un observatorio en particular (Ingresando su código)\n5 - Ver listado de observaciones a nivel nacional.\n6 - Ver listado sobre promedio de las observaciones a nivel nacional.\n7 - Salir \n" + "=" * 18)
    while True:
        try:
            op = int(input("> "))
            opcs[op-1](func_param)
            break
        except:
            print("/\\" * 8 + "\nIntente nuevamente\n" + "/\\" * 8)
