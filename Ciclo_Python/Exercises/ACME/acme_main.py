import csv
import json


def int_val(msg):
    while True:
        try:
            prompt = int(input(msg))
            return prompt
        except:
            input("Error de ingreso \nIntente nuevamente\n(Enter para continuar)")


def input_ruta():
    while True:
        ruta = str(
            input("> Ingrese la ruta relativa del archivo de datos a procesar: "))
        try:
            with open(ruta, "r"):
                if ruta.endswith(".csv"):
                    print("Archivo csv cargado exitosamente...")
                    return [ruta, "csv"]
                elif ruta.endswith(".json"):
                    print("Archivo json cargado exitosamente...")
                    return [ruta, "json"]
                else:
                    input(
                        "Formato de archivo invalido, debe ser .csv/.json para este programa. \nIntente nuevamente\n(Enter para continuar)")
        except:
            input("Archivo no encontrado. \nIntente nuevamente\n(Enter para continuar)")


def opener(ruta, op):
    with open(ruta, encoding="utf-8") as file:
        if op == "csv":
            data = list(csv.DictReader(file, delimiter=";"))
            return data
        elif op == "json":
            data = json.load(file)
            return data


def ruta_validar(msg):
    while True:
        try:
            ruta = str(input(msg))
            if ruta.endswith("acme_main.py"):
                return ruta
            else:
                raise ValueError
        except:
            input("Asegurese de que la ruta es del archivo 'acme_main.py'. \nIntente nuevamente\n(Enter para continuar)")


def msgs(op):
    if op == 0:
        print("Para inicializar ingrese la ruta relativa actual de este scprit 'acme_main.py: ")
    elif op == 1:
        print("=" * 6 + " METEOROLOGIA ACME - PROGRAMA GESTOR v1 " + "=" * 6 +
              "\nPara iniciar porfavor asegurese de tener un archivo .csv/.json con el cual trabajar.")
    elif op == 2:
        print("=" * 6 + " MENU " + "=" * 6 +
              "\n1 - Ver listado de observatorios (Ascendentemente por códigos)\n2 - Ver listado de observatorios (Ascendentemente por nombre)\n3 - Ver listado de observaciones de un observatorio en particular (Ingresando su código)\n4 - Ver información general sobre un observatorio (Ingresando su código)\n5 - Ver listado de observaciones a nivel nacional (Paginado)\n6 - Ver listado sobre promedio de las observaciones a nivel nacional \n0 - Salir")
    elif op == 3:
        print("\n(Enter, regresar)")
    elif op == 4:
        print("Código del observatorio [0 - Volver]:")


def lista_ascendente_cod(data_in_kwargs):
    data = data_in_kwargs.get("datos")
    print("> Opcion 1\n")
    sorted_data = sorted(data, key=lambda elem: int(
        elem["Código Observatorio"]))
    visualizar_res(sorted_data)
    export_file(data_in_kwargs, sorted_data)


def lista_ascendente_nom(data_in_kwargs):
    data = data_in_kwargs.get("datos")
    print("> Opcion 2\n")
    sorted_data = sorted(data, key=lambda elem: elem["Nombre Observatorio"])
    visualizar_res(sorted_data)
    export_file(data_in_kwargs, sorted_data)


def lista_observatorio(data_in_kwargs):
    data = data_in_kwargs.get("datos")
    print("> Opcion 3\n")
    cod = comprobar_observatorio(data)
    if cod != 0:
        obs_filtrados = [dic for dic in data if int(
            dic["Código Observatorio"]) == cod]
        visualizar_res(obs_filtrados)
        export_file(data_in_kwargs, obs_filtrados)


def lista_datos_generales(data_in_kwargs):
    data = data_in_kwargs.get("datos")
    print("> Opcion 4\n")
    cod = comprobar_observatorio(data)
    if cod != 0:
        obs_filtrados = [dic for dic in data if int(
            dic["Código Observatorio"]) == cod]
        datos_procesados = proceso_opcion4(obs_filtrados)
        visualizar_res(datos_procesados)
        export_file(data_in_kwargs, datos_procesados)


def lista_paginada(data_in_kwargs):
    data = data_in_kwargs.get("datos")
    print("> Opcion 5\n")
    sorted_data = sorted(data, key=lambda elem: int(
        elem["Código Observatorio"]))
    visualizar_res(sorted_data, es_paginado=True)
    msgs(2)


def lista_por_promedio(data_in_kwargs):
    data = data_in_kwargs.get("datos")
    print("> Opcion 6\n")
    valores = set()
    res = []
    for dic in data:
        comparador = dic["Código Observatorio"]
        if comparador not in valores:
            valores.add(comparador)
            dict_to_fill = {}
            dict_to_fill["Código Observatorio"] = dic["Código Observatorio"]
            dict_to_fill["Nombre Observatorio"] = dic["Nombre Observatorio"]
            dict_to_fill["Promedio de temperaturas (ºC)"] = promedio_por_codigo(
                dic["Código Observatorio"], data)
            res.append(dict_to_fill)
    sorted_data = sorted(res, key=lambda elem: int(
        elem["Promedio de temperaturas (ºC)"]))
    visualizar_res(sorted_data)
    export_file(data_in_kwargs, sorted_data)


