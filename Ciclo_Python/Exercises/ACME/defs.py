import csv
import json

def leer_txt(ruta):
    data = open(ruta, "r")
    res = csv.reader(data, delimiter=";")
    return res

