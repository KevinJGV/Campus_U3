import funciones_auxiliares
from copy import deepcopy
from datetime import datetime
def inicio_modulo_compras(catalogo, registro, body=""):
    print("> Realizar Compra")
    res = funciones_auxiliares.encontrar_usuario(registro)
    if isinstance(res,list):
        body = modulo_compras(catalogo, registro, res[1],body=body)
    else:
        referencia_usuarios = registro.get("usuarios")
        usuario = {
            "id usuario":res,
            "id pedidos": []
        }
        referencia_usuarios.append(usuario)
        funciones_auxiliares.export_registro(registro)
        body = modulo_compras(catalogo, registro, referencia_usuarios[-1],body=body)
    return body

def modulo_compras(catalogo, registro, referencia_usuario, body=""):
    referencia_pedidos = registro["pedidos"]
    carrito = []
    catalogo_json = mostrar_catalogo(catalogo)
    while True:
        if body == "":
            print(catalogo_json[2])
        else:
            print(body)
        op = funciones_auxiliares.validar_int("> ","carrito")
        if op == -1:
            if not carrito:
                funciones_auxiliares.msgs("cancelar")
                return catalogo_json[2]
            else:
                pedido = generar_pedido(carrito, referencia_usuario)
                referencia_pedidos["creado"].append(pedido)
                funciones_auxiliares.export_registro(registro)
                print("Su pedido a sido creado satisfactoriamente...")
                finalizar_compra(referencia_pedidos, pedido, registro)
                return body
        elif op >= 0 and op <= catalogo_json[0]:
            res = seleccionar_cantidad(catalogo_json[1],op)
            if res is not None:
                carrito.append(res)
                print("Producto añadido al carrito...")
        elif op == "CANCELAR":
            funciones_auxiliares.msgs("cancelar")
            return catalogo_json[2]
        else:
            funciones_auxiliares.msgs("bad_range")


def mostrar_catalogo(catalogo, body=""):
    keys = None
    catalogo_json = {
        "Entrada" : [],
        "Plato Fuerte" : [],
        "Bebida" : []
    }
    big_pos = 0
    for pos, dic in enumerate(catalogo):
        # PARA ARMAR EL BODY EN LA TERMINAL
        if body == "":
            keys = list(dic.keys())
            keys.insert(0, " #")
            keys = [key.upper() for key in keys]
            body += " | ".join(keys) + "\n"
            body += "-" * len(body) + "\n"
        body += f" {pos} | {dic['categoria']} | {dic['producto']} | ${dic['precio']}\n"
        # PARA ESTRUCTURAR EL OBJETO DictReader COMO DICCIONARIO
        producto = {"id": pos,"nombre":dic["producto"],"precio":int(dic["precio"]), "cantidad": 0, "subtotal" : 0}
        if dic['categoria'] == "Entrada":
            entradas = catalogo_json.get("Entrada")
            entradas.append(producto)
            
        elif dic['categoria'] == "Plato Fuerte":
            platos = catalogo_json.get("Plato Fuerte")
            platos.append(producto)
        else:
            bebidas = catalogo_json.get("Bebida")
            bebidas.append(producto)
        big_pos = pos
    return [big_pos, catalogo_json, body]

def seleccionar_cantidad(catalogo_json, op):
    catalogo_json = deepcopy(catalogo_json)
    producto_escogido = None
    for categoria, valor_categoria in catalogo_json.items():
        for producto in valor_categoria:
            if producto["id"] == op:
                producto_escogido = producto
                break
        if producto_escogido:
            break
    if producto_escogido != None:
        while True:
            op = funciones_auxiliares.validar_int("> ", "cantidad")
            if op == 0:
                funciones_auxiliares.msgs("cancelar")
                break
            elif op >= 1:
                producto_escogido["cantidad"] = op
                producto_escogido["subtotal"] = producto_escogido["precio"] * op
                break
            else:
                print("Incorrecto")
    return producto_escogido


def generar_pedido(carrito, referencia_usuario):
    valor = 0
    for item in carrito:
        valor += item["subtotal"]
    ids = deepcopy(referencia_usuario["id pedidos"])
    big_digit = 0
    id_pedido = ""
    if len(ids) != 0:
        for id in ids:
            splited_id = id.split("-")
            big_digit = int(splited_id[-1]) + 1
        id_pedido = f"{str(referencia_usuario['id usuario'])}-{big_digit}"
    else:
        id_pedido = "1-1"
    fecha = datetime.now()
    fecha = fecha.strftime("%d-%m-%Y %H:%M:%S")
    pedido = {
                "id pedido":id_pedido,
                "carrito" : carrito,
                "fecha" : fecha,
                "valor" : valor
            }
    referencia_usuario["id pedidos"].append(id_pedido)
    return pedido

def finalizar_compra(referencia_pedidos,pedido, registro):
    id_pedido = pedido["id pedido"]
    while True:
        op = funciones_auxiliares.validar_int("> ", "pagar")
        if op == 1:
            for pos, pedido_creado in enumerate(referencia_pedidos["creado"]):
                if pedido_creado["id pedido"] == id_pedido:
                    referencia_pedidos["creado"].pop(pos)
            referencia_pedidos["preparacion"].append(pedido)
            funciones_auxiliares.export_registro(registro)
            print("Su pedido a sido pagado satisfactoriamente, pasa a estado: En preparacion")
            break
        elif op == 2:
            print("> Despuesito")
            break
        else:
            funciones_auxiliares.msgs("bad_range")