def promedio_por_codigo(codigo, data):
    promedio = 0
    TEMPMAXSTR = "Temperatura Máxima (°C)"
    TEMPMINSTR = "Temperatura Mínima (°C)"
    temp_db = []
    for dic in data:
        if str(dic["Código Observatorio"]) == str(codigo):
            dict_to_fill = {}
            dict_to_fill[TEMPMAXSTR] = dic[TEMPMAXSTR]
            dict_to_fill[TEMPMINSTR] = dic[TEMPMINSTR]
            temp_db.append(dict_to_fill)
    promedio = str(int(sum([sum([int(temp_i[TEMPMINSTR]) for temp_i in temp_db])/len(
        temp_db), sum([int(temp_i[TEMPMAXSTR]) for temp_i in temp_db])/len(temp_db)])/2))
    return promedio


def proceso_opcion4(filtred_data):
    res = [{}]
    res[0]["Código Observatorio"] = filtred_data[0]["Código Observatorio"]
    TEMPMAXSTR = "Temperatura Máxima (°C)"
    TEMPMINSTR = "Temperatura Mínima (°C)"
    res[0]["Total de registros"] = str(
        len(filtred_data))  # Cantidad observaciones
    temps_sorted = [sorted(filtred_data, key=lambda elem: int(elem[TEMPMAXSTR]), reverse=True), sorted(
        filtred_data, key=lambda elem: int(elem[TEMPMINSTR]))]
    # Temperatura maxima
    res[0]["Temperatura Máxima registrada (°C)"] = temps_sorted[0][0][TEMPMAXSTR]
    # Temperatura minima
    res[0]["Temperatura Mínima registrada (°C)"] = temps_sorted[1][0][TEMPMINSTR]
    res[0]["Promedio de temperaturas (ºC)"] = str(int(sum([sum([int(temp[TEMPMINSTR]) for temp in filtred_data])/len(
        # Promedio
        filtred_data), sum([int(temp[TEMPMAXSTR]) for temp in filtred_data])/len(filtred_data)])/2))
    return res


def comprobar_observatorio(data):
    while True:
        try:
            msgs(4)
            cod = int_val("> ")
            if cod == 0:
                return 0
            elif len([dic for dic in data if int(dic["Código Observatorio"]) == cod]) == 0:
                raise ValueError
            else:
                return cod
        except:
            input("Codigo no encontrado, ingrese un codigo existente en la base de datos. \nIntente nuevamente\n(Enter para continuar)")


def visualizar_res(config, es_paginado=False):
    if not es_paginado:
        keys = list(config[0].keys())
        header = " | ".join(keys) + "\n"
        final_data = header
        for dic in config:
            line = " | ".join(list(dic.values())) + "\n"
            final_data += line
        print(final_data)
    else:
        paginar_res(config)


def paginar_res(res):
    keys = list(res[0].keys())
    header = " | ".join(keys) + "\n"
    start = 0
    pag_size = 9
    while True:
        end = start + pag_size
        print(header)
        if end >= len(res):
            start -= pag_size
            end = len(res)
        if start < 0:
            start = 0
        seccion = res[start:end]
        current_page = ""
        for dic in seccion:
            line = " | ".join(list(dic.values())) + "\n"
            current_page += line
        print(current_page)
        print(f"\t< {start} / {end} >\n[0 - Pagina anterior]    [1 - Pagina siguiente]\n[2 - Volver]")
        movimiento = int_val("> ")
        if movimiento == 2:
            break
        elif movimiento == 1:
            start += pag_size
        elif movimiento == 0:
            if start != 0:
                start -= pag_size


def export_file(data_in_kwargs, config):
    current_route = data_in_kwargs.get("current_route")
    current_route = current_route.replace("acme_main.py", "export")
    # CSV
    header = list(config[0].keys())
    with open(current_route+".csv", "w", encoding="utf-8", newline="") as nuevo_archivo:
        dictobjet = csv.DictWriter(nuevo_archivo, header)
        dictobjet.writeheader()
        for line in config:
            dictobjet.writerow(line)
    # JSON
    jsonobject = json.dumps(config, indent=4, ensure_ascii=False)
    with open(current_route+".json", "w", encoding="utf-8") as nuevo_archivo:
        nuevo_archivo.write(jsonobject)
    msgs(3)
    input()
    msgs(2)


def menu_selector(*opcs, **kwargs):
    while True:
        try:
            op = int_val("> ")
            if op == 0:
                break
            elif op <= len(opcs):
                opcs[op-1](kwargs)
            else:
                raise ValueError
        except:
            input("Ingrese valor valido. \nIntente nuevamente\n(Enter para continuar)")


def main():
    msgs(0)
    ruta_actual = ruta_validar("> ")
    msgs(1)
    type_and_file = input_ruta()
    data = opener(type_and_file[0], type_and_file[1])
    msgs(2)
    menu_selector(lista_ascendente_cod, lista_ascendente_nom, lista_observatorio, lista_datos_generales,
                  lista_paginada, lista_por_promedio, datos=data, current_route=ruta_actual)


main()
