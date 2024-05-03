def loop(est, base=0):
    tab = "\t" * base
    for i, (key_est, value_est) in enumerate(est.items(), start=1):
        print(f"{tab}{i}) {key_est} {value_est} ¬\n")
        if isinstance(value_est, dict):
            loop(value_est, base+1)

estructura_academica = {"SEDE": {"San Pepito": {"JORNADA": {"Mañana": {"CURSO": {"6A": {
    "ESTUDIANTE": {"Kevin": {"ASIGNATURA": {"Artistica": {"Docente": "Jaime", "Nota actual": "5"}}}}}}}}}}, "Sapo": {}}

loop(estructura_academica)