import funciones_auxiliares


def inicio_modulo_consultas(registro):
    referencia_pedidos = registro.get("pedidos")
    body = " ID PEDIDO | CARRITO | FECHA | PRECIO \n"
    for claves,valor in referencia_pedidos.items():
        for pedido in valor:
            body += f" {pedido['id pedido']} | {len(pedido['carrito'])} Articulos | {pedido['fecha']} | ${pedido['valor']}\n"
    print(body)