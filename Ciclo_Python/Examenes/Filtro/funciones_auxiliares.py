import csv
import json
import modulo_venta
import modulo_consulta

def validar_int(msg, msg_op=False):
    while True:
        try:
            if msg_op:
                msgs(msg_op)
                prompt = int(input(msg))
                return prompt
            else:
                prompt = int(input(msg))
                return prompt
        except:
            input("Debe ser un numero\n[ENTER - CONTINUAR]")

def validar_alpnum(msg):
    while True:
        prompt = input(msg)
        try:
            int(prompt)
            input("Debe ser alfanumerico\n[ENTER - CONTINUAR]")
        except:
            return prompt

def opener_catalogo():
    with open("Ciclo_Python/Examenes/Filtro/catalogo.csv", "r", encoding="utf-8") as file:
        objDictReader = csv.DictReader(file)
        return objDictReader

def opener_registro():
    try:
        with open("Ciclo_Python/Examenes/Filtro/db.json", encoding="utf-8") as file:
            registro = json.load(file)
            print("Registro de ventas cargado...")
            return registro
    except:
        estructura = {
            "usuarios":[],
            "pedidos":{
                "pagados": [],
                "pendientes": []
                }
            }
        export_registro(estructura)
        print("Registro de ventas creado...")


def export_registro(db):
    with open("registro.json", "a", encoding="utf-8") as file:
        to_export = json.dumps(db,ensure_ascii=False,indent=4)
        file.write(to_export)

def msgs(op):
    if op == 1:
        print("=" * 8 + " MENU PRINCIPAL " + "=" * 8 + "\n1 - Realizar Compra\n2 - Visualizar registro de ventas\n0 - Salir de programa")
    if op == "id":
        print("Ingrese su ID para continuar")
    if op == "bad_range":
        input("Seleccion fuera de rango\n[ENTER - REINTENTAR]")

def opcion_continuar(msg):
    while True:
        print(f"¿Desea continuar en [{msg}]?\n[Cualquier ingreso - SI]    [0 - NO]")
        op = validar_int("> ")
        if op == 0:
            return op
        else:
            break

def encontrar_usuario(catalogo):
    id = validar_int("> ", "id")
    usuarios = catalogo.get("usuarios")
    for pos,user in enumerate(usuarios):
        id_in_dict = user.get("id usuario")
        if id == id_in_dict:
            print("Usuario Encontrado...")
            return [pos, user]
    return id

def menu_principal(catalogo):
    while True:
        op = validar_int("> ", 1)
        if op == 0:
            print("> Bai")
            break
        elif op == 1:
            modulo_venta.inicio_modulo_compras(catalogo)
        elif op == 2:
            return
        else:
            msgs("bad_range")


