""" Dada la siguiente estructura de datos:

Crea un menú que se repita hasta que el usuario ingrese la opción de salida(a tu elección) y utilice una función para cada opción válida. Las funcionalidades son:

Mostrar cuántas empresas tienen más de 10 empleados en Recursos Humanos

Mostrar el promedio de empleados por departamento(teniendo en cuenta todas las empresas para cada calculo)

Mostrar cuántas empresas tienen el doble o más del doble de empleados en operaciones con respecto a ventas

Mostrar una nueva estructura de datos reorganizada donde las llaves del diccionario principal no sea empresas sino por departamento.
 """
import procesos

Empresas = {
    "Empresa 1": [{"departamento": "Recursos Humanos", "empleados": 5}, {"departamento": "Contabilidad", "empleados": 4}, {"departamento": "Ventas", "empleados": 10}, {"departamento": "Operaciones", "empleados": 25}],
    "Empresa 2": [{"departamento": "Recursos Humanos", "empleados": 10}, {"departamento": "Contabilidad", "empleados": 15}, {"departamento": "Ventas", "empleados": 25}, {"departamento": "Operaciones", "empleados": 41}],
    "Empresa 3": [{"departamento": "Recursos Humanos", "empleados": 8}, {"departamento": "Contabilidad", "empleados": 20}, {"departamento": "Ventas", "empleados": 32}, {"departamento": "Operaciones", "empleados": 56}],
    "Empresa 4": [{"departamento": "Recursos Humanos", "empleados": 5}, {"departamento": "Contabilidad", "empleados": 8}, {"departamento": "Ventas", "empleados": 15}, {"departamento": "Operaciones", "empleados": 29}],
    "Empresa 5": [{"departamento": "Recursos Humanos", "empleados": 20}, {"departamento": "Contabilidad", "empleados": 35}, {"departamento": "Ventas", "empleados": 58}, {"departamento": "Operaciones", "empleados": 97}],
}

menu = procesos.min_10employees, procesos.promedio, procesos.double_amount, procesos.remake_structure

while True:
    op = int(input("=" * 6 + " Menu multiproposito " + "=" * 6 +
             "\n\n1 - Empresas con +10 Empleados\n2 - Promedio de empleados por departamento\n3 - Empresas con >= x2 empleados de operaciones respecto a ventas\n4 - Reestructuracion de datos\n5 - Salir\n> "))
    # try:
    if op != 5:
        print(menu[op-1](Empresas))
    else:
        print("> Saliendo...")
        break
    # except:
    #     print("Opcion invalida.")
