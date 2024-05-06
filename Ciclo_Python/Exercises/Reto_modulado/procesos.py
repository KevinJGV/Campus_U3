# def validar_estructura(est,op):
#     try:
#         if op == 1:
#             isinstance(est, list)
#         elif op == 2:
#             isinstance(est, dict)
#         elif op == 3:
#             isinstance(est, set)
#         else:

def min_10employees(structure):
    corps_ok = {}
    for key_str, value_str in structure.items():
        if isinstance(value_str, list):
            for obj in value_str:
                if isinstance(obj, dict):
                    if obj["departamento"] == "Recursos Humanos":
                        if obj["empleados"] > 10:
                            corps_ok[key_str] = obj["empleados"]
    print("Empresas con màs de 10 empleados en su estructura:")
    for i in corps_ok:
        print(f"{i} => {corps_ok[i]}")


def promedio():
    promedios = {}
    for key_str, value_str in structure.items():
        return


def double_amount():
    return


def remake_structure():
    return

# for i, (key_str, value_str) in enumerate(structure.items(), start=1):
