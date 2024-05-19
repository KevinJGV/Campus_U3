import csv
import json

# ruta = open("Ciclo_Python\Exercises\ACME\db.csv", encoding="utf-8")
# jruta = open("Ciclo_Python\Exercises\ACME\db.json", encoding="utf-8")

# CSV>CSV - RECIBIDO EN DICCIONARIO -> ENTREGADO CON DICCIONARIO

# data = list(csv.DictReader(ruta, delimiter=";"))
# header = list(data[0].keys())
# with open("Ciclo_Python\Exercises\ACME\Resultados\ejemplocsv.csv","w",encoding="utf-8", newline="") as nuevo_archivo:
#     dictobjet = csv.DictWriter(nuevo_archivo, header)
#     dictobjet.writeheader()
#     for line in data:
#         dictobjet.writerow(line)

# CSV>JSON

# data = list(csv.DictReader(ruta, delimiter=";"))
# jsonobject = json.dumps(data,indent=4,ensure_ascii=False)
# with open("Ciclo_Python\Exercises\ACME\Resultados\ejemplojson.json","w", encoding="utf-8") as nuevo_archivo:
#     nuevo_archivo.write(jsonobject)

# JSON>CSV

# data = json.load(jruta)
# header = list(data[0].keys())
# with open("Ciclo_Python\Exercises\ACME\Resultados\ejemplocsvjson.csv","w",encoding="utf-8", newline="") as nuevo_archivo:
#     dictobjet = csv.DictWriter(nuevo_archivo, header)
#     dictobjet.writeheader()
#     for line in data:
#         dictobjet.writerow(line)

# JSON>JSON

# data = json.load(jruta)
# jsonobject = json.dumps(data,indent=4,ensure_ascii=False)
# with open("Ciclo_Python\Exercises\ACME\Resultados\ejemplojson.json","w", encoding="utf-8") as nuevo_archivo:
#     nuevo_archivo.write(jsonobject)

#ORGANIZACION DE DATOS

# nueva_estructura1 = sorted(data, key=lambda elem: int(elem["Temperatura Máxima (°C)"]))

# Ejemplo de archivo
# with open("Ciclo_Python\Exercises\ACME\Resultados\ejemplocsv_orden.csv","w",encoding="utf-8", newline="") as nuevo_archivo:
#     dictobjet = csv.DictWriter(nuevo_archivo, header)
#     dictobjet.writeheader()
#     for line in nueva_estructura1:
#         dictobjet.writerow(line)
