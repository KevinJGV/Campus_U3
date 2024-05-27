import funciones_auxiliares


def inicio_modulo_compras(catalogo):
    print("> Realizar Compra")
    res = funciones_auxiliares.encontrar_usuario()
    if res != None:
        modulo_compras(res,catalogo)
    else:
        usuario = {
            "id usuario":res,
            "id pedidos": []
        }
        modulo_compras(usuario,catalogo)

def modulo_compras(estructura,catalogo):
    if isinstance(estructura, list):
        
    else:
        print("cuando el usuario es recien creado")